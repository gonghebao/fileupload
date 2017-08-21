package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Detail;
import util.DBUtil;

public class OrderDetailDao implements Serializable{
	public List<Detail> findAll(int id){
		List<Detail> list = new ArrayList<Detail>();
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "select food_1705.foodname,food_1705.price,orderDetail_1705.foodcount from "
					+ "food_1705,orders_1705,orderDetail_1705 where orders_1705.dd_id=? and "
					+ "food_1705.id=orderDetail_1705.food_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Detail e = new Detail();
				e.setName(rs.getString("foodname"));
				e.setPrice(rs.getDouble("price"));
				e.setCount(rs.getInt("foodcount"));
				list.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return list;
	}
}
