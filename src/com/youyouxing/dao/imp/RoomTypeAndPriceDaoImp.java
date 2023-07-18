package com.youyouxing.dao.imp;

import com.youyouxing.dao.RoomTypeAndPriceDao;
import com.youyouxing.entity.RoomTypeAndPrice;
import com.youyouxing.util.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class RoomTypeAndPriceDaoImp implements RoomTypeAndPriceDao {
    @Override
    public boolean updateRoomPrice(String roomType, int newprice) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        String sql = "update roomtypeandprice set price=?  where  roomType=?";
        try {
            connection =  GetConn.getDruidConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newprice);
            preparedStatement.setString(2,roomType);


            row = preparedStatement.executeUpdate();
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return row==1?true:false;
    }

    @Override
    public HashMap<String, RoomTypeAndPrice> getRoomTypeMap() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HashMap<String,RoomTypeAndPrice> map =new HashMap<String, RoomTypeAndPrice>() ;
        try {
            connection =  GetConn.getDruidConn();
            String sql ="select * from roomtypeandprice " ;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                map.put(resultSet.getString("roomType") ,
                        new  RoomTypeAndPrice(resultSet.getString("roomType")
                                ,Integer.parseInt(resultSet.getString("price")),
                                resultSet.getString("desc"),
                                resultSet.getString("url")) );

            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return map ;
    }

    @Override
    public ArrayList<RoomTypeAndPrice> getAllRooms() {
        ArrayList<RoomTypeAndPrice> allRooms =new ArrayList<RoomTypeAndPrice>() ;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection =  GetConn.getDruidConn();
            preparedStatement = connection.prepareStatement("SELECT * FROM roomtypeandprice");
            //获取结果数据集
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RoomTypeAndPrice roomTypeAndPrice= new RoomTypeAndPrice(
                        resultSet.getString("roomtype"),
                        resultSet.getInt("price"),
                        resultSet.getString("desc"),
                        resultSet.getString("url")
                );
                allRooms.add(roomTypeAndPrice);
            }

        } catch(Exception exception) {
            exception.printStackTrace();
        }

        return allRooms ;
    }

    @Override
    public double getPrice(String type) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection =  GetConn.getDruidConn();
            String sql ="select price from roomtypeandprice where roomType='"+type+"'" ;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getDouble("price");
            }

        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return 1.00 ;
    }

    @Override
    public ArrayList<RoomTypeAndPrice> searchRoom(String s1, String s2, String s3) {
        ArrayList<RoomTypeAndPrice> allRooms =new ArrayList<RoomTypeAndPrice>() ;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String[]arr = s3.split("-") ;
        if(s1.equals("任意"))
            s1="" ;
        if(s2.equals("任意"))
            s2="" ;
        if(s3.equals("任意"))
            s3="" ;
        try {
            connection =  GetConn.getDruidConn();
            if(!s3.equals(""))
                preparedStatement = connection.prepareStatement(
                        "select * from roomtypeandprice where roomType like '%"+s1+"%' and roomType like '%"+s2+
                                "%' and  price BETWEEN "+arr[0]+" and "+arr[1]
                );
            else
                preparedStatement = connection.prepareStatement(
                        "select * from roomtypeandprice where roomType like '%"+s1+"%' and roomType like '%"+s2+
                                "%'"
                );
            //获取结果数据集
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RoomTypeAndPrice roomTypeAndPrice= new RoomTypeAndPrice(
                        resultSet.getString("roomtype"),
                        resultSet.getInt("price"),
                        resultSet.getString("desc"),
                        resultSet.getString("url")
                ) ;
                allRooms.add(roomTypeAndPrice);
            }

        } catch(Exception exception) {
            exception.printStackTrace();
        }

        return allRooms ;
    }
}
