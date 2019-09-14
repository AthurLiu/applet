package com.dbs.action;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dbs.entity.Emp;
import com.dbs.entity.House;
import com.dbs.service.EmpService;
import com.dbs.service.HouseService;

/**
 * 酒店管理系统
 */
@Controller
public class HouseInfoAction {
	@Autowired
	private HouseService houseService;
	@Autowired
	private EmpService empService;
	
	/**
	 * 酒店房间添加（房管员）
	 * @param house
	 * @param model
	 * @return
	 */
	@RequestMapping(value="houseAdd",method=RequestMethod.POST)
	public String houseAdd(HttpServletRequest request,House house,Model model) {
		Emp emp = new Emp();
		emp.setEmpName(request.getSession().getAttribute("user").toString());
		emp = empService.selectByName(emp);
		house.setCreateId(emp.getEmpId());
		house.setUpdateId(emp.getEmpId());
		if(houseService.houseAdd(house)) {
			model.addAttribute("emp1", emp);
			return "empMain";
		} else {
			model.addAttribute("msg", "提示：添加失败！");
		}
		return "houseAdd";
	}
	
	/**
	 * 酒店房间显示（房管员）
	 * @param house
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empGoshowHouse",method=RequestMethod.GET)
	public String selectAllHouse(Model model) {
		List<House> houseList = houseService.selectAllHouse();
		model.addAttribute("houseList", houseList);
		return "houseManager";
	}
	
	/**
	 * 	酒店房间删除（房管员）
	 * @param house
	 * @param model
	 * @return
	 */
	@RequestMapping(value="houseDelete",method=RequestMethod.POST)
	public String houseDelete(House house,Model model) {
		if(houseService.houseDelete(house.getHouseId())) {
			model.addAttribute("msg", "提示：删除成功！");
		} else {
			model.addAttribute("msg", "提示：删除失败！");
		}
		List<House> houseList = houseService.selectAllHouse();
		model.addAttribute("houseList", houseList);
		return "houseManager";
	}
	
	/**
	 *	 酒店房间价格修改（房管员）
	 * @param house
	 * @param model
	 * @return
	 */
	@RequestMapping(value="houseUpdate",method=RequestMethod.POST)
	public String houseUpdate(HttpServletRequest request,House house,Model model) {
		if(EmpInfoAction.employeeID == 0) {
			model.addAttribute("msg", "提示：房间价格修改失败，用户已下线！");
		} else {
			house.setUpdateId(EmpInfoAction.employeeID);
			if(houseService.houseUpdate(house)) {
				model.addAttribute("msg", "提示：房间价格修改成功！");
			} else {
				model.addAttribute("msg", "提示：房间价格修改失败！");
			}
			List<House> houseList = houseService.selectAllHouse();
			model.addAttribute("houseList", houseList);
		}	
		return "houseManager";
	}
}
