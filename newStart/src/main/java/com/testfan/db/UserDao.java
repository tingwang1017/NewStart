package com.testfan.db;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class UserDao {
	
	public static List<User> getAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from t_user_testfan limit 100";
        List<User> list = (List) runner.query(sql, new BeanListHandler(User.class));
        return list;
    }
	
	public static User getById(String id) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from t_user_testfan where uid=?";
        User user=  (User) runner.query(sql, new BeanHandler(User.class),id);
        return user;
    }
	
	public static void delete() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "delete * from t_user_testfan where id=? and uid =?";
        runner.update(sql);
        runner.update(sql,"1");
        runner.update(sql,"1","2","3","4");
        runner.update(sql,new Object[] {"1","3"});
    }
	
	public static void main(String[] args) {
		try {
//			List<User> list = UserDao.getAll();
//			for (User user : list) {
//				System.out.println(user);
//			}
			User user = getById("0003bc7f-0af7-48f8-b406-5adc7f391bf3");
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
