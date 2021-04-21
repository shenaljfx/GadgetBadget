package model;

public class Funds {
	int resId;
	String rUserName;
	String rUserAddress;
	String rUserType;
	String email;
	
	
	
	
	public Funds() {
		
	}
	
	
	public Funds(int resId, String rUserName, String rUserAddress, String rUserType, String email) {
		this.resId = resId;
		this.rUserName = rUserName;
		this.rUserAddress = rUserAddress;
		this.rUserType = rUserType;
		this.email = email;
	}


	public int getResId() {
		return resId;
	}


	public void setResId(int resId) {
		this.resId = resId;
	}


	public String getrUserName() {
		return rUserName;
	}


	public void setrUserName(String rUserName) {
		this.rUserName = rUserName;
	}


	public String getrUserAddress() {
		return rUserAddress;
	}


	public void setrUserAddress(String rUserAddress) {
		this.rUserAddress = rUserAddress;
	}


	public String getrUserType() {
		return rUserType;
	}


	public void setrUserType(String rUserType) {
		this.rUserType = rUserType;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
