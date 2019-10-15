package com.example.demo.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.demo.models.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {
        @Autowired
        private DataSource dataSource;
        private JdbcTemplate jdbcTemplate;

        public void setDataSource(DataSource dataSource) {
                this.dataSource = dataSource;
                this.jdbcTemplate = new JdbcTemplate(dataSource);
        }
        
        public void addABook(String name, String author, String level, long selling_price, long marked_price, long discounted_price, long stock, String edition, String genre){
                
                JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                jdbcTemplate.update("INSERT INTO book(name,author,level,selling_price,marked_price,discounted_price,stock,edition,genre)VALUES(?,?,?,?,?,?,?,?,?)",name,author,level,selling_price,marked_price,discounted_price,stock,edition,genre );
                
        }
        
        public void deleteABook(String name, Long id){
                JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                jdbcTemplate.update("DELETE FROM book WHERE name='"+name+"' AND id="+id);
        }
        public void updateBookStock(String name, Long id,Long Stock){
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update("UPDATE book SET stock="+Stock+" WHERE name='"+name+"' AND id="+id);
    }
        public List <Book> ListBook(){
            String sql = "SELECT * FROM book";
            List<Book> BookList = new ArrayList<Book>();
            jdbcTemplate.query(sql, new ResultSetExtractor() {
                @Override
                 public List<Book> extractData(ResultSet rs) throws SQLException {
                        while (rs.next()) {
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
                                BookList.add(new Book(id, name, author, level, sellingPrice, markedPrice, discountedPrice, stock, edition, genre));
                        }
                        return BookList;
                }
            });
            return BookList;
        }

}