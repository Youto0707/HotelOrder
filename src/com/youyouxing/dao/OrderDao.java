package com.youyouxing.dao;

import com.youyouxing.entity.Order;

import java.sql.Date;
import java.util.ArrayList;

public interface OrderDao {
    boolean updateOrderState(String ordernumber);
    boolean deleteBookedOrder(String ordernumber);
    ArrayList<Order> getAllOrders();
    boolean  updateNewDate(Date newdate , String orderNumber);
    boolean checkOutRoom(String orderNumber);
    Order getOrder(String roomid);
    int getOrderNum();
    boolean insertOrder(Order order);

}
