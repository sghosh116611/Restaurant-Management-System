package com.soumojitghoshspring.rmsBackend.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "is_paid")
	private boolean isPaid;

	@Column(name = "payment_mode")
	private String paymentMode;

	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH })
	@JoinColumn(name = "table_id")
	private TableDetail tableDetail;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "order_item", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> items;

	Order() {
	}

	public Order(Date orderDate, boolean isPaid, String paymentMode, TableDetail tableDetail, List<Item> items) {
		this.orderDate = orderDate;
		this.isPaid = isPaid;
		this.paymentMode = paymentMode;
		this.tableDetail = tableDetail;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public TableDetail getTableDetail() {
		return tableDetail;
	}

	public void setTableDetail(TableDetail tableDetail) {
		this.tableDetail = tableDetail;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", isPaid=" + isPaid + ", paymentMode=" + paymentMode
				+ ", tableDetail=" + tableDetail + ", items=" + items + "]";
	}

	

}
