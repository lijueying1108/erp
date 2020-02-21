package org.kor.mv.modules.projectManage.Entity;

import org.kor.mv.modules.entity.ItemEntity;

public class ProjectItemsInfoEntity {
	
	private ItemEntity projectItem;
	private int amount;
	private int unitPrice;
	
	public ItemEntity getProjectItem() {
		return projectItem;
	}
	public void setProjectItem(ItemEntity projectItem) {
		this.projectItem = projectItem;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
