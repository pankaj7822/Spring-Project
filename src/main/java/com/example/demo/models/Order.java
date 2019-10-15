package com.example.demo.models;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Date order_date;
    String delivery_status;
    String payment_status;
    Long Delivery_Address_id;
    Long PhoneNumber_id;
    Long Profile_id;

    public Order() {

    }

    public Order(Long id, Date order_date, String delivery_status, String payment_status,
            Long delivery_Address_id, Long phoneNumber_id, Long profile_id) {
        this.id = id;
        this.order_date = order_date;
        this.delivery_status = delivery_status;
        this.payment_status = payment_status;
        Delivery_Address_id = delivery_Address_id;
        PhoneNumber_id = phoneNumber_id;
        Profile_id = profile_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(String delivery_status) {
        this.delivery_status = delivery_status;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public Long getDelivery_Address_id() {
        return Delivery_Address_id;
    }

    public void setDelivery_Address_id(Long delivery_Address_id) {
        Delivery_Address_id = delivery_Address_id;
    }

    public Long getPhoneNumber_id() {
        return PhoneNumber_id;
    }

    public void setPhoneNumber_id(Long phoneNumber_id) {
        PhoneNumber_id = phoneNumber_id;
    }

    public Long getProfile_id() {
        return Profile_id;
    }

    public void setProfile_id(Long profile_id) {
        Profile_id = profile_id;
    }
}