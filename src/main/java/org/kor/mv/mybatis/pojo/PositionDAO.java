package org.kor.mv.mybatis.pojo;

public class PositionDAO{

	private String 직급명;

	private String id;
	
    private String sortstring;

	public String get직급명() {
		return 직급명;
	}

	public void set직급명(String 직급명) {
		this.직급명 = 직급명;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSortstring() {
		return sortstring;
	}

	public void setSortstring(String sortstring) {
		this.sortstring = sortstring;
	}

}