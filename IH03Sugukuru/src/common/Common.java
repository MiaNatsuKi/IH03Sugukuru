/**
 * 全員が使う共通メソッド。
 * 作成日時：2016/11/08 15:32
 * 変更日：YYYY/MM/DD
 * 
 * @author Y.Ishii
 */
package common;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
	
	/**
	 * 現在日時を取得できるメソッド。
	 * 
	 * 作成日時：2016/11/08/15:35
	 * 変更日時：YYYY/MM/DD
	 * @return 現在日時が入っているDate型の変数。
	 * @author Y.Ishii
	 */
	public Date CurrentDate() {
		 Date date = new Date();
		return date;
	}
	
	/**
	 * String型の変数の値が文字列かどうかをチェックするメソッド。
	 * 作成日時：2016/11/08/15:40
	 * 変更日時：YYYY/MM/DD
	 * @param str
	 * @return
	 */
	public boolean StringCheck(String str) {
		//半角英数値(0～9、a～z、A～Z、_)にマッチする
		Pattern p = Pattern.compile("[0-9a-zA-Z]+$");
		Matcher m = p.matcher(str);
		return m.find();
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public int parseIntegerforString(String str) {
		int integer = Integer.parseInt(str);
		return integer;
	}

}
