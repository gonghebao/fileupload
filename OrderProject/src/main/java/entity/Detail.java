package entity;

import java.io.Serializable;
/*
 * 菜品管理里面明细 对象
 * */
public class Detail implements Serializable {
	private String name;  //菜名
	private Double price; //单价
	private Integer count;//数量
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Detail [name=" + name + ", price=" + price + ", count=" + count + "]";
	}
	
}
