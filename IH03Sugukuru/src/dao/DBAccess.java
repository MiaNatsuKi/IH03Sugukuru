package dao;


/**********************************************
 * Created I.Asakawa
 **********************************************/

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


public class DBAccess {

		// MySQLユーザー名
		private static String DBUserName = "admin";
		// MySQLパスワード
		private static String DBPassword = "password";
		// MySQL文字コード
		private static String DBCharset = "utf-8";
		// DB名
		private String mDBName = "ss_sugukuru";

		/**
		 * DBとの接続を確立する
		 *
		 * @return Connection
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		private Connection createConnection() throws ClassNotFoundException, SQLException {
			Connection cn = null;
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + mDBName
					+ "?useUnicode=true&characterEncoding=" + DBCharset + "&zeroDateTimeBehavior=convertToNull", DBUserName, DBPassword);
			return cn;
		}


	/**
	 * SQL文(INSERT)を受け取り
	 * テーブルへ新たに値を挿入する。
	 * @param query
	 */
	public void insertRecord (String query) {
		Connection cn = null;
		Statement st = null;
		try {
			cn = createConnection();
			st = cn.createStatement();

			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				cn.close();
			} catch (Exception ex) {
				System.out.println("Can't close");
			}
		}
	}



	/**
	 * SQL文(DELETE)を受け取り
	 * レコードの削除を実行する
	 * @param query
	 */
	public void deleteRecord (String query) {
		Connection cn = null;
		Statement st = null;
		try {
			cn = createConnection();
			st = cn.createStatement();

			st.execute(query);
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				cn.close();
			} catch (Exception ex) {
				System.out.println("Can't close");
			}
		}
	}



	/**
	 * SQL文(SELECT)を受け取り
	 * 結果をArrayList<HashMap<String, String>>の形で返す。
	 * HashMapの[KEY]には対象テーブルのフィールド名 [VALUE]には値が入る
	 *
	 * @param query
	 * @return ArrayList<HashMap<String, String>>
	 */
	public ArrayList<HashMap<String, String>> getRecord (String query) {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map ;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			cn = createConnection();
			st = cn.createStatement();
			rs = st.executeQuery(query);

			// Get MetaData from ResultSet
			ResultSetMetaData rsmd = rs.getMetaData();

			// Get value from DB
			while (rs.next()) {
				map = new HashMap<String, String>();
				int i = 1;

				// Table of column number loop
				for (int k = 0; k < getColumnNumber(rs); k++) {
					// Add value to the map
					map.put(rsmd.getColumnLabel(i), rs.getString(rsmd.getColumnLabel(i)));
					i++;
				}
				// Add value to the ArrayList HashMap
				list.add(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				cn.close();
			} catch (Exception ex) {
				System.out.println("Can't close");
			}
		}
		return list;
	}


	/**
	 * 主キーの重複チェックを行う
	 * 値が重複していな場合にtrueを返す
	 *
	 * @param tableName
	 * @param primary
	 * @return isFlag
	 */
	public boolean duplicateCheck (String tableName, String primary) {
		if (tableName.isEmpty() || primary.isEmpty()) { return false; }
		boolean isFlag = false;
		String primaryKey = getPrimaryKeys(tableName);
		String query = "SELECT * FROM " + tableName + " WHERE " + primaryKey + " = '" + primary + "'" ;
		ArrayList<HashMap<String, String>> list = getRecord(query);
		if (list.isEmpty()) {
			isFlag = true;
		}
		return isFlag;
	}


	/**
	 * 特定カラムの値の重複確認を行う
	 * 値が重複していない場合 true, 重複している場合 falseを返す
	 * @param tableName
	 * @param 対象カラム
	 * @param 対象カラムで調べたい値
	 * @return true / false
	 */
	public boolean check(String tableName, String target, String value) {
		// １つでも空白の値がある場合は"false"
		if (tableName.isEmpty() || target.isEmpty() || value.isEmpty()) { return false; }
		// 判定用フラグ
		boolean isFlag = false;
		String query = "SELECT * FROM " + tableName + " WHERE "
				+ target + " = '" + value + "'";
		System.out.println("DBAccess#check()  :  " + query);
		// 結果を取得
		ArrayList<HashMap<String, String>> list = getRecord(query);
		if (list.isEmpty()) {
			isFlag = true;
		}
		return isFlag;
	}


	/**
	 * 特定カラムの値の重複確認を行う
	 * 値が重複していない場合 true, 重複している場合 falseを返す
	 * @param tableName
	 * @param 対象カラム
	 * @param 対象カラムで調べたい値
	 * @return true / false
	 */
	public boolean check(String tableName, String target1, String value1, String target2, String value2) {
		// １つでも空白の値がある場合は"false"
		if (tableName.isEmpty() || target1.isEmpty() || value1.isEmpty()
				|| target2.isEmpty() || value2.isEmpty()) { return false; }
		// 判定用フラグ
		boolean isFlag = false;
		String query = "SELECT * FROM " + tableName + " WHERE "
				+ target1 + " = '" + value1 + "' AND "
				+ target2 + " = '" + value2 + "'";
		System.out.println("DBAccess#check()  :  " + query);
		// 結果を取得
		ArrayList<HashMap<String, String>> list = getRecord(query);
		if (list.isEmpty()) {
			isFlag = true;
		}
		return isFlag;
	}


	/**
	 * テーブル名を返す
	 *
	 * @param rs
	 * @return String
	 * @throws SQLException
	 */
	protected String getTableName (ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		return (String) rsmd.getTableName(1);
	}


	/**
	 *  カラム数を返す
	 *
	 * @param ResultSet
	 * @return int
	 * @throws SQLException
	 */
	private int getColumnNumber (ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		return (int) rsmd.getColumnCount();
	}


	/*
	 * 主キーの値を返す。
	 * 主きーの値がない場合、空白を返す
	 */
	private String getPrimaryKeys (String tableName) {
		Connection cn = null;
		ResultSet rs = null;
		String primary = "";
		try {
			// Get Connection
			cn = createConnection();
			// Get MetaData
			DatabaseMetaData dmd = cn.getMetaData();
			System.out.println("getPrimaryKeys : " + tableName);
			rs = dmd.getPrimaryKeys(null, DBUserName, tableName);
			// Get Primary Key
			while (rs.next()) {
//				primary = rs.getString("PK_NAME");
				primary = rs.getString("COLUMN_NAME");
				System.out.println(primary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				cn.close();
			} catch (Exception e) {
				System.out.println("Can't close");
			}
		}
		if (primary == null) primary = "";

		return primary;
	}


}

