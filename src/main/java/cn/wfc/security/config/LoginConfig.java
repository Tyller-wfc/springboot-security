package cn.wfc.security.config;

import cn.wfc.security.bean.User;
import cn.wfc.security.util.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class LoginConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserService<User> myUserService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*PasswordEncoder encoder = new BCryptPasswordEncoder();
        //super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(encoder)
                .withUser("wfc").password("$2a$10$fYv37u7WkOkZk4AlJmBoB.O1fPrYjPSekJIGDfmxo9ngvarMdZNEa").roles("VIP1")
                .and()
                .withUser("lf").password(encoder.encode("123")).roles("VIP2");*/
        auth.userDetailsService(myUserService).passwordEncoder(new MyPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests().antMatchers("/").hasRole("USER")
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        http.formLogin().usernameParameter("name").passwordParameter("pwd").loginPage("/userLogin");

        http.logout();

        http.rememberMe();
    }
}
