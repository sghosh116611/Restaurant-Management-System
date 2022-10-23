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
@Table(name="table_book")
public class TableBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "table_request_id")
	private TableRequest tableRequest;
	
	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "table_id")
	private TableDetail tableDetail;
	
	TableBook(){
		
	}

	public TableBook(TableRequest tableRequest, TableDetail tableDetail) {
		this.tableRequest = tableRequest;
		this.tableDetail = tableDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TableRequest getTableRequest() {
		return tableRequest;
	}

	public void setTableRequest(TableRequest tableRequest) {
		this.tableRequest = tableRequest;
	}

	public TableDetail getTableDetail() {
		return tableDetail;
	}

	public void setTableDetail(TableDetail tableDetail) {
		this.tableDetail = tableDetail;
	}

	@Override
	public String toString() {
		return "TableBook [id=" + id + ", tableRequest=" + tableRequest + ", tableDetail=" + tableDetail + "]";
	}
	
	

}
