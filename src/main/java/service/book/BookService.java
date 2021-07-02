package service.book;

import model.Book;
import service.category.CategoryService;
import service.category.ICategoryService;
import service.connection.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    private Connection connection = ConnectionJDBC.getConnection();
    private ICategoryService categoryService = new CategoryService();

    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        String sql = "select * from book";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("book_id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setDescc(resultSet.getString("descc"));
                book.setPrice(resultSet.getInt("price"));
                book.setImg(resultSet.getString("img"));
                list.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Book findById(int id) {
        String sql = "select b.book_id,b.name,b.author,b.descc,b.price,img,c.name from book b " +
                "join book_category bc on b.book_id = bc.book_id " +
                "join category c on bc.category_id = c.category_id where b.book_id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("book_id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setDescc(resultSet.getString("descc"));
                book.setPrice(resultSet.getInt("price"));
                book.setImg(resultSet.getString("img"));
                book.setListCategory(categoryService.findListById(id));
                return book;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Book> findByName(String name) {
        List<Book> list = new ArrayList<>();
        String sql = "select b.book_id,b.name,b.author,b.descc,b.price,img from book b  " +
                " where b.name like ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("book_id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setDescc(resultSet.getString("descc"));
                book.setPrice(resultSet.getInt("price"));
                book.setImg(resultSet.getString("img"));
//                book.setListCategory(resultSet.getArray(categoryname));
                list.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Book> findListById(int id) {
        List<Book> list = new ArrayList<>();
        String sql = "select b.book_id,b.name,b.author,b.descc,b.price,img,c.name from book b " +
                "join book_category bc on b.book_id = bc.book_id " +
                "join category c on bc.category_id = c.category_id where b.book_id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("book_id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setPrice(resultSet.getInt("price"));
                book.setImg(resultSet.getString("img"));
                list.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Book book) {
        String sql = "insert into book(name,author,descc,price,img) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getDescc());
            preparedStatement.setInt(4, book.getPrice());
            preparedStatement.setString(5, book.getImg());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(int id, Book book) {
        String sql = "update book set name = ?,author = ?,descc= ?,price = ?,img = ? where book_id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getDescc());
            preparedStatement.setInt(4, book.getPrice());
            preparedStatement.setString(5, book.getImg());
            preparedStatement.setInt(6, id);
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
            preparedStatement = connection.prepareStatement(sqlBookCategory);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql = "delete from book where book_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
