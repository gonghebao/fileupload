package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Cuisine;
import util.DBUtil;
/**
 * 菜系
 * @author soft01
 *
 */
public class CuisineDao implements Serializable {
	public List<Cuisine> findAll(){
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "select * from foodtype_1705 order by id";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<Cuisine> list = new ArrayList<Cuisine>();
			while(rs.next()){
				Cuisine c = new Cuisine();
				c.setId(rs.getInt("id"));
				c.setFoodtype(rs.getString("typename"));
				list.add(c);
				
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败",e);
		}finally{
			DBUtil.close(conn);
		}	
	}
	public void update(Cuisine c){
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "update foodtype_1705 set"
					+ " typename=?"
					+ " where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,c.getFoodtype());
			ps.setInt(2,c.getId());
			System.out.println(c.getFoodtype());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改失败",e);
		}finally{
			
			DBUtil.close(conn);
		}
	}
	//删除菜系方法
	public void deletecaixi(Cuisine c){
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "delete from foodtype_1705 where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,c.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	//删除菜品方法
	public void deletecaiping(Cuisine c){
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "delete from food_1705 where foodtype_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,c.getFoodtype());
			ps.executeUpdate();
			System.out.println(c.getFoodtype());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	//添加菜系方法
	public void add(Cuisine c){
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "insert into foodtype_1705 values(foodtype_1705_seq.nextval,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,c.getFoodtype());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	//遍历菜系
	public static void main(String[] args) {
		//System.out.println(1);
		CuisineDao dao = new CuisineDao();
		List<Cuisine> list = dao.findAll();
		for(Cuisine c:list){
			System.out.println(c);
		}
	}
	
}
