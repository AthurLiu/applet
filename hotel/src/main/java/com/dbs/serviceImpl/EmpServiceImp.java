package com.dbs.serviceImpl;

import java.util.List;
import com.dbs.entity.Emp;
import com.dbs.mapper.EmpMapper;
import com.dbs.service.EmpService;

public class EmpServiceImp implements EmpService {
	private EmpMapper umapper;

	public Emp selectByEntity(Emp emp) {
		return umapper.selectByEntity(emp);
	}

	public List<Emp> selectAll() {
		return umapper.selectAll();
	}

	public Emp selectByName(Emp emp) {
		return umapper.selectByName(emp);
	}

	public boolean addEmpInfo(Emp emp) {
		return umapper.addEmpInfo(emp);
	}

	public boolean updateEmpInfo(Emp emp) {
		return umapper.updateEmpInfo(emp);
	}

	public boolean deleteEmpInfoById(int emp_id) {
		return umapper.deleteEmpInfoById(emp_id);
	}

	public boolean updateEmpJobInfo(Emp emp) {
		return umapper.updateEmpJobInfo(emp);
	}

	public boolean updateOwn(Emp emp) {
		return umapper.updateOwn(emp);
	}
	
	public EmpMapper getUmapper() {
		return umapper;
	}

	public void setUmapper(EmpMapper umapper) {
		this.umapper = umapper;
	}

	public boolean updateEmpInfoByName(Emp emp) {
		return umapper.updateEmpInfoByName(emp);
	}

	public List<Emp> selectById(int id) {
		return umapper.selectById(id);
	}
}
