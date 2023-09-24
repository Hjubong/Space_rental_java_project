package com.project.studio;

public class Studio {
	private int studioNum;
	private String name;
	private String type;
	private int maxNumOfPeople;
	private int basicRate;
	private int area;
	private String address;
	private int status; // 0 - 삭제 안됨, 1 - 삭제됨

	public Studio(int studioNum, String name, String type, int maxNumOfPeople, int basicRate, int area, String address,
			int status) {
		super();
		this.studioNum = studioNum;
		this.name = name;
		this.type = type;
		this.maxNumOfPeople = maxNumOfPeople;
		this.basicRate = basicRate;
		this.area = area;
		this.address = address;
		this.status = status;
	}

	public int getStudioNum() {
		return studioNum;
	}

	public void setStudioNum(int studioNum) {
		this.studioNum = studioNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMaxNumOfPeople() {
		return maxNumOfPeople;
	}

	public void setMaxNumOfPeople(int maxNumOfPeople) {
		this.maxNumOfPeople = maxNumOfPeople;
	}

	public int getBasicRate() {
		return basicRate;
	}

	public void setBasicRate(int basicRate) {
		this.basicRate = basicRate;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Studio [studioNum=" + studioNum + ", name=" + name + ", type=" + type + ", maxNumOfPeople="
				+ maxNumOfPeople + ", basicRate=" + basicRate + ", area=" + area + ", address=" + address + ", status="
				+ status + "]";
	}

}
