package com.example.demo.models;

import java.sql.Date;

public class RetailerStationaryPurchase {

    private long id;
    private long unit_price;
    private long quantity;
    private Date date_of_purchase;
    private String vendor_name;
    private long Expense_id;
    private long Stationary_id;

    public RetailerStationaryPurchase(long id, long unit_price, long quantity, Date date_of_purchase,
            String vendor_name, long expense_id, long stationary_id) {
        this.id = id;
        this.unit_price = unit_price;
        this.quantity = quantity;
        this.date_of_purchase = date_of_purchase;
        this.vendor_name = vendor_name;
        Expense_id = expense_id;
        Stationary_id = stationary_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(long unit_price) {
        this.unit_price = unit_price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Date getDate_of_purchase() {
        return date_of_purchase;
    }

    public void setDate_of_purchase(Date date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public long getExpense_id() {
        return Expense_id;
    }

    public void setExpense_id(long expense_id) {
        Expense_id = expense_id;
    }

    public long getStationary_id() {
        return Stationary_id;
    }

    public void setStationary_id(long stationary_id) {
        Stationary_id = stationary_id;
    }

}