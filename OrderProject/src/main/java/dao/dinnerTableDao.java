package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.dinnerTable;
import util.DBUtil;

public class dinnerTableDao implements Serializable {

	// 鏌ヨ椁愭琛�(鍏ㄩ儴鏁版嵁)
	public List<dinnerTable> findall() {
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "SELECT * FROM dinnerTable_1705 ORDER BY ID";
			ResultSet rs = conn.createStatement().executeQuery(sql);
			List<dinnerTable> list = new ArrayList<dinnerTable>();
			while (rs.next()) {
				dinnerTable d = createTable(rs);
				list.add(d);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("鏌ヨ椁愭淇℃伅澶辫触", e);
		} finally {
			DBUtil.close(conn);
		}
	}

	/**
	 * Alt+Shift+M
	 */
	private dinnerTable createTable(ResultSet rs) throws SQLException {
		dinnerTable d = new dinnerTable();
		d.setId(rs.getInt("id"));
		d.setTableName(rs.getString("tableName"));
		d.setTableStatus(rs.getInt("tableStatus"));
		d.setOrderDate(rs.getTimestamp("orderDate"));
		return d;
	}

	// 鏍规嵁id鏌ヨ椁愭/閫�妗宻ql璇彞涔嬩竴
	public dinnerTable findById(int id) {
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "SELECT * FROM dinnerTable_1705 WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return createTable(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("鏍规嵁ID鏌ヨ椁愭淇℃伅澶辫触", e);
		} finally {
			DBUtil.close(conn);
		}
		return null;
	}

	// 鎹鍚嶆煡璇�
	public List<dinnerTable> findByName(String tableName) {
		if (tableName == null) {
			return null;
		}
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "SELECT * FROM dinnerTable_1705 WHERE tableName=? ORDER BY ID";
		  // ResultSet rs = conn.createStatement().executeQuery(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tableName);
			ResultSet rs = ps.executeQuery();
			List<dinnerTable> list = new ArrayList<dinnerTable>();
			while (rs.next()) {
				dinnerTable d = createTable(rs);
				list.add(d);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("鏍规嵁妗屽悕鏌ヨ澶辫触", e);
		} finally {
			DBUtil.close(conn);
		}
	}

	// 澧炲姞
	public void insert(dinnerTable table) {
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
//			String sql = "INSERT INTO dinnerTable_1705 VALUES(25,?,0,null)";
			String sql = "INSERT INTO dinnerTable_1705 VALUES(dinnerTable_1705_seq_id.nextval,?,0,null)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, table.getTableName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("澧炲姞椁愭澶辫触", e);
		} finally {
			DBUtil.close(conn);
		}
	}

	// 淇敼鏁版嵁(閫�妗�)
	public void update(int id) {
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "UPDATE dinnerTable_1705 SET tablestatus=0,orderdate=null WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("閫�妗屽け璐�");
		} finally {
			DBUtil.close(conn);
		}
	}

	// 鍒犻櫎鏁版嵁
	public void delete(int id) {
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "DELETE FROM dinnerTable_1705 WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("鍒犻櫎椁愭淇℃伅澶辫触");
		} finally {
			DBUtil.close(conn);
		}
	}

}
