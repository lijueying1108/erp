package org.kor.mv.mybatis.pojo;

public class DepartDAO {
    private String departName;

	private String id;

	private String sortstring;

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName == null ? null : departName.trim();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getSortstring() {
		return sortstring;
	}

	public void setSortstring(String sortstring) {
		this.sortstring = sortstring == null ? null : sortstring.trim();
	}

}