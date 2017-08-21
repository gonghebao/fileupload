package entity;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable {
	//订单编号
	private Integer ddID;
	//餐桌名
	private String tableID;
	//下单日期
	private Date orderDate;
	//总金额
	private Double totalPrice;
	//状态（0：未结帐  1：已结帐）
	private Integer ordersTatus;
	public Integer getDdID() {
		return ddID;
	}
	public void setDdID(Integer ddID) {
		this.ddID = ddID;
	}
	public String getTableID() {
		return tableID;
	}
	public void setTableID(String tableID) {
		this.tableID = tableID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getOrdersTatus() {
		return ordersTatus;
	}
	public void setOrdersTatus(Integer ordersTatus) {
		this.ordersTatus = ordersTatus;
	}
	
	
	@Override
	public String toString() {
		return "Order [ddID=" + ddID + ", tableID=" + tableID + ", orderDate=" + orderDate + ", totalPrice="
				+ totalPrice + ", ordersTatus=" + ordersTatus + "]";
	}
	
	
	
}
