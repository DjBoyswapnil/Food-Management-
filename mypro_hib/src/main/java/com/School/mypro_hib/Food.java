package com.School.mypro_hib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_order")
public class Food
{
	@Override
	public String toString() {
		return "Food [f_id=" + f_id + ", f_name=" + f_name + ", f_price=" + f_price + ", f_quantity=" + f_quantity
				+ "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Food_ID",length =10)
	private int f_id;
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	@Column(name="Food_Name",length = 50)
	
	private String f_name;
	@Column(name="Food_Price",length =10)
	private int f_price;
	@Column(name="Food_Quantity",length = 10)
	private int f_quantity;
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public int getF_price() {
		return f_price;
	}
	public void setF_price(int f_price) {
		this.f_price = f_price;
	}
	public int getF_quantity() {
		return f_quantity;
	}
	public void setF_quantity(int f_quantity) {
		this.f_quantity = f_quantity;
	}
	public Food(int f_id,String f_name, int f_price, int f_quantity) {
		super();
		this.f_id=f_id;
		this.f_name = f_name;
		this.f_price = f_price;
		this.f_quantity = f_quantity;
	}
	
}
