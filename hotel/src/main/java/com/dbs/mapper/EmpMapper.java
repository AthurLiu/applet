package com.dbs.mapper;
import java.util.List;
import com.dbs.entity.Emp;

public interface EmpMapper {
	
	/**
	 * 员工信息登录检查（用户名，密码）
	 * @param user
	 * @return
	 */
	public Emp selectByEntity(Emp emp);
	
	/**
	 * 查询员工姓名是否已存在
	 * @param user
	 * @return
	 */
	public Emp selectByName(Emp emp);
	
	/**
	 * 根据id查找员工信息
	 * @param id
	 * @return
	 */
	public List<Emp> selectById(int id);
	
	/**
	 * 查询所有员工信息
	 * @param user
	 * @return
	 */
	public List<Emp> selectAll();
	
	/**
	 * 员工注册
	 * @param emp
	 * @return
	 */
	public boolean addEmpInfo(Emp emp);
	
	/**
	 * 更新员工的ID
	 * @param emp
	 * @return
	 */
	public boolean updateEmpInfoByName(Emp emp);
	
	/**
	 * 新员工入职激活（管理员）
	 * @param emp
	 * @return
	 */
	public boolean updateEmpInfo(Emp emp);
	
	/**
	 * 员工离职删除（管理员）
	 * @param emp
	 * @return
	 */
	public boolean deleteEmpInfoById(int emp_id);
	
	/**
	 * 员工职位变动（管理员）
	 * @param emp
	 * @return
	 */
	public boolean updateEmpJobInfo(Emp emp);
	
	/**
	 * 修改个人信息（全部）
	 * @param emp
	 * @return
	 */
	public boolean updateOwn(Emp emp);
}
