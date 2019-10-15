package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.example.demo.models.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BookDAO extends JdbcDaoSupport {

    @Autowired
    public BookDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public Book findBook(Long id) {
        String sql = "SELECT * FROM book where id="+id;
        return this.getJdbcTemplate().queryForObject(sql, new BookMapper() );
    }

    public List<Book> ListBook() {
        String sql = "SELECT * FROM book";
        return this.getJdbcTemplate().query(sql, new BookMapper() );
    }

    public class BookMapper implements RowMapper<Book>{
        @Override
        public Book mapRow(ResultSet rs, int rownumber) throws SQLException {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String author = rs.getString("author");
            String level = rs.getString("level");
            Long sellingPrice = rs.getLong("selling_price");
            Long markedPrice = rs.getLong("marked_price");
            Long discountedPrice = rs.getLong("discounted_price");
            Long stock = rs.getLong("stock");
            String edition = rs.getString("edition");
            String genre = rs.getString("genre");
            return new Book(id, name, author, level, sellingPrice, markedPrice, discountedPrice, stock, edition, genre);
        }
    }
}