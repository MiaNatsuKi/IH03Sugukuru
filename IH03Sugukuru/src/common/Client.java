package common;

import java.util.ArrayList;
import java.util.HashMap;

import dbhelper.DBHelper;

public class Client {

	
	/**
	 * 取引先一覧取得
	 * @return
	 */
	public ArrayList<HashMap<String,String>> getClient(){
		
		ArrayList<HashMap<String, String>> tbl = new ArrayList<HashMap<String, String>>();
		DBHelper dbh = new DBHelper();
		tbl = dbh.findClient();
		return tbl;
	}
}
