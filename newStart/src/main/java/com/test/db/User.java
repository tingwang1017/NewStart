package com.test.db;

public class User {
	private String Uuid;
	private String Loginname;
	private String Loginpass;
	
	public String getUuid() {
		return Uuid;
	}
	public void setUuid(String uuid) {
		Uuid = uuid;
	}
	public String getLoginname() {
		return Loginname;
	}
	public void setLoginname(String loginname) {
		Loginname = loginname;
	}
	public String getLoginpass() {
		return Loginpass;
	}
	public void setLoginpass(String loginpass) {
		Loginpass = loginpass;
	}
	@Override
	public String toString() {
		return "User [Uuid=" + Uuid + ", Loginname=" + Loginname + ", Loginpass=" + Loginpass + "]";
	}

}
