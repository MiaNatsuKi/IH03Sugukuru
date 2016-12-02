package common;

import java.util.ArrayList;
import java.util.HashMap;

import dbhelper.DBHelper;

public class getJspData {

	DBHelper dbHelper = new DBHelper();
	ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String,String>>();
	HashMap<String, String> hashMap = new HashMap<String,String>();
	
	public ArrayList<HashMap<String, String>> getEstList(){
		
		/* 見積書一覧の取得 */
		arrayList = dbHelper.getEstimateList();
		
		return arrayList;
	}
	
	public HashMap<String, String> getEstStatus(String est_code){
		
		hashMap = dbHelper.getStatus(est_code);
		return hashMap;
	}
}
