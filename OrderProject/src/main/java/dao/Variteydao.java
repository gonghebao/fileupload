package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import entity.Variety;
import util.DBUtil;

public class Variteydao implements Serializable {
	/***
	 * 查询菜品列表
	 * @return
	 */
	public List<Variety> getVariety(){
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "select * from food_1705 order by ID ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Variety> list = new ArrayList<Variety>();
			while (rs.next()) {
				Variety v = new Variety();
				v.setId(rs.getInt("id"));
				v.setFoodName(rs.getString("foodName"));
				v.setFoodType_id(rs.getString("foodType_id"));
				v.setPrice(rs.getDouble("price"));
				v.setMprice(rs.getDouble("mprice"));
				list.add(v);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询菜品失败");
		}finally {
			DBUtil.close(conn);
		}	
	}
	/**
	 * 添加菜品
	 * @param v
	 */
	public void SvaeFood(Variety v){
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql ="insert into food_1705 values(food_1705_seq.nextval,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, v.getFoodName());
			ps.setString(2, v.getFoodType_id());
			ps.setDouble(3, v.getPrice());
			ps.setDouble(4, v.getMprice());
			ps.setString(5, v.getRemark());
			ps.setString(6, v.getImg());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加菜品失败");
		}finally {
			DBUtil.close(conn);
		}
	}
	//查询菜系下拉选
	public List<String> getcaixi(){
		Connection conn = null;
		List<String> list = new ArrayList<String>();
		try {
			conn = DBUtil.gtConnection();
			String sql ="select typename from foodtype_1705";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				String typename = rs.getString("typename");
				list.add(typename);
			}
			//System.out.println(list);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加菜品失败");
		}finally {
			DBUtil.close(conn);
		}
	}
	public void delete(int id){
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql ="delete from food_1705 where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加菜品失败");
		}finally {
			DBUtil.close(conn);
		}
	}
	//根据ID查询到菜显示到修改上
	public Variety getAll(int id){
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "select * from food_1705 where id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Variety v = new Variety();
			while (rs.next()) {
				v.setId(rs.getInt("id"));
				v.setFoodName(rs.getString("foodName"));
				v.setFoodType_id(rs.getString("foodType_id"));
				v.setPrice(rs.getDouble("price"));
				v.setMprice(rs.getDouble("mprice"));
				v.setRemark(rs.getString("remark"));
				v.setImg(rs.getString("img"));
			}
			return v;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询菜品失败");
		}finally {
			DBUtil.close(conn);
		}
		
	}
	//修改菜品
	public void UpdateFood(Variety v){
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "update food_1705 set foodName=?,foodType_id=?,price=?,mprice=?,remark=?,img=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, v.getFoodName());
			ps.setString(2, v.getFoodType_id());
			ps.setDouble(3, v.getPrice());
			ps.setDouble(4, v.getMprice());
			ps.setString(5, v.getRemark());
			ps.setString(6,v.getImg());
			ps.setInt(7, v.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加菜品失败");
		}finally {
			DBUtil.close(conn);
		}
	}
	//搜索菜
	public List<Variety> getcaixi(String type){
		Connection conn = null;
		List<Variety> list = new ArrayList<Variety>();
		try {
			conn = DBUtil.gtConnection();
			String sql = "select * from food_1705 where foodType_id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Variety v = new Variety();
				v.setId(rs.getInt("id"));
				v.setFoodName(rs.getString("foodName"));
				v.setFoodType_id(rs.getString("foodType_id"));
				v.setPrice(rs.getDouble("price"));
				v.setMprice(rs.getDouble("mprice"));
				list.add(v);
			}
			System.out.println(list);
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询菜品失败");
		}finally {
			DBUtil.close(conn);
		}
	}
	public static void main(String[] args) {
		Variteydao variteydao  = new Variteydao();
		List<Variety> list = variteydao.getVariety();
		for (Variety variety : list) {
			System.out.println(variety);
		}
	}
}
