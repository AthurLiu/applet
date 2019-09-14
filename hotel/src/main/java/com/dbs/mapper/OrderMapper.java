package com.dbs.mapper;

import java.util.List;
import com.dbs.entity.House;
import com.dbs.entity.Order;
import com.dbs.entity.User;

public interface OrderMapper {
	/**
	 * 查询所有空房间（前台）
	 * @return
	 */
	public List<House> selectAllEmptyHouse();
	
	/**
	 * 查询所有房间（前台）
	 * @return
	 */
	public List<House> selectAllHouse();
	
	/**
	 * 显示所有预定的房间（前台）
	 * @return
	 */
	public List<House> orderShow();
	
	/**
	 * 	显示订房信息（前台）
	 * @return
	 */
	public List<Order> ordShow();
	
	/**
	 * 显示指定用户的订房信息（前台）
	 * @return
	 */
	public List<Order> selectOrderByName(String userName);
	
	/**
	 * 修改客房信息，即空房-->已预订（前台）
	 * @param house
	 * @return
	 */
	public boolean updateHouseStateByOrder(House house);
	
	/**
	 * 向预定表里加入预定信息（前台）
	 * @param order
	 * @return
	 */
	public boolean orderAdd(Order order);
	
	/**
	 *	转接待时向用户表里面插入信息（前台）
	 * @param order
	 * @return
	 */
	public boolean userAdd(User user);
	
	/**
	 *	转接待时入住表里加入信息（前台）
	 * @param order
	 * @return
	 */
	public boolean reserveAdd(House house);
	
	/**
	 * 取消订房（前台）
	 * @param house
	 * @return
	 */
	public boolean changeOrderA (House house);
	
	/**
	 * 转接待（前台）
	 * @param house
	 * @return
	 */
	public boolean changeOrderC (House house);
	
	/**
	 * 删除订单表里的信息（前台）
	 * @param house
	 * @return
	 */
	public boolean deleteOrder (House house);
	
	/**
	 * 	查出指定userName的人的userId
	 * @param userName
	 * @return
	 */
	public int selectUserIdByUserName(String userName);
}
