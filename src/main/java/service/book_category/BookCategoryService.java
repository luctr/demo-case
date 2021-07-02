package service.book_category;

import dto.BookCategory;
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

public class BookCategoryService implements IBookCategory<BookCategory> {
    private static Connection connection = ConnectionJDBC.getConnection();
    private static ICategoryService categoryService = new CategoryService();

    @Override
    public List<BookCategory> findAll() {
        List<BookCategory> list = new ArrayList<>();
        String sql = "select b.book_id,b.name AS book_name,c.category_id,c.name AS category_name from book b " +
                "join book_category bc on b.book_id = bc.book_id " +
                "join category c on bc.category_id = c.category_id";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookCategory bookCategory = new BookCategory();
                bookCategory.setBook_id(resultSet.getInt("book_id"));
                bookCategory.setBookName(resultSet.getString("book_name"));
                bookCategory.setCategory_id(resultSet.getInt("category_id"));
                bookCategory.setCategoryName(resultSet.getString("category_name"));
                list.add(bookCategory);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public BookCategory findById(int book_id, int category_id) {
        String sql = "select b.book_id,b.name AS book_name,c.category_id,c.name AS category_name from book b " +
                "join book_category bc on b.book_id = bc.book_id " +
                "join category c on bc.category_id = c.category_id where book_id = ? and category_id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book_id);
            preparedStatement.setInt(2, category_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookCategory bookCategory = new BookCategory();
                bookCategory.setBook_id(resultSet.getInt("book_id"));
                bookCategory.setBookName(resultSet.getString("book_name"));
                bookCategory.setCategory_id(resultSet.getInt("category_id"));
                bookCategory.setCategoryName(resultSet.getString("category_name"));
                return bookCategory;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }




    @Override
    public BookCategory findByName(String name) {
        String sql = "select b.book_id,b.name AS book_name,c.category_id,c.name AS category_name from book b " +
                "join book_category bc on b.book_id = bc.book_id " +
                "join category c on bc.category_id = c.category_id where book_id like ? ";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookCategory bookCategory = new BookCategory();
                bookCategory.setBook_id(resultSet.getInt("book_id"));
                bookCategory.setBookName(resultSet.getString("book_name"));
                bookCategory.setCategory_id(resultSet.getInt("category_id"));
                bookCategory.setCategoryName(resultSet.getString("category_name"));
                return bookCategory;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Book> findListById(int id) {
        List<Book> list = new ArrayList<>();
        String sql = "select b.book_id,b.name AS book_name,b.author,b.descc,b.price,b.img,c.name AS category_name from book b " +
                "join book_category bc on b.book_id = bc.book_id " +
                "join category c on bc.category_id = c.category_id where c.category_id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("book_id"));
                book.setName(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("author"));
                book.setDescc(resultSet.getString("descc"));
                book.setPrice(resultSet.getInt("price"));
                book.setImg(resultSet.getString("img"));
                book.setListCategory(categoryService.findListById(id));
                list.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(int book, int category) {
        String sql = "insert into book_category(book_id,category_id) values (?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,book);
            preparedStatement.setInt(2,category);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(int book_id, int category_id,BookCategory bookCategory) {
        String sql = "update book_category set book_id = ?,category_id = ? where book_id = ? and category_id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,bookCategory.getBook_id());
            preparedStatement.setInt(2,bookCategory.getCategory_id());
            preparedStatement.setInt(3,book_id);
            preparedStatement.setInt(4,category_id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id, int category_id) {
        Connection connection = ConnectionJDBC.getConnection();
        String sql  = "delete from book_category where book_id = ? and category_id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,category_id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
