package controller;

import dto.BookCategory;
import model.Book;
import model.Category;
import service.book.BookService;
import service.book.IBookService;
import service.book_category.BookCategoryService;
import service.book_category.IBookCategory;
import service.category.CategoryService;
import service.category.ICategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controller", value = "/controller")
public class BookController extends HttpServlet {
    private static IBookService bookService = new BookService();
    private static IBookCategory bookCategoryService = new BookCategoryService();
    private static ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createBook":
                showFormCreateBook(req, resp);
                break;

            case "createBookCategory":
                showFormCreateBookCategory(req, resp);
                break;
            case "updateBook":
                showFormUpdateBook(req, resp);
                break;
            case "updateBookCategory":
                showFormUpdateBookCategory(req, resp);
                break;
            case "contentBook":
                showFindById(req, resp);
                break;
            default:
                showAll(req, resp);
                break;
        }

    }

    private void showFormUpdateBookCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        BookCategory bookCategory = bookCategoryService.findById(book_id, category_id);
        request.setAttribute("updateCategory", bookCategory);
        dispatcher.forward(request, response);
    }


    private void showFormUpdateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.findById(id);
        request.setAttribute("updateCategory", book);
        dispatcher.forward(request, response);
    }


    private void showFormCreateBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("");
        List<Book> list = bookService.findAll();
        req.setAttribute("dsnv", list);
        dispatcher.forward(req, resp);
    }

    private void showFormCreateBookCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("");
        List<BookCategory> list = bookCategoryService.findAll();
        req.setAttribute("dsnv", list);
        dispatcher.forward(req, resp);
    }

    private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/manager/list.jsp");
        List<Book> list = bookService.findAll();
        List<Category> listCategory = categoryService.findAll();
        req.setAttribute("listBook", list);
        req.setAttribute("listCategory", listCategory);
        dispatcher.forward(req, resp);
    }

    private void showFindById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/manager/book.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.findById(id);
        req.setAttribute("book", book);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createBook":
                createBook(req, resp);
                break;
            case "createBookCategory":
                createBookCategory(req, resp);
                break;
            case "updateBook":
                updateBook(req);
                break;
            case "updateBookCategory":
                updateBookCategory(req);
                break;
            case "deleteBook":
                deleteBook(req, resp);
                break;
            case "deleteBookCategory":
                deleteBookCategory(req, resp);
                break;
            default:
                showAll(req, resp);
                break;
        }
    }

    private void deleteBookCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int book_id = Integer.parseInt(req.getParameter("book_id"));
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        bookCategoryService.delete(book_id, category_id);
        req.setAttribute("message", "Xóa Thành Công");
        showAll(req, resp);
    }


    private void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookService.delete(id);
        req.setAttribute("message", "Xóa Thành Công");
        showAll(req, resp);
    }

    private void updateBookCategory(HttpServletRequest req) {
        int book_id = Integer.parseInt(req.getParameter("book_id"));
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        BookCategory bookCategory = new BookCategory();
        bookCategory.setBook_id(book_id);
        bookCategory.setCategory_id(category_id);
        bookCategoryService.edit(book_id, category_id, bookCategory);
    }


    private void updateBook(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String desc = req.getParameter("descc");
        int price = Integer.parseInt(req.getParameter("price"));
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescc(desc);
        book.setPrice(price);
        bookService.edit(id, book);
    }

    private void createBookCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int book_id = Integer.parseInt(req.getParameter("book_id"));
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        bookCategoryService.save(book_id, category_id);
        resp.sendRedirect(req.getContextPath() + "");
    }


    private void createBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String descc = req.getParameter("descc");
        int price = Integer.parseInt(req.getParameter("price"));
        String img = req.getParameter("img");
        Book book = new Book(name, author, descc, price, img);
        bookService.save(book);
        resp.sendRedirect(req.getContextPath() + "");
    }
}
