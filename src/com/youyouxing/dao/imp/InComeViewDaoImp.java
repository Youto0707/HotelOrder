package com.youyouxing.dao.imp;

import com.youyouxing.dao.InComeViewDao;
import com.youyouxing.entity.InComeView;
import com.youyouxing.entity.Waiter;
import com.youyouxing.util.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InComeViewDaoImp implements InComeViewDao {
    @Override
    public ArrayList<InComeView> getInComeView() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Waiter waiter =null;
        ArrayList<InComeView>inComeViews =new ArrayList<InComeView>();
        try {
            connection =  GetConn.getDruidConn();
            String sql = "select * from incomeView";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                inComeViews.add(
                        new InComeView(resultSet.getDate("co").toString() ,resultSet.getInt("tot"),
                                resultSet.getInt("num"))
                );
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }

        return inComeViews;
    }
}
