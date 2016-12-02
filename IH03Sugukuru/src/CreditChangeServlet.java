
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Common;
import dbhelper.DBHelper;

/**
 * Servlet implementation class CreditChangeServlet
 */
@WebServlet("/CreditChangeServlet")
public class CreditChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreditChangeServlet() {
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
		String strjsp = "ListEstimate.jsp";

		DBHelper dbHelper = new DBHelper();
		Common common = new Common();
		String est_code = request.getParameter("est_code");
		String credit_over_status = request.getParameter("credit_over_status");
		String client_code = request.getParameter("client_code");
		String total = request.getParameter("total");
		
		if (common.parseIntegerforString(credit_over_status) != 0) {
			dbHelper.insertCreditChange(est_code, client_code, common.parseIntegerforString(total),
					common.parseIntegerforString(credit_over_status));
		}

		/* ページ遷移 */
		RequestDispatcher rd = request.getRequestDispatcher("./" + strjsp);
		rd.forward(request, response);

	}

}
