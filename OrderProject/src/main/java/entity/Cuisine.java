package entity;

import java.io.Serializable;

public class Cuisine implements Serializable {
	private Integer id;
	private String foodtype;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFoodtype() {
		return foodtype;
	}
	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}
	@Override
	public String toString() {
		return "Cuisine [id=" + id + ", foodtype=" + foodtype + "]";
	}
	
	
}
