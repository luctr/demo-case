package controller;
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

@WebServlet(name = "searchController",value = "/search")
public class SearchController extends HttpServlet {
    private static IBookService bookService = new BookService();
    private static IBookCategory bookCategoryService = new BookCategoryService();
    private static ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "book":
                book(req, resp);
                break;
                case "category":
                    book(req, resp);
                    break;
        }
    }

    private void book(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/manager/search.jsp");
        String name = req.getParameter("name");
        List<Category> categories = categoryService.findByName(name);
        req.setAttribute("category", categories);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
