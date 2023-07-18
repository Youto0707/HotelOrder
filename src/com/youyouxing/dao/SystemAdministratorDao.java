package com.youyouxing.dao;

import com.youyouxing.entity.SystemAdministrator;

import java.util.List;

public interface SystemAdministratorDao {
    SystemAdministrator loginSystemAdministrator(SystemAdministrator systemAdministrator);
    List<SystemAdministrator> getAllSystemAdministrator();
    boolean insertSystemAdministrator(SystemAdministrator systemAdministrator);
    boolean deleteSystemAdministrator(String userID);
}
