package com.youyouxing.dao.imp;

import com.youyouxing.dao.CustomerDao;
import com.youyouxing.entity.Customer;
import com.youyouxing.util.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDaoImp implements CustomerDao {
    @Override
    public boolean addCustomer(Customer cu) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Customers (CustomerIDCard,CustomerGender,CustomerName,CustomerBirthday,CustomerVIPLevel,CustomerPhoneNumber,TotalAmount,Remarks) VALUES()";
        int row =  0;
        try {
            connection =  GetConn.getDruidConn();
//            preparedStatement = connection.prepareStatement("INSERT INTO Customers VALUES('" +
//                    cu.getCustomerIDCard()+"','"+cu.getCustomerGender()+"','"+cu.getCustomerName()+"','"+cu.getCustomerBirthday()
//                    +"',"+Integer.parseInt(cu.getCustomerVIPLevel())+",'"+cu.getCustomerPhoneNumber()+"',"+cu.getTotalAmount()
//                    +",'"+cu.getRemarks()+ "');");
//            preparedStatement.execute();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cu.getCustomerIDCard());
            preparedStatement.setString(2,cu.getCustomerGender());
            preparedStatement.setString(3,cu.getCustomerName());
            preparedStatement.setString(4,cu.getCustomerBirthday());
            preparedStatement.setInt(5,cu.getCustomerVIPLevel());
            preparedStatement.setString(6,cu.getCustomerPhoneNumber());
            preparedStatement.setInt(7,cu.getTotalAmount());
            preparedStatement.setString(8,cu.getRemarks());
            row = preparedStatement.executeUpdate();
        } catch(Exception exception) {
            exception.printStackTrace();
        } finally {

        }
        return row==0?false:true;
    }

    @Override
    public boolean isIDexists(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql  = "select * from Customers where customerIDCard=?";
        ResultSet resultSet = null;
        try {
            connection =  GetConn.getDruidConn();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true ;
            }
            return false ;
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return false ;
    }

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
}
