package com.example.demo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.example.demo.models.Stationary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;


@Service
public class StationaryServiceImpl implements StationaryService {
        @Autowired
        private DataSource dataSource;
        private JdbcTemplate jdbcTemplate;

        public void setDataSource(DataSource dataSource) {
                this.dataSource = dataSource;
                this.jdbcTemplate = new JdbcTemplate(dataSource);
        }
        
        public void addAStationary(String item_type, long stock, String brand,long selling_price, long marked_price, long discounted_price){
                
                JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                jdbcTemplate.update("INSERT INTO stationary(item_type,stock,brand,selling_price,marked_price,discounted_price)VALUES(?,?,?,?,?,?)",item_type,stock,brand,selling_price,marked_price,discounted_price );
                
        }
        
        public void deleteAStationary(String item_type, Long id){
                JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                jdbcTemplate.update("DELETE FROM stationary WHERE item_type='"+item_type+"' AND id="+id);
        }
        public void updateStationaryStock(String item_type, Long id,Long Stock){
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update("UPDATE stationary SET stock="+Stock+" WHERE item_type='"+item_type+"' AND id="+id);
    }
        public List ListStationary(){
                String sql = "SELECT  id,brand,stock,item_type,selling_price,marked_price,discounted_price  FROM stationary";
            List StationaryList = new ArrayList();
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.query(sql, new ResultSetExtractor() {
                 public List extractData(ResultSet rs) throws SQLException {
                            while (rs.next()) {
                                    String brand = rs.getString("brand");
                                    StationaryList.add(brand);
                            }
                            return StationaryList;
                    }
            }
            );
            return StationaryList;
        }

}