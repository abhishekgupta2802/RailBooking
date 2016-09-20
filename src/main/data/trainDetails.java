package main.data;

import java.sql.Time;

public class trainDetails {
	private int trainNum;
	String stationName;
	int journeyDay;
	Time startTime;
	int haultMins;
	String sta;
	
	public String getSta() {
		return sta;
	}
	public void setSta(String sta) {
		this.sta = sta;
	}
	public int getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(int trainNum) {
		this.trainNum = trainNum;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public int getJourneyDay() {
		return journeyDay;
	}
	public void setJourneyDay(int journeyDay) {
		this.journeyDay = journeyDay;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public int getHaultMins() {
		return haultMins;
	}
	public void setHaultMins(int haultMins) {
		this.haultMins = haultMins;
	}
	

}
