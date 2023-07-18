package com.youyouxing.dao.imp;

import com.youyouxing.dao.TimeExtensionDao;
import com.youyouxing.entity.TimeExtension;
import com.youyouxing.util.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TimeExtensionDaoImp implements TimeExtensionDao {
    @Override
    public int getRenewNum() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection =  GetConn.getDruidConn();
            String sql ="select count(*) from timeextension " ;
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
    public boolean addRenew(TimeExtension renew) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into timeextension(operatingID,orderNumber,oldExpiryDate,newExpiryDate,addedMoney) values (?,?,?,?,?)";
        int row = 0;
        try {
            connection =  GetConn.getDruidConn();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,renew.getOperatingID());
            preparedStatement.setString(2,renew.getOrderNumber());
            preparedStatement.setString(3,renew.getOldExpiryDate());
            preparedStatement.setString(4,renew.getNewExpiryDate());
            preparedStatement.setInt(5,renew.getAddedMoney());
            row = preparedStatement.executeUpdate();
        } catch(Exception exception) {
            exception.printStackTrace();
        } finally {
            //关闭语句

        }
        return row==1?true:false;
    }
}
