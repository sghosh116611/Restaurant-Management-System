package com.soumojitghoshspring.rmsBackend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "table_details")
public class TableDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "capacity")
	private int capacity;
	
	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH })
	@JoinColumn(name = "type_id")
	private TableType tableType;
	
	@Column(name = "isBooked")
	private boolean isBooked;
	
	public TableDetail() {
		// TODO Auto-generated constructor stub
	}

	public TableDetail(int capacity, TableType tableType, boolean isBooked) {
		this.capacity = capacity;
		this.tableType = tableType;
		this.isBooked = isBooked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public TableType getTableType() {
		return tableType;
	}

	public void setTableType(TableType tableType) {
		this.tableType = tableType;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	@Override
	public String toString() {
		return "TableEntity [id=" + id + ", capacity=" + capacity + ", tableType=" + tableType + ", isBooked="
				+ isBooked + "]";
	}
	
	
}
