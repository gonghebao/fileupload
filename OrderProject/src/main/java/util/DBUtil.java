package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	
	private static BasicDataSource ds;
	
	static {
		Properties p = new Properties();
		try {
			//璇诲彇鍙傛暟
			p.load(DBUtil.class.getClassLoader()
					.getResourceAsStream("db.properties"));
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			String initsize = p.getProperty("initsize");
			String maxsize = p.getProperty("maxsize");
			//鍒涘缓杩炴帴姹�
			ds = new BasicDataSource();
			//璁剧疆鍙傛暟
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			ds.setInitialSize(new Integer(initsize));
			ds.setMaxActive(new Integer(maxsize));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("鍔犺浇閰嶇疆鏂囦欢澶辫触",e);
		}
	}
	/**
	 * 鏈柟娉曟槸閲囩敤BasicDataSource鍒涘缓鐨勮繛鎺�,
	 * 鍒機onnection鎺ュ彛鏄湁DBCP瀹炵幇鐨勶紝鑰屽苟闈�
	 * 鏈塐racle瀹炵幇锛屽綋鐒禗BCP鐨勫疄鐜扮被涓細璋冪敤
	 * Oracle鐨勯┍鍔ㄧ被                     
	 * @return
	 * @throws SQLException
	 */
	public static Connection gtConnection() throws SQLException{
		return ds.getConnection();
	}
	/**
	 * 鏈塂BCP鎵�鎻愪緵鐨勮繛鎺ュ璞＄殑瀹炵幇绫伙紝
	 * 鍏禼lose鏂规硶鐨勯�昏緫涓嶆槸鍏抽棴杩炴帴锛�
	 * 鑰屾槸褰掕繕杩炴帴锛屽嵆瀹冧細灏嗚繛鎺ュ唴閮ㄥ寘鍚殑
	 * 鏁版嵁娓呯┖锛屽苟涓斿皢杩炴帴鐨勭姸鎬佽缃负绌洪棽
	 * @param conn
	 */
	public static void close(Connection conn){
		if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("鍏抽棴杩炴帴澶辫触",e);
			}
		}
	}
	public static void rollback(Connection conn){
		if(conn != null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("浜嬪姟鍥炴粴澶辫触",e);
			}
		}
	}
	public static void main(String[] args) {
		try {
			System.out.println(DBUtil.gtConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
