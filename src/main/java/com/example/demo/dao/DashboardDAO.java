package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.example.demo.models.Address;
import com.example.demo.models.Phone_Number;
import com.example.demo.models.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DashboardDAO extends JdbcDaoSupport {

        @Autowired
        public DashboardDAO(DataSource dataSource) {
            this.setDataSource(dataSource);
        }
        

        public Profile getProfileByUserName(String username){
            String sql = "Select p.id,p.points,p.name,p.User_id from user u, profile p where u.user_name='"+username+"' and u.id = p.User_id";
            return this.getJdbcTemplate().queryForObject(sql, new ProfileMapper());
           
        };

        
        public void updateProfile(String name, Long id){
            String sql = "update profile set name = '" + name + "' WHERE id = " + id;
            this.getJdbcTemplate().update(sql);
        };

        public void addAddress(String state,String district,String city,String pincode,String landmark, Long profileid){
            String sql = String.format(
                "Insert into address(state,district,city,pincode,landmark,Profile_id) values('%s', '%s', '%s', '%s', '%s', %d)",
                 state,district,city,pincode,landmark,profileid);
            this.getJdbcTemplate().update(sql);
        };

        public void updateAddress(String state,String district,String city,String pincode,String landmark, Long id){
            String sql = String.format(
                "Update address set state='%s', district='%s', city='%s', pincode='%s', landmark='%s' Where id=%d",
                 state,district,city,pincode,landmark,id);
            this.getJdbcTemplate().update(sql);
        };

        public void addPhoneNumber(String phone_number, Long profileid){
            String sql = "Insert into phone_number(phone_number, Profile_id) values("+phone_number+", "+profileid+")";
            this.getJdbcTemplate().update(sql);
        };

        public void updatePhoneNumber(String phone_number,Long id){
            String sql = "Update phone_number set phone_number="+phone_number+" WHERE id="+id;
            this.getJdbcTemplate().update(sql);
        }

        public List<Address>  ListAddress(Long profileid){
            String sql = "SELECT * from address WHERE Profile_id="+profileid;
            return this.getJdbcTemplate().query(sql, new RowMapper<Address>(){  
                @Override  
                public Address mapRow(ResultSet rs, int rownumber) throws SQLException {  
                    return new Address(
                        rs.getLong("id"),
                        rs.getString("state"),
                        rs.getString("district"),
                        rs.getString("city"),
                        rs.getString("pincode"),
                        rs.getString("landmark"),
                        rs.getLong("Profile_id")
                    );  
                }  
            });  
        };

        public List<Phone_Number>  ListPhoneNumber(Long profileid){
            String sql = "SELECT * from phone_number WHERE Profile_id="+profileid;
            return this.getJdbcTemplate().query(sql, new RowMapper<Phone_Number>(){  
                @Override  
                public Phone_Number mapRow(ResultSet rs, int rownumber) throws SQLException {  
                    Phone_Number e=new Phone_Number();  
                    e.setId(rs.getLong(1));  
                    e.setPhone_number(rs.getString(2));
                    e.setProfile_id(rs.getLong(3));      
                    return e;  
                }  
            });
        };

        public class ProfileMapper implements RowMapper<Profile> {
            public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
               Profile profile = new Profile();
               profile.setId(rs.getLong("id"));
               profile.setPoints(rs.getLong("points"));
               profile.setName(rs.getString("name"));
               profile.setUser_id(rs.getLong("User_id"));
               return profile;
            }
         }

}