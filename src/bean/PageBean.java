package bean;

import java.util.List;

import javax.lang.model.type.PrimitiveType;

/*
 * Encapsulate data on every page. including
 * 		the list of student in current page.
 * 		total number of students.
 * 		total number of pages
 * 		current page number
 * 		number of students in current page
 * */

public class PageBean<T> {
	
	private int currentPage;
	private int totalPage;  //
	private int pageSize;
	private int totalSize;
	private List<T> list;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
