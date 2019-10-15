package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.example.demo.models.Book;
import com.example.demo.models.BookOrderItem;
import com.example.demo.models.Order;
import com.example.demo.models.Phone_Number;
import com.example.demo.models.Profile;
import com.example.demo.models.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderDAO extends JdbcDaoSupport {

    @Autowired
    public OrderDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Autowired
    private BookDAO bookDAO;

    public List<Order> listOrders() {
        String SQL = "Select * from `order`";
        return this.getJdbcTemplate().query(SQL, new OrderMapper());
    }

    public Order findOrder(Long id) {
        String SQL = "Select * from `order` Where id="+id;
        return this.getJdbcTemplate().queryForObject(SQL, new OrderMapper());
    }

    public void placeOrderForBooks(List<Long> books, String payment_mode, Long Delivery_Address_id, Long  PhoneNumber_id, Long profileid){
        String sql = "INSERT INTO `order`(order_date, delivery_status, payment_status, payment_mode, Delivery_Address_id,PhoneNumber_id, Profile_id) Values(?, ?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.getJdbcTemplate().update(connection -> {
            PreparedStatement ps = connection
            .prepareStatement(sql, new String[] {"id"});
            ps.setDate(1, new java.sql.Date((new java.util.Date()).getTime()));
            ps.setString(2, "Not Delivered");
            ps.setString(3, "PAID");
            ps.setString(4, payment_mode);
            ps.setLong(5, Delivery_Address_id);
            ps.setLong(6, PhoneNumber_id);
            ps.setLong(7, profileid);
            return ps;
        }, keyHolder); 

        Long orderId = keyHolder.getKey().longValue();

        String ITEM_SQL = "INSERT INTO book_order_item(quantity, Order_id, Book_id) Values(?, ?, ?)";
        this.getJdbcTemplate().batchUpdate(
        ITEM_SQL,
        new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1, Long.valueOf(1));
                ps.setLong(2, orderId);
                ps.setLong(3, books.get(i));
            }
            @Override
            public int getBatchSize() {
                return books.size();
            }
        });
    }

    public List<BookOrderItem> findBookOrdersByProfile(Long profileId){
        String sql = "SELECT * FROM `order` o, book_order_item oi where o.id=oi.Order_id AND o.Profile_id="+profileId;
        return this.getJdbcTemplate().query(sql,new RowMapper<BookOrderItem>(){
            @Override
            public BookOrderItem mapRow(ResultSet rs, int rownumber) throws SQLException {  
                return new BookOrderItem(
                    rs.getLong("id"),
                    rs.getLong("quantity"),
                    findOrder(rs.getLong("Order_id")),    
                    bookDAO.findBook(rs.getLong("Book_id"))
                );
            }  
        });
    }

    public void placeOrderForStataionary() {

    }

    public class OrderMapper implements RowMapper<Order> {
        public Order mapRow(ResultSet rs, int rownumber) throws SQLException {  
            return new Order(
                rs.getLong("id"),
                rs.getDate("order_date"),
                rs.getString("delivery_status"),
                rs.getString("payment_status"),
                rs.getLong("delivery_Address_id"),
                rs.getLong("phoneNumber_id"),    
                rs.getLong("profile_id")
            );
        }  
    }
        
}