package com.youyouxing.dao.imp;

import com.youyouxing.dao.VIPLevelDao;
import com.youyouxing.util.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VIPLevelDaoImp implements VIPLevelDao {
    @Override
    public int searchVIPlevel(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection =  GetConn.getDruidConn();
            String sql ="select customerVIPLevel from customers where customerIDCard=' "+id+"'" ;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int level = resultSet.getInt("customerVIPLevel") ;
                return level ;
            }

        } catch(Exception exception) {
            exception.printStackTrace();
        }

        return 1 ;
    }

    @Override
    public double searchDiscount(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int level =searchVIPlevel(id) ; //该用户的会员等级
        try {
            connection =  GetConn.getDruidConn();
            String sql ="select discount from viplevel where level="+level ;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getDouble("discount") ;
            }

        } catch(Exception exception) {
            exception.printStackTrace();
        }

        return 1.00 ;
    }
}
