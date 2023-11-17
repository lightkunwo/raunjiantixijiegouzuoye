package cs2_.Dao;

import java.sql.*;

public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/tongxunlu";
    private  static  final  String driver = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "fhh257248mvp";
    static Connection connection ;
    static   {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
            sqlException.printStackTrace();
        }
    }

    public static int insert(String name,String phone)  {
        String sql="insert into lianxiren values(?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            int i = preparedStatement.executeUpdate();
            return i;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }
    public static int delete(String name)  {
        String sql="delete  from  lianxiren where name=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            int i = preparedStatement.executeUpdate();

            return i;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }
    public static int update(String name3,String name,String phone)  {
        String sql="update  lianxiren set name=?,phone=? where name=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3,name3);
            int i = preparedStatement.executeUpdate();

            return i;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }
    public static void query() throws SQLException {
        String sql="select * from lianxiren";
        PreparedStatement pre=connection.prepareStatement(sql);

        ResultSet resultSet = pre.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("phone"));
        }
    }
}
