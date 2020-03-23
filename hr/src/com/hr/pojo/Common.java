package com.hr.pojo;

public class Common {
	private int pagesize;     //记录的条数
	private int pageid;       //第几页
	private int pagebegin;    //开始 
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPageid() {
		return pageid;
	}
	public void setPageid(int pageid) {
		this.pageid = pageid;
	}
	public int getPagebegin() {
		return pagebegin;
	}
	public void setPagebegin(int pagebegin) {
		this.pagebegin = pagebegin;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	private int count; 
}
