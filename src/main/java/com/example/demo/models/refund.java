package com.example.demo.models;

import java.sql.Date;

/**
 * refund
 */
public class refund {
    private long id;
    private Date request_date;
    private long amount;
    private boolean Approved;
    private long Expense_id;
    private long Order_id;

    public refund(long id, Date request_date, long amount, boolean approved, long expense_id, long order_id) {
        this.id = id;
        this.request_date = request_date;
        this.amount = amount;
        Approved = approved;
        Expense_id = expense_id;
        Order_id = order_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getRequest_date() {
        return request_date;
    }

    public void setRequest_date(Date request_date) {
        this.request_date = request_date;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public boolean isApproved() {
        return Approved;
    }

    public void setApproved(boolean approved) {
        Approved = approved;
    }

    public long getExpense_id() {
        return Expense_id;
    }

    public void setExpense_id(long expense_id) {
        Expense_id = expense_id;
    }

    public long getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(long order_id) {
        Order_id = order_id;
    }

}