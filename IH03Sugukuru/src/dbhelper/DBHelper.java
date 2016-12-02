package dbhelper;

import java.util.ArrayList;
import java.util.HashMap;

import common.Common;
import dao.DBAccess;

public class DBHelper {

	// コンストラクタ生成
	DBAccess dba = new DBAccess();
	// SQL用
	String sql = "";
	// 戻り値用ArrayList
	ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();

	// HashMap
	HashMap<String, String> hashMap = new HashMap<String, String>();
	//common
	Common common = new Common();

	/* Maru */

	/* Ishii */

	/* Asakawa */

	/**
	 * 従業員のログインで使用
	 * 
	 * @param code
	 * @param pass
	 * @return hashMap
	 */
	public HashMap<String, String> findEmp(String code, String pass) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		sql = "select * from ss_employee where employee_code = '" + code + "' and password = '" + pass + "'";
		arrayList = dba.getRecord(sql);

		if (arrayList.size() != 0) {
			hashMap = arrayList.get(0);
		} else {
			hashMap = null;
		}
		return hashMap;
	}

	/**
	 * 取引先一覧取得
	 * 
	 * @return arrayList
	 */
	public ArrayList<HashMap<String, String>> findClient() {

		sql = "select client_code,client_name from ss_client";
		arrayList = dba.getRecord(sql);

		return arrayList;
	}

	/**
	 * 売価を取得
	 * 
	 * @param pro_code
	 * @return yen
	 */
	public int getProductPrice(String pro_code) {
		int yen = 0;

		sql = "select sell_price from ss_products where products_code = " + pro_code;
		arrayList = dba.getRecord(sql);
		if (arrayList.size() != 0) {
			hashMap = arrayList.get(0);
			String sell = hashMap.get("sell_price");
			Common common = new Common();
			yen = common.parseIntegerforString(sell);
		}
		return yen;
	}

	/**
	 * 見積データの挿入
	 * 
	 * @param estCode
	 * @param clientCode
	 * @param tail
	 * @param post
	 * @param position
	 * @param person
	 * @param subject
	 * @param remark
	 * @param date
	 */
	public void insertEstimate(String estCode, String clientCode, String tail, String post, String position,
			String person, String subject, String remark, String date, int Total, String employee_code,String status,int tax) {

		sql = "insert into ss_estimation(estimation_code,client_code,tail,post,position,person,subject,remark,estimated_date,total,employee_code,approval_status,tax) values('"
				+ estCode + "','" + clientCode + "','" + tail + "','" + post + "','" + position + "','" + person + "','"
				+ subject + "','" + remark + "','" + date + "'," + Total + ",'" + employee_code + "','"+ status +"'," + tax + ")";
		dba.insertRecord(sql);
	}

	/* 見積詳細を挿入 */
	public void insertEstContent(String estCode, String product_code, int quantity, String unit, int SubTotal) {

		sql = "insert into ss_estimate_particulars values('" + estCode + "','" + product_code + "'," + quantity + ",'"
				+ unit + "'," + SubTotal + ")";

		dba.insertRecord(sql);
	}

	/* 商品があるかどうか */
	public String selectProductCode(String srtCode) {

		String code = "";

		sql = "select products_code from ss_products where products_code = '" + srtCode + "'";

		arrayList = dba.getRecord(sql);
		if (arrayList.size() != 0) {
			hashMap = arrayList.get(0);
			code = hashMap.get("products_code");
		}
		System.out.println(code);
		return code;
	}
	
	/* 見積一覧取得 */
	public ArrayList<HashMap<String, String>> getEstimateList(){
		
		sql = "select est.estimation_code est_code,est.estimated_date est_date,cl.client_name client_name,est.total total,est.approval_status status,est.remark remark ,(select count(*) from ss_estimation) count"
				+ " from ss_estimation est "
				+ "inner join ss_client cl on est.client_code = cl.client_code order by estimated_date desc";
		
		arrayList = dba.getRecord(sql);
		
		return arrayList;
	}
	
	/* 与信残高の確認 */
	public boolean confCredit(String client_code, int estTotal){
		
		boolean flg = false;
		int credit_limit = 0;
		Common common = new Common();
		
		sql = "select credit_limit from ss_client where client_code = '" + client_code + "'";
		
		arrayList = dba.getRecord(sql);
		if (arrayList.size() != 0) {
			hashMap = arrayList.get(0);
			credit_limit = common.parseIntegerforString(hashMap.get("credit_limit"));
		}
		if(estTotal <= credit_limit){
			flg = true;
		}
		
		return flg;
	}
	
	/* 在庫の取得 */
	public boolean confStock(String product_code, int num){
		
		boolean flg = false;
		int stock = 0;
		Common common = new Common();
		
		sql = "select stock_num from ss_products where products_code = '" + product_code + "'";
		
		arrayList = dba.getRecord(sql);
		if (arrayList.size() != 0) {
			hashMap = arrayList.get(0);
			stock = common.parseIntegerforString(hashMap.get("stock_num"));
		}
		if(num <= stock){
			flg = true;
		}
		
		return flg;
	}
	
	
	/* 見積詳細内容 */
	public ArrayList<HashMap<String, String>> getEstContent(String estCode){
		
		sql = "select pro.products_code,pro.products_name, pro.sell_price, est_p.quantity, est_p.unit, est_p.sub_total "
				+ "from ss_estimate_particulars est_p "
				+ "inner join ss_products pro on est_p.product_code = pro.products_code "
				+ "where estimate_code = '" + estCode + "'";
		
		arrayList = dba.getRecord(sql);
		
		return arrayList;
	}
	
	/* 見積詳細会社概要等 */
	public HashMap<String, String> getEstSummary(String estCode){
		
		sql = "select est.estimation_code est_code, est.estimated_date est_date, cl.client_name client_name, est.tail tail,"
				+ " est.post post, est.position position, est.person person, est.subject subject, est.remark remark, est.total total,est.tax tax, cl.client_code, est.approval_status status "
				+ "from ss_estimation est "
				+ "inner join ss_estimate_particulars est_p on est.estimation_code = est_p.estimate_code  "
				+ "inner join ss_client cl on est.client_code = cl.client_code  "
				+ "inner join ss_products pro on est_p.product_code = pro.products_code "
				+ "where estimation_code = '" + estCode + "' "
				+ "group by est.estimation_code";
		
		arrayList = dba.getRecord(sql);
		
		if(arrayList.size() != 0){
			hashMap = arrayList.get(0);
		}
		
		return hashMap;
	}
	
	
	
	//受注に必要な内容（受注番号、見積番号、クライアントコード、受注日、総合計金額、備考）
	public void insertOrder(String orderCode, String estCode, String clientCode, String orderDate, int Total, String remark){
		sql = "insert into ss_order value('"+ orderCode +"','" + estCode + "','" + clientCode + "','" + orderDate + "'," + Total + ",'" + remark + "')";
		dba.insertRecord(sql);
	}
	//受注明細に必要な内容（受注番号、商品コード、数量、合計金額）
	public void insertOrderDetail(String orderCode, String proCode, int quantity, int subTotal) {
		sql = "insert into ss_order_details value('"+ orderCode + "','" + proCode + "'," + quantity + "," + subTotal + ")";
		System.out.println(sql);
		dba.insertRecord(sql);
	}
	//与信限度額のアップデート
	public void uodateCredit(String client_code,int total){
		
		sql = "select * from ss_client cl "
				+ "inner join ss_estimation est on cl.client_code = est.client_code "
				+ "where cl.client_code = '"+ client_code +"' and (est.approval_status != 4 and est.approval_status != 4)";
		
		arrayList = dba.getRecord(sql);
		hashMap = arrayList.get(0);
		String credit_limit = hashMap.get("credit_limit");
		
		int creditLimit = common.parseIntegerforString(credit_limit);
		
		creditLimit = creditLimit - total;
		sql = "update ss_client set credit_limit = " + creditLimit + " where client_code = '" + client_code + "'";
		
		dba.insertRecord(sql);
	}
	
	//商品の在庫減少
	public void updateProductStocks(String product_code, String stock){
		
		sql = "select stock_num from ss_products where products_code = '" + product_code + "'";
		arrayList = dba.getRecord(sql);
		hashMap = arrayList.get(0);
		String stock_num = hashMap.get("stock_num");
		
		int old_stock = common.parseIntegerforString(stock_num);
		int order_stock = common.parseIntegerforString(stock);
		
		int new_stock = old_stock - order_stock;
		
		sql = "update ss_products set stock_num = " + new_stock + " where products_code = '" + product_code + "'";
		dba.insertRecord(sql);
	}
	
	/* 見積のステータス変更（受注） */
	public void statusUpdate(String est_code, int status_code){
		
		sql = "update ss_estimation set approval_status = " + status_code + " where estimation_code = '" + est_code + "'";
		System.out.println(sql);
		dba.insertRecord(sql);
	}
	
	/* 今回の受注された企業の見積の与信限度チェック */
	public ArrayList<HashMap<String, String>> getClientEst(String client_code){
		sql ="select est.estimation_code estCode,est.total estTotal,cl.credit_limit creditLimit "
				+ "from ss_estimation est "
				+ "inner join ss_client cl on est.client_code = cl.client_code where est.client_code = '"+ client_code +"' and (est.approval_status != 4 and est.approval_status != 5) ";
		
		arrayList = dba.getRecord(sql);
		return arrayList;
	}
	
	/* 在庫の取得 */
	public ArrayList<HashMap<String, String>> getEstQuantity(String client_code){
		
		sql = "select est.estimation_code estCode,esp.quantity estQuantity,pro.stock_num stock "
				+ "from ss_estimation est "
				+ "inner join ss_client cl on est.client_code = cl.client_code "
				+ "inner join ss_estimate_particulars esp on est.estimation_code = esp.estimate_code "
				+ "inner join ss_products pro on esp.product_code = pro.products_code "
				+ "where est.client_code = '"+ client_code +"' and (est.approval_status != 4 and est.approval_status != 5) ";
		
		arrayList = dba.getRecord(sql);
		
		return arrayList;
		
	}
	
	/* 見積のステータスを取得 */
	public HashMap<String, String> getStatus(String est_code){
		sql = "select estimation_code est_code,client_code,total,approval_status status from ss_estimation where estimation_code = '"+ est_code +"'";
		
		arrayList = dba.getRecord(sql);
		hashMap = arrayList.get(0);
		return hashMap;
	}
	
	
	/* 見積書の一時的フラグの更新・取引先に一時的与信限度額の上昇 */
	public void insertCreditChange(String estCode,String clientCode,int Total,int CreditStatus){
		
		//クレジットステータスの変更
		sql = "update ss_estimation set templarycreditflg = " + CreditStatus + ", approval_status = 0 where estimation_code = '" + estCode +"'";
		System.out.println(sql);
		dba.insertRecord(sql);
		
		sql = "update ss_client set tempolarycredit = " + Total+ " where client_code = '" + clientCode + "'";
		System.out.println(sql);
		dba.insertRecord(sql);
		
	}
	
}
