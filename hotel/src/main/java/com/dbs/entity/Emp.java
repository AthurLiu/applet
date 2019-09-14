package com.dbs.entity;

/**
 * 	酒店员工信息
 * @author 13600
 *
 */
public class Emp {
	private int empId;
	private String empName;
	private String empPass;
	private String empType;
	private String empState;
	private int createId;
	private int updateId;
	private String createTime;
	private String updateTime;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPass() {
		return empPass;
	}
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public String getEmpState() {
		return empState;
	}
	public void setEmpState(String empState) {
		this.empState = empState.equals("Y")?"已激活":"未激活";
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
}
