package com.youyouxing.dao.imp;

import com.youyouxing.dao.OrderViewDao;
import com.youyouxing.entity.OrderView;
import com.youyouxing.util.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderViewDaoImp implements OrderViewDao {
    @Override
    public OrderView getFullOrderViews(String roomid) {
        ArrayList<OrderView> fullOrderViews = new ArrayList<OrderView>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection =  GetConn.getDruidConn();

            preparedStatement = connection.prepareStatement("select * from orderviews where roomNumber='"+roomid+"' and orderStatus='已入住'");
            //获取结果数据集
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderView orderView = new OrderView();
                orderView.setOrderNumder(resultSet.getString("orderNumber"));
                orderView.setCustomer(resultSet.getString("customerName"));
                orderView.setRoomNumber(resultSet.getString("roomNumber"));
                orderView.setRoomType(resultSet.getString("roomType"));
                orderView.setOrderTime(resultSet.getDate("orderTime"));
                orderView.setCheckInTime(resultSet.getDate("checkInTime"));
                orderView.setCheckOutTime(resultSet.getDate("checkOutTime"));
                int days = (int)((orderView.getCheckOutTime().getTime() - orderView.getCheckInTime().getTime())/1000/60/60/24/1);
                orderView.setDays(days);
                orderView.setCustomerPhoneNumber(resultSet.getString("customerPhoneNumber"));
                orderView.setPrice(resultSet.getInt("totalMoney"));
                orderView.setOrderStatus(resultSet.getString("orderStatus"));
                return orderView;

            }

        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<OrderView> getAllOrderViews(String orderStatus) {
        ArrayList<OrderView> allOrderViews = new ArrayList<OrderView>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection =  GetConn.getDruidConn();
            if (orderStatus.equals("")) {
                preparedStatement = connection.prepareStatement("select * from orderviews");
            } else {
                preparedStatement = connection.prepareStatement("select * from orderviews where orderStatus = '" + orderStatus + "'");
            }

            //获取结果数据集
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderView orderView = new OrderView();
                orderView.setOrderNumder(resultSet.getString("orderNumber"));
                orderView.setCustomer(resultSet.getString("customerName"));
                orderView.setRoomNumber(resultSet.getString("roomNumber"));
                orderView.setRoomType(resultSet.getString("roomType"));
                orderView.setOrderTime(resultSet.getDate("orderTime"));
                orderView.setCheckInTime(resultSet.getDate("checkInTime"));
                orderView.setCheckOutTime(resultSet.getDate("checkOutTime"));

                int days = (int)((orderView.getCheckOutTime().getTime() - orderView.getCheckInTime().getTime())/1000/60/60/24);

                orderView.setDays(days);

                orderView.setCustomerPhoneNumber(resultSet.getString("customerPhoneNumber"));
                orderView.setPrice(resultSet.getInt("totalMoney"));
                orderView.setOrderStatus(resultSet.getString("orderStatus"));
                allOrderViews.add(orderView);
            }

            return allOrderViews;
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return allOrderViews;
    }
}
