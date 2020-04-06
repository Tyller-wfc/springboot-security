package cn.wfc.security.mapper;

import cn.wfc.security.bean.Role;
import cn.wfc.security.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findUserByName(String name);

    List<Role> findRoleByName(String name);

    List<User> getUsers();
}
