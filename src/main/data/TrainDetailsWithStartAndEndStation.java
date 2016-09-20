package main.data;

import java.sql.Time;

public class TrainDetailsWithStartAndEndStation {
	int trainNum;
	String stationNamStart;
	int journeyDayStart;
	Time startTimeStart;
	int haultMinsStart;
	String stationNameEnd;
	int journeyDayEnd;
	Time startTimeEnd;
	int haultMinsEnd;
	String status;
	
	public TrainDetailsWithStartAndEndStation() {
		status="NoData";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(int trainNum) {
		this.trainNum = trainNum;
	}
	public String getStationNamStart() {
		return stationNamStart;
	}
	public void setStationNamStart(String stationNamStart) {
		this.stationNamStart = stationNamStart;
	}
	public int getJourneyDayStart() {
		return journeyDayStart;
	}
	public void setJourneyDayStart(int journeyDayStart) {
		this.journeyDayStart = journeyDayStart;
	}
	public Time getStartTimeStart() {
		return startTimeStart;
	}
	public void setStartTimeStart(Time startTimeStart) {
		this.startTimeStart = startTimeStart;
	}
	public int getHaultMinsStart() {
		return haultMinsStart;
	}
	public void setHaultMinsStart(int haultMinsStart) {
		this.haultMinsStart = haultMinsStart;
	}
	public String getStationNameEnd() {
		return stationNameEnd;
	}
	public void setStationNameEnd(String stationNameEnd) {
		this.stationNameEnd = stationNameEnd;
	}
	public int getJourneyDayEnd() {
		return journeyDayEnd;
	}
	public void setJourneyDayEnd(int journeyDayEnd) {
		this.journeyDayEnd = journeyDayEnd;
	}
	public Time getStartTimeEnd() {
		return startTimeEnd;
	}
	public void setStartTimeEnd(Time startTimeEnd) {
		this.startTimeEnd = startTimeEnd;
	}
	public int getHaultMinsEnd() {
		return haultMinsEnd;
	}
	public void setHaultMinsEnd(int haultMinsEnd) {
		this.haultMinsEnd = haultMinsEnd;
	}
	
	
	
	
}
