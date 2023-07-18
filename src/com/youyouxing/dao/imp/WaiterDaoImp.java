package com.youyouxing.dao.imp;

import com.youyouxing.dao.WaiterDao;
import com.youyouxing.entity.Waiter;
import com.youyouxing.util.GetConn;

import java.sql.*;
import java.util.ArrayList;

public class WaiterDaoImp implements WaiterDao {

    @Override
    public boolean deleteWaiter(Waiter waiter) {
        Connection connection = null;
        Statement statement = null;
        int row = 0;
        String sql = "DELETE  FROM waiter where waiterID='" + waiter.getWaiterID() + "'";
        try {
            connection =  GetConn.getDruidConn();
            statement = connection.createStatement();
            row = statement.executeUpdate(sql);


        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return row==0?false:true;
    }

    @Override
    public boolean editWaiter(Waiter waiter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update waiter set waiterName=?,waiterBirthday=?,waiterIDCard=?,waiterPassword=?" +
                ",waiterJoinDate=?,waiterPhoneNumber=?,remarks=? where waiterID=?";
        int row = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,waiter.getWaiterName());
            preparedStatement.setString(2,waiter.getWaiterBirthday());
            preparedStatement.setString(3,waiter.getWaiterIDCard());
            preparedStatement.setString(4,waiter.getWaiterPassword());
            preparedStatement.setString(5,waiter.getWaiterJoinDate());
            preparedStatement.setString(6,waiter.getWaiterPhoneNumber());
            preparedStatement.setString(7,waiter.getRemarks());
            preparedStatement.setString(8,waiter.getWaiterID());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        }
        return row==1?true:false;

    }

    @Override
    public Waiter getWaiter(String waiterID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Waiter waiter =null ;

        try {
            connection =  GetConn.getDruidConn();
            String sql ="select * from waiter where waiterID='"+waiterID+"'" ;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                waiter =new Waiter(resultSet.getString("waiterID")
                        ,resultSet.getString("waiterName")
                        ,resultSet.getString("waiterBirthday")
                        ,resultSet.getString("waiterIDCard")
                        ,resultSet.getString("waiterPassword")
                        ,resultSet.getString("waiterJoinDate")
                        ,resultSet.getString("waiterPhoneNumber")
                        ,resultSet.getString("remarks")) ;
                return waiter ;
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return null ;
    }

    @Override
    public ArrayList<Waiter> getAllWaiters() {
        ArrayList<Waiter> allWaiters = new ArrayList<Waiter>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection =  GetConn.getDruidConn();
            if (connection != null) {
                System.out.println("查询---数据库连接成功");
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM waiter");

            //获取结果数据集
            resultSet = preparedStatement.executeQuery();
            //获取数据库中订单信息
            while (resultSet.next()) {
//                    public Waiter(String waiterID,
//                        String waiterName,
//                        Date waiterBirthday,
//                        String waiterIDCard,
//                        String waiterPassword,
//                        Date waiterJoinDate
//                        String waiterPhoneNumber,
//                        String remarks) {
                Waiter waiter = new Waiter(resultSet.getString("waiterID"),
                        resultSet.getString("waiterName"),
                        resultSet.getString("waiterBirthday"),
                        resultSet.getString("waiterIDCard"),
                        resultSet.getString("waiterPassword"),
                        resultSet.getString("waiterJoinDate"),
                        resultSet.getString("waiterPhoneNumber"),
                        resultSet.getString("remarks"));
                allWaiters.add(waiter);
            }

        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return allWaiters;
    }

    @Override
    public boolean insertWaiter(Waiter waiter) {
        System.out.println("要插入waiter了！！！");
        System.out.println(waiter);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into wariter(waiterID,waiterName,waiterBirthday,waiterIDCard,waiterPassword,waiterJoinDate," +
                "waiterPhoneNumber,remarks) values (?,?,?,?,?,?,?,?)";
        int row = 0;
        try {
            connection = GetConn.getDruidConn();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, waiter.getWaiterID());
            preparedStatement.setString(2, waiter.getWaiterName());
            preparedStatement.setString(3, waiter.getWaiterBirthday());
            preparedStatement.setString(4, waiter.getWaiterIDCard());
            preparedStatement.setString(5, waiter.getWaiterPassword());
            preparedStatement.setString(6, waiter.getWaiterJoinDate());
            preparedStatement.setString(7, waiter.getWaiterPhoneNumber());
            preparedStatement.setString(8, waiter.getRemarks());
            row = preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            //关闭语句

        }
        return row == 1 ? true : false;
    }

}
