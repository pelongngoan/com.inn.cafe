package com.inn.cafe.JWT;

import com.inn.cafe.POJO.User;
import com.inn.cafe.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
@Slf4j
@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    private com.inn.cafe.POJO.User userDetail;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserName {}",username);
        userDetail = userDao.findByEmailId(username);
        if (!Objects.isNull(userDetail))
            return new org.springframework.security.core.userdetails.User(userDetail.getEmail(),userDetail.getPassword(),new ArrayList<>());
        else
            throw new UsernameNotFoundException("User not found.");
    }

    public com.inn.cafe.POJO.User getUserDetail(){
        /*User user = userDetail;
        user.setPassword(null);*/
        return userDetail;
    }
}
