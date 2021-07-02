package model;

import java.util.List;

public class Book {
    private int id;
    private String name;
    private String author;
    private String descc;
    private int price;
    private String img;
    private List<Category> listCategory;

    public Book(int id, String name, String author, String descc, int price, String img, List<Category> listCategory) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.descc = descc;
        this.price = price;
        this.img = img;
        this.listCategory = listCategory;
    }

    public Book(String name, String author, String descc, int price, String img) {
        this.name = name;
        this.author = author;
        this.descc = descc;
        this.price = price;
        this.img = img;
    }

    public Book() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescc() {
        return descc;
    }

    public void setDescc(String descc) {
        this.descc = descc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Category> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<Category> listCategory) {
        this.listCategory = listCategory;
    }
}
