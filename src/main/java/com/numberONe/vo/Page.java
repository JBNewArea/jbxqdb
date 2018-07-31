package com.numberONe.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Page implements Serializable{
	private static final long serialVersionUID = 1L;
	public static ThreadLocal<Page> threadLocal = new ThreadLocal<Page>();
	private int records;
	private int rows;
	private String sidx;
	private String sord;
	private int pageNo;
	private int currentResult;
//	private String sord;
	
	private String pageNumber;
	private String pageSize;
	private String pageList;
	private String count;
	private ArrayList<?> datalist;
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageList() {
		return pageList;
	}
	public void setPageList(String pageList) {
		this.pageList = pageList;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public ArrayList<?> getDatalist() {
		return datalist;
	}
	public void setDatalist(ArrayList<?> datalist) {
		this.datalist = datalist;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getCurrentResult() {
		return currentResult;
	}
	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}
//	public void setSord(String sord) {
//		this.sord = sord;
//	}

}
