package com.youyouxing.dao.imp;

import com.youyouxing.dao.OrderDao;
import com.youyouxing.entity.Order;
import com.youyouxing.util.GetConn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderDaoImp implements OrderDao {
    @Override
    public boolean updateOrderState(String ordernumber) {
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        String sql="update orders set orderStatus= '已入住' where orderNumber= "+"'"+ordernumber+"'";
        int row = 0;
        try{
            connection =  GetConn.getDruidConn();
            System.out.println(sql);
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.execute(sql);
            row = preparedStatement.executeUpdate();
            System.out.println("订单状态更新成功");
        }catch(Exception exception) {
            exception.printStackTrace();
        }
        return row == 0?false:true;
    }

    @Override
    public boolean deleteBookedOrder(String ordernumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try{
            connection =  GetConn.getDruidConn();
            String sql="update orders set orderStatus= '已退房' where orderNumber= "+"'"+ordernumber+"'";
            System.out.println(sql);
            preparedStatement=connection.prepareStatement(sql);

            row = preparedStatement.executeUpdate();
            System.out.println("订单状态更新成功");
        }catch(Exception exception) {
            exception.printStackTrace();
        }
        return row == 0?false:true;
    }

    @Override
    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> allOrders = new ArrayList<Order>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection =  GetConn.getDruidConn();
            preparedStatement = connection.prepareStatement("SELECT * FROM orders");
            //获取结果数据集
            resultSet = preparedStatement.executeQuery();
            //获取数据库中订单信息
            while (resultSet.next()) {
//                    public Order(String orderNumber,
//                        String orderStatus,
//                        String customerIDCard,
//                        String roomNumber,
//                        Date checkInTime,
//                        Date checkOutTime,
//                        int totalMoney,
//                        String remarks)
                Order orderItem = new Order(resultSet.getString("orderNumber"),
                        resultSet.getString("orderStatus"),
                        resultSet.getString("customerIDCard"),
                        resultSet.getString("roomNumber"),
                        resultSet.getString("checkInTime"),
                        resultSet.getString("checkOutTime"),
                        resultSet.getInt("totalMoney"),
                        resultSet.getString("waiterID"),
                        resultSet.getString("remarks"),
                        resultSet.getString("orderTime"));
                allOrders.add(orderItem);
            }

        } catch(Exception exception) {
            exception.printStackTrace();
        } finally {
            //关闭数据集

        }
        return allOrders;
    }

    @Override
    public boolean updateNewDate(Date newdate, String orderNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update orders set checkOutTime=? where orderNumber=?";
        int row = 0;
        try {
            connection =  GetConn.getDruidConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1,newdate);
            preparedStatement.setString(2,orderNumber);
            row = preparedStatement.executeUpdate();
        } catch(Exception exception) {
            exception.printStackTrace();
        } finally {

        }
        return row==0?false:true;
    }

    @Override
    public boolean checkOutRoom(String orderNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update orders set orderStatus='已退房' where orderNumber = ?";
        int row = 0;
        try {
            connection = GetConn.getDruidConn();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, orderNumber);

            row = preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            //关闭语句

        }
        return row == 1 ? true : false;
    }

    @Override
    public Order getOrder(String roomid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection =  GetConn.getDruidConn();
            String sql ="select * from orders where roomNumber='"+roomid+"' and orderStatus='已入住'" ;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Order( resultSet.getString("orderNumber"),
                        resultSet.getString("orderStatus")
                        ,resultSet.getString("customerIDCard")
                        ,resultSet.getString("roomNumber")
                        ,resultSet.getString("checkInTime")
                        ,resultSet.getString("checkOutTime")
                        ,resultSet.getInt("totalMoney")
                        ,resultSet.getString("waiterID")
                        ,resultSet.getString("remarks")
                        ,resultSet.getString("orderTime")) ;
            }

        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return null ;
    }

    @Override
    public int getOrderNum() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection =  GetConn.getDruidConn();
            String sql ="select count(*) from orders " ;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt("count(*)");

            }

        } catch(Exception exception) {
            exception.printStackTrace();
        }

        return 1 ;
    }

    @Override
    public boolean insertOrder(Order order) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into orders(orderNumber,orderStatus,customerIDCard,roomNumber,checkInTime,checkOutTime,totalMoney,waiterID,remarks,orderTime) values (?,?,?,?,?,?,?,?,?,?)";

        int row = 0;
        try {
            connection = GetConn.getDruidConn();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getOrderNumber());
            preparedStatement.setString(2, order.getOrderStatus());
            preparedStatement.setString(3, order.getCustomerIDCard());
            preparedStatement.setString(4, order.getRoomNumber());
            preparedStatement.setString(5, order.getCheckInTime());
            preparedStatement.setString(6, order.getCheckOutTime());
            preparedStatement.setInt(7, order.getTotalMoney());
            preparedStatement.setString(8, order.getWaiterID());
            preparedStatement.setString(9, order.getRemarks());
            preparedStatement.setString(10, order.getOrderTime());
            row = preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            //关闭语句

        }
        return row == 1 ? true : false;
    }


}
