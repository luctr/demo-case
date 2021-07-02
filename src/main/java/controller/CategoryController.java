package controller;

import model.Book;
import model.Category;
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

@WebServlet(name = "CategoryController", value = "/categoryController")

public class CategoryController extends HttpServlet {
    private static ICategoryService categoryService = new CategoryService();
    private static IBookCategory bookCategoryService = new BookCategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "updateCategory":
                showFormUpdateCategory(req, resp);
                break;
            case "createCategory":
                showFormCreateCategory(req, resp);
                break;
            case "showByIdCategory":
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/manager/category.jsp");
                int id = Integer.parseInt(req.getParameter("id"));
                List<BookController> list = bookCategoryService.findListById(id);
                req.setAttribute("list", list);
                requestDispatcher.forward(req, resp);
                break;
            default:
                showAll(req, resp);
                break;
        }

    }

    private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/manager/index.jsp");
        List<Category> listCategory = categoryService.findAll();
        req.setAttribute("listCategory", listCategory);
        dispatcher.forward(req, resp);
    }

    private void showFormUpdateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findById(id);
        request.setAttribute("updateCategory", category);
        dispatcher.forward(request, response);
    }

    private void showFormCreateCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("");
        List<Category> list = categoryService.findAll();
        req.setAttribute("dsnv", list);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createCategory":
                createCategory(req, resp);
                break;
            case "updateCategory":
                updateCategory(req);
                break;
            case "deleteCategory":
                deleteCategory(req, resp);
                break;
            default:
                showAll(req, resp);
                break;
        }


    }

    private void createCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        Category category = new Category(name);
        categoryService.save(category);
        resp.sendRedirect(req.getContextPath() + "");
    }

    private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        categoryService.delete(id);
        req.setAttribute("message", "Xóa Thành Công");
        showAll(req, resp);
    }

    private void updateCategory(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        categoryService.edit(id, category);
    }
}
