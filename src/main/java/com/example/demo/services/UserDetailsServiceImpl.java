package com.example.demo.services;
 
import java.util.ArrayList;
import java.util.List;

import com.example.demo.daopackage.Roledao;
import com.example.demo.daopackage.Userdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private Userdao Userdao;
 
    @Autowired
    private Roledao Roledao;
 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.example.demo.models.User User = this.Userdao.findUserAccount(userName);
 
        if (User == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
 
     
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if(userName.equals("admin")){
            GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
            System.out.println("User found! " + userName);
            grantList.add(authority);
        }
        
        UserDetails userDetails = (UserDetails) new User(User.getUserName(), //
                User.getencryptedPassword(), grantList);
 
        return userDetails;
    }
 
}