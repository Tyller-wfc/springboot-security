package cn.wfc.security;

import cn.wfc.security.bean.Role;
import cn.wfc.security.bean.User;
import cn.wfc.security.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class SecurityApplicationTests {
	@Autowired
	UserMapper userMapper;

	@Test
	void contextLoads() {
		List<User> users = userMapper.getUsers();
		System.out.println(users.size());
	}

}
