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

import com.example.demo.models.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;


@Service
public class ProfileServiceImpl implements ProfileService {
        @Autowired
        private DataSource dataSource;
        private JdbcTemplate jdbcTemplate;

        public void setDataSource(DataSource dataSource) {
                this.dataSource = dataSource;
                this.jdbcTemplate = new JdbcTemplate(dataSource);
        }
        
        public void addAProfile(String name, Long points, Long User_id){
                
                JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                jdbcTemplate.update("INSERT INTO profile(name,points,User_id)VALUES(?,?,?)",name,points,User_id);
                
        }
        
        public void deleteAProfile(String name, Long id){
                JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                jdbcTemplate.update("DELETE FROM profile WHERE name='"+name+"' AND id="+id);
        }
        public void updateProfilePoint(String name, Long id,Long points){
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update("UPDATE profile SET points="+points+" WHERE name='"+name+"' AND id="+id);
    }
        public List <String> ListProfile(){
            String sql = "SELECT * FROM profile";
            List ProfileList = new ArrayList();
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.query(sql, new ResultSetExtractor() {
                 public List extractData(ResultSet rs) throws SQLException {

                            while (rs.next()) {
                                    String name = rs.getString("name");
                                    ProfileList.add(name);
                            }
                            return ProfileList;
                    }
            }
            );
            return ProfileList;
        }

}