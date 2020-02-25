package com.test.wjq.mysql;

import java.sql.*;
import java.util.concurrent.TimeUnit;

/**
 * @author wjq
 * @version 1.0.0
 * @ClassName TestMvvc.java
 * @createTime 2020年02月24日 09:25:00
 */
public class TestMvvc {

    public static void main(String[] args) {

        TestMvvc mvvc = new TestMvvc();
        new Thread(() -> {
            mvvc.update(8, 629609, 15);
        }).start();

        mvvc.update(7, 629609, 13);


    }


    public Connection getConnection() throws SQLException {
        String url = "";
        String user = "";
        String password = "";
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;

    }


    public void update(int status, int id, int time) {

        String sql = "update mcc_push_consume_prepare set push_status = " + status + " where push_id = " + id;

        String select = "select * from mcc_push_consume_prepare where push_id = " + id;

        try {
            Connection connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            System.out.println("start " + sql);

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            ResultSet resultSet = connection.prepareStatement(select).executeQuery();
            if (resultSet.next()) {
                int rowId = resultSet.getInt("push_status");
                System.out.println(rowId);
            }
            TimeUnit.SECONDS.sleep(time);
            connection.commit();
            System.out.println("commit " + sql);
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
