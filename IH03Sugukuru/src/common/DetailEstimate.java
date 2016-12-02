package common;
import java.util.ArrayList;
import java.util.HashMap;

import dbhelper.DBHelper;

public class DetailEstimate {
	
		ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> hashMap = new HashMap<String,String>();
		DBHelper dbHelper = new DBHelper();
		Common common = new Common();
				
		/* 見積詳細内容 */
	public ArrayList<HashMap<String, String>> getESTContent(String code) {
		arrayList = dbHelper.getEstContent(code);
		return arrayList;
	}
	
	/* 見積詳細概要 */
	public HashMap<String, String> getESTSummary(String code){
		
		hashMap = dbHelper.getEstSummary(code);
		return hashMap;
	}
	
}
