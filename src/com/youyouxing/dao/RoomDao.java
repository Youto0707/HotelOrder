package com.youyouxing.dao;

import com.youyouxing.entity.Room;

import java.util.ArrayList;

public interface RoomDao {
    ArrayList<Integer> getNumofRoom(String roomType);
    ArrayList<Room> getAllRoomsInfo(String s , String search);
    ArrayList<String> searchFullRooms();
    ArrayList<String> searchEmptyRooms(String roomtype);
    boolean insertRoom(Room room);
    double getRoomPrice(String roomid);
}
