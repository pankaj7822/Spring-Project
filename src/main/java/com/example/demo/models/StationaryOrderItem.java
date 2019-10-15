package com.example.demo.models;

class StationaryOrderItem {

    private long id;
    private long quantity;
    private long Order_id;

    public StationaryOrderItem(long id, long quantity, long order_id) {
        this.id = id;
        this.quantity = quantity;
        Order_id = order_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(long order_id) {
        Order_id = order_id;
    }
    
}