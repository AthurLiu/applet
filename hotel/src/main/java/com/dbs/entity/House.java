package com.dbs.entity;

/**
 * 	酒店客房
 * @author 13600
 *
 */
public class House {
	private int houseId;
	private String houseLoc;
	private String houseType;
	private String houseArt;
	private String houseState;
	private Double housePrice;
	private String houseNet;
	private Double houseDep;
	private int createId;
	private int updateId;
	private String createTime;
	private String updateTime;
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public String getHouseLoc() {
		return houseLoc;
	}
	public void setHouseLoc(String houseLoc) {
		this.houseLoc = houseLoc;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public String getHouseArt() {
		return houseArt;
	}
	public void setHouseArt(String houseArt) {
		this.houseArt = houseArt;
	}
	public String getHouseState() {
		return houseState;
	}
	public void setHouseState(String houseState) {
		this.houseState = houseState;
	}
	public Double getHousePrice() {
		return housePrice;
	}
	public void setHousePrice(Double housePrice) {
		this.housePrice = housePrice;
	}
	public int getCreateId() {
		return createId;
	}
	public int getUpdateId() {
		return updateId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setCreateId(int createId) {
		this.createId = createId;
	}
	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getHouseNet() {
		return houseNet;
	}
	public void setHouseNet(String houseNet) {
		this.houseNet = houseNet;
	}
	public Double getHouseDep() {
		return houseDep;
	}
	public void setHouseDep(Double houseDep) {
		this.houseDep = houseDep;
	}
}
