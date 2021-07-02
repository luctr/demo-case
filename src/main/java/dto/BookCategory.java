package dto;

public class BookCategory {
    private int book_id;
    private String bookName;
    private int category_id;
    private String categoryName;

    public BookCategory(int book_id, String bookName, int category_id, String categoryName) {
        this.book_id = book_id;
        this.bookName = bookName;
        this.category_id = category_id;
        this.categoryName = categoryName;
    }

    public BookCategory(int book_id, int category_id) {
        this.book_id = book_id;
        this.category_id = category_id;
    }

    public BookCategory(String bookName, String categoryName) {
        this.bookName = bookName;
        this.categoryName = categoryName;
    }

    public BookCategory() {
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
