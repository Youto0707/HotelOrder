package com.youyouxing.dao.imp;

import com.youyouxing.dao.RoomDao;
import com.youyouxing.entity.Room;
import com.youyouxing.util.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RoomDaoImp implements RoomDao {
    @Override
    public ArrayList<Integer> getNumofRoom(String roomType) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Integer>list =new ArrayList<Integer>() ;
        try{
            connection =  GetConn.getDruidConn();
            preparedStatement = connection.prepareStatement(
                    "select * from  (select roomType,roomStatus ,count(*) from room group by roomType,roomStatus) c where c.roomStatus='空' and c.roomType='"+roomType+"'");
            //获取结果数据集
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add( resultSet.getInt("count(*)")) ;
            }
            preparedStatement = connection.prepareStatement(
                    "select * from  (select roomType,roomStatus ,count(*) from room group by roomType,roomStatus) c where c.roomStatus='非空' and c.roomType='"+roomType+"'");
            //获取结果数据集
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add( resultSet.getInt("count(*)")) ;
            }

            return list ;
        }catch(Exception exception) {
            exception.printStackTrace();
        }
        return null ;
    }

    @Override
    public ArrayList<Room> getAllRoomsInfo(String s, String search) {
        ArrayList<Room>Rooms = new ArrayList<Room>() ;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection =  GetConn.getDruidConn();
            String sql  ;
            if(!search.equals("")){
                sql ="select * from room where roomNumber like '%"+search+"%'" ;

            }else if(s.equals("")||s.equals("任意"))
                sql="select * from room " ;
            else
                sql="select * from room where roomStatus='"+s+"'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Rooms.add(new Room(
                        resultSet.getString("roomNumber"),
                        resultSet.getString("roomType"),
                        resultSet.getString("roomStatus"),
                        resultSet.getString("remarks")));
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return Rooms ;
    }

    @Override
    public ArrayList<String> searchFullRooms() {
        ArrayList<String>fullRooms =new ArrayList<String>() ;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection =  GetConn.getDruidConn();
            String sql ="select roomNumber from room where roomStatus='非空' " ;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                fullRooms.add(resultSet.getString("roomNumber"));
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return fullRooms ;
    }

    @Override
    public ArrayList<String> searchEmptyRooms(String roomtype) {
        ArrayList<String>emptyRooms =new ArrayList<String>() ;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection =  GetConn.getDruidConn();
            String sql ="select roomNumber from room where roomStatus='空' and roomType='"+roomtype+"'" ;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                emptyRooms.add(resultSet.getString("roomNumber"));
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return emptyRooms ;
    }

    @Override
    public boolean insertRoom(Room room) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        String sql = "insert into room (roomNumber,roomType,roomStatus,remarks) values(?,?,?,?)";
        try {
            connection =  GetConn.getDruidConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,room.getRoomNumber());
            preparedStatement.setString(2,room.getRoomType());
            preparedStatement.setString(3, room.getRoomStatus());
            preparedStatement.setString(4,room.getRemarks());

            row = preparedStatement.executeUpdate();
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return row==1?true:false;
    }

    @Override
    public double getRoomPrice(String roomid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection =  GetConn.getDruidConn();
            String sql ="select roomType from room where roomNumber='"+roomid+"'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return getRoomPrice(resultSet.getString("roomType")) ;
            }

        } catch(Exception exception) {
            exception.printStackTrace();
        }

        return 0;
    }
}
