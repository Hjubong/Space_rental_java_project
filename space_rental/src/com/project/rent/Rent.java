package com.project.rent;

import java.util.Calendar;

public class Rent {
	private int rentnum;
	private String id;
	private int studioNum;
	private int rate;
	private int numOfPeople;
	private Calendar startDate;
	private Calendar endDate;

	public Rent(int rentnum, String id, int studioNum, int rate, int numOfPeople, Calendar startDate,
			Calendar endDate) {
		super();
		this.rentnum = rentnum;
		this.id = id;
		this.studioNum = studioNum;
		this.rate = rate;
		this.numOfPeople = numOfPeople;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getRentnum() {
		return rentnum;
	}

	public void setRentnum(int rentnum) {
		this.rentnum = rentnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStudioNum() {
		return studioNum;
	}

	public void setStudioNum(int studioNum) {
		this.studioNum = studioNum;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getNumOfPeople() {
		return numOfPeople;
	}

	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Rent [rentnum=" + rentnum + ", id=" + id + ", studioNum=" + studioNum + ", rate=" + rate
				+ ", numOfPeople=" + numOfPeople + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
