/**
	 * DBに関するメソッド
	 * 各ページに必要なinsertメソッドに関しては個人ごとにクラスを作成すること。
	 * 
	 * 作成日：2016/11/17 11:23
	 * 変更日：YYYY/MM/DD
	 * @author Y.Ishii
	 */
package dbbean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBconnecter {

	private static String driverName = "com.mysql.jdbc.Driver";
	private static String dbPass = "jdbc:mysql://localhost:3306/";
	private static String dbName = "ss_sugukuru";
	private static String userName = "admin";
	private static String userPass = "password";

	private Connection cn = null;
	private Statement st = null;
	private ResultSet rs = null;

	/**
	 * コンストラクタでDB接続に必要な値を取得してくる
	 * 
	 * 作成日：2016/11/17 11:25 変更日：YYYY/MM/DD
	 * 
	 * @author Y.Ishii
	 */
	public DBconnecter() {
		try {
			Class.forName(driverName);
			cn = DriverManager.getConnection(dbPass + dbName, userName, userPass);
			st = cn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * DB切断メソッド。最後は必ず記載すること。
	 * 
	 * 作成日：2016/11/17 11:26 変更日：YYYY/MM/DD
	 * 
	 * @author Y.Ishii
	 */
	public void dbClose() {
		try {
			st.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * データの有無を確認するメソッド。
	 * 
	 * @param sql
	 *            データの有無確認をするためのMySQL文
	 * @return データ有無のBoolean判定
	 * 
	 *         作成日：2016/11/17 11:28 変更日：YYYY/MM/DD
	 * @author Y.Ishii
	 */
	public boolean isInputDataSearch(String sql) {
		try {
			rs = st.executeQuery(sql);
			if (rs.next()) {
				rs.close();
				return true;
			} else {
				rs.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * SQL実行したデータをリストで返す
	 * 
	 * @param sql
	 *            完成されたselect文
	 * @return ArrayList＜ArrayList＞型のリスト。
	 * 
	 *         作成日：2016/11/17 11:32 変更日：YYYY/MM/DD
	 * @author Y.Ishii
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<ArrayList> select(String sql) {
		ArrayList<ArrayList> aryTbl = new ArrayList<ArrayList>();
		try {
			System.out.println("実行SQL文" + sql);
			rs = st.executeQuery(sql);
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();

			// SQL実行結果を配列で返す
			while (rs.next()) {
				ArrayList<String> rec = new ArrayList<String>();
				for (int cnt = 1; cnt <= rsmd.getColumnCount(); cnt++) {
					rec.add(rs.getString(cnt));
				}
				aryTbl.add(rec);
			}
			rs.close();
			return aryTbl;
		} catch (SQLException e) {
			e.printStackTrace();
			return aryTbl;
		}
	}

	/**
	 * データを更新するためのメソッド。
	 * 
	 * @param sql
	 *            完成されたupdate文
	 * @return 成功なら各テーブルの行数を返し、それ以外は0を返す
	 * 
	 *         作成日：2016/11/17 11:34 変更日：YYYY/MM/DD
	 * @author Y.Ishii
	 */
	public int update(String sql) {
		int intNo = 0;
		try {
			intNo = st.executeUpdate(sql);
			return intNo;
		} catch (SQLException e) {
			e.printStackTrace();
			return intNo;
		}
	}
}
