package com.dbs.action;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbs.entity.Emp;
import com.dbs.service.EmpService;

/**
 * 酒店管理系统
 */
@Controller
public class EmpInfoAction {
	@Autowired
	private EmpService empService;
	
	public static int employeeID;

	/**
	 * 员工登录主页面
	 * @param emp
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="main1",method=RequestMethod.POST)
	@ResponseBody
	public List<Emp> main() {
		System.out.println("主页面尝试进入...");
		if(employeeID != 0) {
			List<Emp> emp = empService.selectById(employeeID);
			if(emp != null) {
				System.out.println("进入成功");
				return emp;
			} else {
				System.out.println("进入失败，操作出错");
				return null;
			}
		}
		System.out.println("进入失败，用户已下线");
		return null;
	}
	
	/**
	 * 员工姓名是否存在登录
	 * @param emp
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="isExit",method=RequestMethod.POST)
	@ResponseBody
	public String isExit(Emp emp,HttpServletRequest request) {
		if(empService.selectByName(emp) != null) {
			return "fail";
		} else {
			return "success";
		}
	}
	
	/**
	 * 员工登录
	 * @param emp
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="empLogin",method=RequestMethod.POST)
	@ResponseBody
	public String login(Emp emp,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Emp emp1 = empService.selectByEntity(emp);
		if(emp1 != null) {
			employeeID = emp1.getEmpId();
			session.setAttribute("user", emp1.getEmpName());
			return "success";
		} else {
			return "fail";
		}
	}
	
	/**
	 * 员工注册
	 * @param emp
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empRegister",method=RequestMethod.POST)
	@ResponseBody
	public String register(Emp emp,Model model) {
		if(empService.selectByName(emp) != null) {
			return "fail";
		} else {
			if(empService.addEmpInfo(emp)) {
				empService.updateEmpInfoByName(emp);
				return "success";	
			} 
		}
		return "fail";
	}
	
	/**
	 * 删除指定ID的员工的信息（管理员）
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empDelete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(Emp emp) {
		System.out.println("开始删除员工");
		if(empService.deleteEmpInfoById(emp.getEmpId())) {
			System.out.println("员工删除成功");
			return "success";
		}
		System.out.println("员工删除失败");
		return "fail";
	}
	
	/**
	 * 激活指定ID的员工的权限（管理员）
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empUpdate",method=RequestMethod.POST)
	@ResponseBody
	public String update(HttpServletRequest request,Emp emp) {
		System.out.println("开始激活员工权限");
		emp.setEmpName(request.getSession().getAttribute("user").toString());
		if(empService.updateEmpInfo(emp)) {
			System.out.println("员工权限激活成功");
			return "success";
		}
		System.out.println("员工权限激活失败");
		return "fail";
	}
	
	/**
	 * 修改指定ID的员工的职位（管理员）
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empUpdateJob",method=RequestMethod.POST)
	@ResponseBody
	public String empUpdateJob(HttpServletRequest request,Emp emp) {
		System.out.println("开始修改员工职位");
		emp.setEmpName(request.getSession().getAttribute("user").toString());
		if(empService.updateEmpJobInfo(emp)) {
			System.out.println("员工职位修改成功");
			return "success";
		}
		System.out.println("员工职位修改失败");
		return "fail";
	}
	
	/**
	 * 转到修改员工信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empGoUpdate",method=RequestMethod.GET)
	@ResponseBody
	public List<Emp> goUpdateEmp(Emp emp) {
		List<Emp> empList = empService.selectAll();
		return empList;
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empdowmLine",method=RequestMethod.GET)
	@ResponseBody
	public String dowmLine(HttpServletRequest request) {
		employeeID = 0;
		request.getSession().invalidate();
		System.out.println("用户已下线");
		return "success";
	}
	
	/**
	 * 转到添加房屋信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empGoAddHouse",method=RequestMethod.GET)
	public String empGoAddHouse() {
		return "houseAdd";
	}
	
	/**
	 * 转到个人信息的修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empGoUpdateOwn",method=RequestMethod.POST)
	@ResponseBody
	public Emp goUpdateOwn(Emp emp) {
		Emp emp1 = empService.selectByName(emp);
		return emp1;
	}
	
	 /* 修改个人信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empUpdateOwn",method=RequestMethod.POST)
	@ResponseBody
	public String UpdateOwn(Emp emp) {
		if(empService.selectByName(emp) != null) {
			return "false";
		} else {
			if(empService.updateOwn(emp)) {
				return "success";
			} else {
				return "false";
			}
		}
	}
}
