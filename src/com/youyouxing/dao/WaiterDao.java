package com.youyouxing.dao;

import com.youyouxing.entity.Waiter;

import java.util.ArrayList;

public interface WaiterDao {
    public abstract boolean deleteWaiter(Waiter waiter);
    public abstract boolean editWaiter(Waiter waiter);
    Waiter getWaiter(String waiterID);
    ArrayList<Waiter> getAllWaiters();

    boolean insertWaiter(Waiter waiter);
}
