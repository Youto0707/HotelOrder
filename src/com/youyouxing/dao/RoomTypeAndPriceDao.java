package com.youyouxing.dao;

import com.youyouxing.entity.RoomTypeAndPrice;

import java.util.ArrayList;
import java.util.HashMap;

public interface RoomTypeAndPriceDao {
    boolean updateRoomPrice(String roomType,int newprice);
    HashMap<String, RoomTypeAndPrice> getRoomTypeMap();
    ArrayList<RoomTypeAndPrice> getAllRooms();
    double getPrice(String type );
    ArrayList<RoomTypeAndPrice> searchRoom(String s1 ,String s2,String s3);
}
