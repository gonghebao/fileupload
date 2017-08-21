package entity;

import java.io.Serializable;
//菜品列表实体类
public class Variety implements Serializable{
	private Integer id;//菜编号
	private String foodName;//菜名
	private String foodType_id;//所属菜系关系于菜系表
	private Double price;//价格
	private Double mprice;//会员价格
	private String remark;//简介
	private String img;//图片路径
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodType_id() {
		return foodType_id;
	}
	public void setFoodType_id(String foodType_id) {
		this.foodType_id = foodType_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getMprice() {
		return mprice;
	}
	public void setMprice(Double mprice) {
		this.mprice = mprice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Variety [id=" + id + ", foodName=" + foodName + ", foodType_id=" + foodType_id + ", price=" + price
				+ ", mprice=" + mprice + ", remark=" + remark + ", img=" + img + "]";
	}
	
}
