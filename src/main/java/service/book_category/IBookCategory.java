package service.book_category;

import dto.BookCategory;
import model.Book;

import java.util.List;

public interface IBookCategory<T> {
    List<BookCategory> findAll();
    BookCategory findById(int book_id,int category_id);
    BookCategory findByName(String name);
    List<Book> findListById(int id);
    void save(int book, int category);
    void edit(int book_id,int category_id,BookCategory bookCategory);
    void delete(int id,int category_id);
}
