package com.youyouxing.dao.imp;

import com.youyouxing.dao.SystemAdministratorDao;
import com.youyouxing.entity.SystemAdministrator;
import com.youyouxing.util.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SystemAdministratorDaoImp implements SystemAdministratorDao {
    @Override
    public SystemAdministrator loginSystemAdministrator(SystemAdministrator systemAdministrator) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
        try {
            connection =  GetConn.getDruidConn();
            preparedStatement = connection.prepareStatement("SELECT userID,userName,userPassword FROM systemAdministrator where userID=? and userPassword=?");
            //获取结果数据集
            resultSet = preparedStatement.executeQuery();
            preparedStatement.setString(1,systemAdministrator.getUserID());
            preparedStatement.setString(2,systemAdministrator.getUserPassword());
            resultSet= preparedStatement.executeQuery();
            if (resultSet.next()){
                SystemAdministrator systemAdministratorLogin = new SystemAdministrator();
                systemAdministratorLogin.setUserID(resultSet.getString("userID"));
                systemAdministratorLogin.setUserName(resultSet.getString("userName"));
                systemAdministratorLogin.setUserPassword(resultSet.getString("userPassword"));
                return systemAdministratorLogin;
            }
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            //关闭数据集
        }
        return null;

    }

    @Override
    public List<SystemAdministrator> getAllSystemAdministrator() {
        List<SystemAdministrator> allSystemAdmins = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection =  GetConn.getDruidConn();
            preparedStatement = connection.prepareStatement("SELECT userID,userName,userPassword FROM systemAdministrator");
            //获取结果数据集
            resultSet = preparedStatement.executeQuery();
            //获取数据库中订单信息
            while (resultSet.next()) {
                SystemAdministrator systemAdministrator = new SystemAdministrator(resultSet.getString("userID"),
                        resultSet.getString("userName"), resultSet.getString("userPassword"));
                allSystemAdmins.add(systemAdministrator);
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        } finally {
            //关闭数据集
        }
        return allSystemAdmins;
    }

    @Override
    public boolean insertSystemAdministrator(SystemAdministrator systemAdministrator) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try {
            connection =  GetConn.getDruidConn();
            preparedStatement = connection.prepareStatement("insert into systemadministrator (userID,userName,userPassword) values(?,?,?)");
            preparedStatement.setString(1,systemAdministrator.getUserID());
            preparedStatement.setString(2,systemAdministrator.getUserName());
            preparedStatement.setString(3,systemAdministrator.getUserPassword());
            row = preparedStatement.executeUpdate();
        } catch(Exception exception) {
            exception.printStackTrace();
        } finally {
            //关闭语句
        }
        return row==1?true:false;
    }

    @Override
    public boolean deleteSystemAdministrator(String userID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int row = 0;
        try {
            connection = GetConn.getDruidConn();
            preparedStatement = connection.prepareStatement("delete from systemadministrator where userID=?");
            preparedStatement.setString(1,userID);
            row = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row==0?false:true;
    }
}
