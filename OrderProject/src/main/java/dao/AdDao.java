package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Admin;
import util.*;

public class AdDao implements Serializable {
	public Admin findAll(String name) {
		Connection conn = null;
		Admin ad = new Admin();
		try {
			conn = DBUtil.gtConnection();
			String sql = "select * from admin_info_dinnerTable where admin_code = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {

				ad.setAdmin_id(rs.getInt("admin_id"));
				ad.setAdmin_code(rs.getString("admin_code"));
				ad.setPassword(rs.getString("password"));
				ad.setName(rs.getString("name"));
				ad.setTelephone(rs.getString("telephone"));
				ad.setEmail(rs.getString("email"));
				ad.setEnrolldate(rs.getDate("enrolldate"));
				return ad;
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("加载失败", e);
		} finally {
			DBUtil.close(conn);
		}
		return null;

	}
	/*public static void main(String[] args) {
		AdDao aa = new AdDao();
		Admin  n = 	aa.findAll("zhangsan");
		System.out.println(n);
	}*/
}
