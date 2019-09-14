package com.dbs.serviceImpl;

import java.util.List;
import com.dbs.entity.House;
import com.dbs.entity.Order;
import com.dbs.entity.User;
import com.dbs.mapper.OrderMapper;
import com.dbs.service.OrderService;

public class OrderServiceImp implements OrderService {
	private OrderMapper omapper;
	
	public List<House> selectAllEmptyHouse() {
		return omapper.selectAllEmptyHouse();
	}

	public boolean updateHouseStateByOrder(House house) {
		return omapper.updateHouseStateByOrder(house);
	}

	public boolean orderAdd(Order order) {
		return omapper.orderAdd(order);
	}

	public List<House> orderShow() {
		return omapper.orderShow();
	}

	public OrderMapper getOmapper() {
		return omapper;
	}

	public void setOmapper(OrderMapper omapper) {
		this.omapper = omapper;
	}

	public boolean changeOrderA(House house) {
		return omapper.changeOrderA(house);
	}

	public boolean changeOrderC(House house) {
		return omapper.changeOrderC(house);
	}

	public boolean deleteOrder(House house) {
		return omapper.deleteOrder(house);
	}

	public List<Order> ordShow() {
		return omapper.ordShow();
	}

	public List<Order> selectOrderByName(String userName) {
		return omapper.selectOrderByName(userName);
	}

	public boolean userAdd(User user) {
		return omapper.userAdd(user);
	}

	public int selectUserIdByUserName(String userName) {
		return omapper.selectUserIdByUserName(userName);
	}

	public boolean reserveAdd(House house) {
		return omapper.reserveAdd(house);
	}

	public List<House> selectAllHouse() {
		return omapper.selectAllHouse();
	}
}
