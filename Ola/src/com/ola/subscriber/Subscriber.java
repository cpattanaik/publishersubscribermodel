package com.ola.subscriber;


public class Subscriber {
	private Integer groupID;
	
	public Subscriber(int groupID) {

		this.groupID = groupID;
	}
	
	public Integer getGroupID() {
		return groupID;
	}
	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}
	
	public boolean send(String msg) {
		System.out.println(msg);
		return true;
	}
}
