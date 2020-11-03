package jbr.springmvc.model;

public class Product {


    private int product_id;
    private String product_name;
    private String details;
    private String document;
    private String contact;

    public Product(){}

    public Product(int product_id, String product_name, String details, String document, String contact) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.details = details;
        this.document = document;
        this.contact = contact;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }



    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
