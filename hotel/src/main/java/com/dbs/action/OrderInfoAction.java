package com.dbs.action;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dbs.entity.House;
import com.dbs.entity.Order;
import com.dbs.entity.User;
import com.dbs.service.OrderService;

/**
 * 酒店管理系统
 */
@Controller
public class OrderInfoAction {
	@Autowired
	private OrderService orderService;

	/**
	 * 预定和入住
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empGoAddOrder",method=RequestMethod.GET)
	public String empGoAddOrder(Model model) {
		model.addAttribute("houseList", orderService.selectAllEmptyHouse());
		return "orderAdd";
	}
	
	/**
	 * 显示房间状态
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empGoshowHouseState",method=RequestMethod.GET)
	public String empGoshowHouseState(Model model) {
		model.addAttribute("houseList", orderService.selectAllHouse());
		return "houseShow";
	}

	
	
	/**
	 * 添加订单信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="addOrder",method=RequestMethod.POST)
	public String addOrder(HttpServletRequest request , House house , Model model) {
		if(EmpInfoAction.employeeID == 0) {
			model.addAttribute("msg", "提示：房间预定修改失败，前台已下线！");
		} else {
			Order order = new Order();
			order.setHouseId(Integer.parseInt(request.getParameter("houseId")));
			order.setUserName(request.getParameter("userName"));
			order.setCreateId(EmpInfoAction.employeeID);
			house.setUpdateId(EmpInfoAction.employeeID);
			if(orderService.updateHouseStateByOrder(house) && orderService.orderAdd(order)) {
				model.addAttribute("msg", "提示：房间预定成功！");
			} else {
				model.addAttribute("msg", "提示：房间预定失败！");
			}
			model.addAttribute("houseList", orderService.selectAllEmptyHouse());
		}	
		return "orderAdd";
	}
	
	/**
	 * 转到修改订单信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empGoChangeOrder",method=RequestMethod.GET)
	public String showOrder(Model model) {
		model.addAttribute("houseList", orderService.orderShow());
		return "orderManager";
	}
	
	/**
	 * 转到显示订房信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="empGoShowOrder",method=RequestMethod.GET)
	public String showReserve(Model model) {
		model.addAttribute("orderList", orderService.ordShow());
		return "orderShow";
	}
	
	/**
	 * 取消订房
	 * @param house
	 * @param model
	 */
	@RequestMapping(value="changeOrderA",method=RequestMethod.POST)
	public String changeOrderA(House house,Model model) {
		if(EmpInfoAction.employeeID == 0) {
			model.addAttribute("msg", "提示：房间取消失败，前台已下线！");
		} else {
			house.setUpdateId(EmpInfoAction.employeeID);
			if(orderService.changeOrderA(house) && orderService.deleteOrder(house)) {
				model.addAttribute("msg", "提示：房间取消成功！");
			} else {
				model.addAttribute("msg", "提示：房间取消失败！");
			}
		}
		model.addAttribute("houseList", orderService.orderShow());
		return "orderManager";
	}
	
	/**
	 * 	跳到转接待
	 * @param house
	 * @param model
	 */
	@RequestMapping(value="changeReciver",method=RequestMethod.POST)
	public String changeReciver(HttpServletRequest request,Model model) {
		model.addAttribute("userName", request.getParameter("userName"));
		model.addAttribute("houseId", request.getParameter("houseId"));
		model.addAttribute("houseDep", request.getParameter("houseDep"));
		return "reserveAdd";
	}
	
	/**
	 * 查找指定用户的订房信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="selectOrderByName",method=RequestMethod.POST)
	public String selectOrderByName(HttpServletRequest request, Model model) {
		List<Order> orderList = orderService.selectOrderByName(request.getParameter("userName"));
		if(orderList.size() == 0) {
			model.addAttribute("msg", "提示：客人"+ request.getParameter("userName") + "没有预定房间！");
		} else {
			model.addAttribute("msg", "提示：客人"+ request.getParameter("userName") + "已经预定房间！");
		}
		model.addAttribute("orderList", orderList);
		return "orderShow";
	}
	
	/**
	 * 	实现转接待
	 * @param house
	 * @param model
	 */
	@RequestMapping(value="reserveAdd",method=RequestMethod.POST)
	public String reserveAdd(User user1 , HttpServletRequest request, Model model) {
		House house = new House();
		if(EmpInfoAction.employeeID == 0) {
			model.addAttribute("msg", "提示：入住办理失败，前台已下线！");
		} else {
			model.addAttribute("msg", "提示：入住办理失败！");
			house.setHouseId(user1.getUpdateId());
			house.setHouseNet(user1.getCreateTime());
			house.setUpdateId(EmpInfoAction.employeeID);
			house.setHouseDep(Double.parseDouble(request.getParameter("houseDep")));
			user1.setCreateId(EmpInfoAction.employeeID);
			orderService.userAdd(user1);
			house.setCreateId(orderService.selectUserIdByUserName(user1.getUserName()));
			orderService.reserveAdd(house);
			orderService.changeOrderC(house);
			orderService.deleteOrder(house);
			model.addAttribute("msg", "提示：入住办理成功！");
		}
		return "reserveAdd";
	}
}
