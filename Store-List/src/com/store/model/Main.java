package com.store.model;

public class Main {
    protected int id;
    protected String categoryID;
    protected String menuName;
    protected String price;
    protected String image;
    protected String discount;
    protected String description;
    private String startDate; 
    private String endDate;
    
    

    public Main() {
    }

    public Main(String categoryID, String menuName, String price, String image, String discount, String description, String startDate, String endDate) {
        super();
        this.categoryID = categoryID;
        this.menuName = menuName;
        this.price = price;
        this.image = image; 
        this.discount = discount;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        
    }

    public Main(int id, String categoryID, String menuName, String price, String image, String discount, String description, String startDate, String endDate) {
        super();
        this.id = id;
        this.categoryID = categoryID;
        this.menuName = menuName;
        this.price = price;
        this.image = image; 
        this.discount = discount;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    public String getendDate() {
        return endDate;
    }

    public void setendDate(String endDate) {
        this.endDate = endDate;
    }
}
