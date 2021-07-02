package service.category;

import model.Category;
import service.connection.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService{
    private Connection connection = ConnectionJDBC.getConnection();

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from category";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("name"));
                list.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public List<Category> findByName(String name) {
        return null;
    }

    @Override
    public List<Category> findListById(int id) {
        List<Category> list = new ArrayList<>();
        String sql = "select c.category_id,c.name from category c join book_category bc on c.category_id = bc.category_id where book_id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("name"));
                list.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Category category) {
        String sql = "insert into book(name) values (?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,category.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void edit(int id, Category category) {
        String sql = "update category set name = ? where category_id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,category.getName());
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sqlBookCategory = "delete from book_category where book_id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =connection.prepareStatement(sqlBookCategory);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql = "delete from category where category_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
