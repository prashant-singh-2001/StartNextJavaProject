package com.startnext.bean;

public class StUsBean {

	private StartupBean sb = new StartupBean();
	private UserBean ub = new UserBean();
	public StUsBean() {
		super();
	}
	
		public StUsBean(StartupBean sb, UserBean ub) {
		super();
		this.sb = sb;
		this.ub = ub;
	}

	public StartupBean getSb() {
		return sb;
	}
	public void setSb(StartupBean sb) {
		this.sb = sb;
	}
	public UserBean getUb() {
		return ub;
	}
	public void setUb(UserBean ub) {
		this.ub = ub;
	}

	@Override
	public String toString() {
		return "StUsBean [sb=" + sb + ", ub=" + ub + "]";
	}
	
	
}
