package org.kor.mv.mybatis.pojo;

import java.util.Date;

public class EmployeeDAO {

	private String id;

    private String name;

    private String residRegistrNum;

    private String mobileNum;

    private String emailAddress;

    private String certification;

    private String specialNote;

    private Date hiredate;

    private String depart;

    private String position;

    private String level;

    private Date resignationDate;
    
    private String officeStatus;
    
    private String homeAddress;
    
	private Byte deletestatus;


    public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}


    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getResidRegistrNum() {
        return residRegistrNum;
    }

    public void setResidRegistrNum(String residRegistrNum) {
        this.residRegistrNum = residRegistrNum == null ? null : residRegistrNum.trim();
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum == null ? null : mobileNum.trim();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress == null ? null : emailAddress.trim();
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification == null ? null : certification.trim();
    }

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote == null ? null : specialNote.trim();
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart == null ? null : depart.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Date getResignationDate() {
        return resignationDate;
    }

    public void setResignationDate(Date resignationDate) {
        this.resignationDate = resignationDate;
    }

    public Byte getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Byte deletestatus) {
        this.deletestatus = deletestatus;
    }

    public String getOfficeStatus() {
        return officeStatus;
    }

    public void setOfficeStatus(String officeStatus) {
        this.officeStatus = officeStatus == null ? null : officeStatus.trim();
    }
    
}