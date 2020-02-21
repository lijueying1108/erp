package org.kor.mv.modules.entity;

public class ItemEntity {

	private String numId;
	private String majorClassifcName;
	private String subClassificName;
	private String itemCode;
	
	public String getNumId() {
		return numId;
	}
	public void setNumId(String numId) {
		this.numId = numId;
	}
	public String getMajorClassifcName() {
		return majorClassifcName;
	}
	public void setMajorClassifcName(String majorClassifcName) {
		this.majorClassifcName = majorClassifcName;
	}
	public String getSubClassificName() {
		return subClassificName;
	}
	public void setSubClassificName(String subClassificName) {
		this.subClassificName = subClassificName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
}
