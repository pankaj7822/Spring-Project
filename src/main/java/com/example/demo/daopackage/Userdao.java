package com.example.demo.daopackage;

import javax.sql.DataSource;

import com.example.demo.form.UserForm;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
@Transactional
public class Userdao extends JdbcDaoSupport {

    @Autowired
    private PasswordEncoder passwordEncoder;
 
 
    @Autowired
    public Userdao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    public User findUserAccount(String userName) {
        // Select .. from App_User u Where u.user_name = ?
        String sql = UserMapper.BASE_SQL + " where u.user_name = ? ";
 
        Object[] params = new Object[] { userName };
        UserMapper mapper = new UserMapper();
        try {
            User userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void createUserAccount(UserForm userForm) {
        String CREATE_SQL = "INSERT INTO user(user_name, email, password) VALUES(?, ?, ?)";
        String CREATE_SQL2 ="INSERT INTO profile(points,name,User_id) values(0,'unkonown',(SELECT id  from user where id >= all(select id from user)))";
        String encrytedPassword = this.passwordEncoder.encode(userForm.getPassword());
        this.getJdbcTemplate().update(CREATE_SQL, new Object[] {userForm.getUserName(), userForm.getEmail(), encrytedPassword});
        this.getJdbcTemplate().update(CREATE_SQL2);
    }
 
}