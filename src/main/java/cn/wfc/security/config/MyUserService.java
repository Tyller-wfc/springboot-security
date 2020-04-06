package cn.wfc.security.config;

import cn.wfc.security.bean.Role;
import cn.wfc.security.bean.User;
import cn.wfc.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserService<T extends User> implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        try {
            User user = userMapper.findUserByName(name);
            if (user == null) {
                  throw new UsernameNotFoundException("用户名不存在");
            }
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            List<Role> roles = userMapper.findRoleByName(name);
            if (roles.size() > 0) {
                for(Role role: roles) {
                    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                    authorities.add(authority);
                }
                return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }
}
