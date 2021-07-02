package model;

import java.util.List;

public class Category {
    private int id  ;
    private String name;
    private List<Book> listBook;

    public Category(int id, String name, List<Book> listBook) {
        this.id = id;
        this.name = name;
        this.listBook = listBook;
    }

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getListBook() {
        return listBook;
    }

    public void setListBook(List<Book> listBook) {
        this.listBook = listBook;
    }
}
