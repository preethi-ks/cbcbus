package com.wipro.bus.bean;

public class ScheduleBean {
	String scheduleId_ID;
	String source;
	String destination; 
	String startTime;
	String arrivalTime;
	public String getScheduleId_ID() {
		return scheduleId_ID;
	}
	public void setScheduleId_ID(String scheduleId_ID) {
		this.scheduleId_ID = scheduleId_ID;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
}
