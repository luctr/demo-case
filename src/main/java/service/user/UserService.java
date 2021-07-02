package service.user;

import model.User;
import service.category.CategoryService;
import service.category.ICategoryService;
import service.connection.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUser{
    private Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        String sql = "select * from user u";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("username"));
                user.setPassword(resultSet.getInt("password"));
                user.setRole(resultSet.getString("role"));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet  = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("username"));
                user.setPassword(resultSet.getInt("password"));
                user.setRole(resultSet.getString("role"));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> list = new ArrayList<>();
        String sql = "select * from user where username like ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"%"+name+"%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("username"));
                user.setPassword(resultSet.getInt("password"));
                user.setRole(resultSet.getString("role"));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<User> findListById(int id) {
        return null;
    }

    @Override
    public void save(User user) {
        String sql = "insert into user (name,password,role) values (?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setInt(2,user.getPassword());
            preparedStatement.setString(3,user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(int id, User user) {
        String sql = "update user set username = ?,password = ?,role = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setInt(2,user.getPassword());
            preparedStatement.setInt(3,user.getPassword());
            preparedStatement.setInt(4,user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql ="delete from user where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
