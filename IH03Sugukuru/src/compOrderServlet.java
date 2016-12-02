
/**
 * Author : I.Asakawa
 * Created date : 2016/11/30
 * 
 * description : 見積を受注に登録する処理
 */

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Common;
import dbhelper.DBHelper;

/**
 * Servlet implementation class compOrderServlet
 */
@WebServlet("/compOrderServlet")
public class compOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public compOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		/* 文字化け対策 */
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		/* jspString */
		String strjsp = "compOrder.jsp";

		Common common = new Common();
		DBHelper dbHelper = new DBHelper();

		String est_code = request.getParameter("est_code");
		String client_code = request.getParameter("client_code");
		String total = request.getParameter("total");
		String remark = request.getParameter("remark");

		String products_code[] = request.getParameterValues("products_code");
		String quantity[] = request.getParameterValues("quantity");
		String sub_total[] = request.getParameterValues("sub_total");

		// 受注番号の作成
		String code = est_code.substring(5, 14);
		StringBuffer sb = new StringBuffer();
		sb.append("20001");
		sb.append(code);// 後ろ9桁分
		String order_code = sb.toString();

		// 受注日取得
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = common.CurrentDate();
		String orderDate = sdf.format(date);

		// 受注に必要な内容（受注番号、見積番号、クライアントコード、受注日、総合計金額、備考）
		dbHelper.insertOrder(order_code, est_code, client_code, orderDate, common.parseIntegerforString(total), remark);
		// 受注明細に必要な内容（受注番号、商品コード、数量、合計金額）
		for (int a = 0; a < products_code.length; a++) {
			String proCode = products_code[a];
			String Quantity = quantity[a];
			String subTotal = sub_total[a];
			// 受注明細に挿入
			dbHelper.insertOrderDetail(order_code, proCode, common.parseIntegerforString(Quantity),
					common.parseIntegerforString(subTotal));

			// 各商品の在庫減少
			dbHelper.updateProductStocks(proCode, Quantity);

		}

		// ここから与信限度額の減少
		dbHelper.uodateCredit(client_code, common.parseIntegerforString(total));

		// 見積の受注完了アップデート
		int status_code = 4;
		dbHelper.statusUpdate(est_code, status_code);

		// 在庫が不足しているか
		ArrayList<HashMap<String, String>> array = new ArrayList<HashMap<String, String>>();
		array = dbHelper.getEstQuantity(client_code);

		int stock = 0;
		int estQuantity = 0;
		String estCode = "";
		if (array.size() != 0) {
			for (int a = 0; a < array.size(); a++) {
				HashMap<String, String> hashMap = new HashMap<String, String>();
				hashMap = array.get(a);

				stock = common.parseIntegerforString(hashMap.get("stock"));
				estQuantity = common.parseIntegerforString(hashMap.get("estQuantity"));
				estCode = hashMap.get("estCode");

				if (estQuantity > stock) {
					status_code = 2;
					dbHelper.statusUpdate(estCode, status_code);
				}
			}
		}

		// 見積の与信限度がオーバーしているか

		ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
		arrayList = dbHelper.getClientEst(client_code);
		int estTotal = 0;
		int creditLimit = 0;

		if (arrayList.size() != 0) {
			for (int a = 0; a < arrayList.size(); a++) {
				HashMap<String, String> hashMap = new HashMap<String, String>();
				hashMap = arrayList.get(a);

				estCode = hashMap.get("estCode");
				estTotal = common.parseIntegerforString(hashMap.get("estTotal"));
				creditLimit = common.parseIntegerforString(hashMap.get("creditLimit"));

				if (estTotal > creditLimit) {
					status_code = 3;
					dbHelper.statusUpdate(estCode, status_code);
				}

			}
		}

		/* ページ遷移 */
		RequestDispatcher rd = request.getRequestDispatcher("./" + strjsp);
		rd.forward(request, response);
	}

}
