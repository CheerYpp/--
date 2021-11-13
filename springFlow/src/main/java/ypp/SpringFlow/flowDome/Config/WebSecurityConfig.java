package ypp.SpringFlow.flowDome.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity  //启动web安全功能
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    /**
     * 配置 Spring Security的Filter链
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /**
     * 配置如何通过拦截器保护请求  默认拦截所有请求
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/spittr/login").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/spittles/*").authenticated()
                .anyRequest().permitAll();
    }

    /**
     * 配置user-detail服务  认证用户存储，默认无用户则所有请求都需要认证
     * @param auth  构造者风格接口
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //基于内存的用户存储
        //设置两个用户与对应密码和角色  role--authorities二者方法一致，前者是后者简写方式
        auth.inMemoryAuthentication()  //启用内存用户存储
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER","ADMIN");

/*        //基于关系型数据库用户存储
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,password,true from Spitter where username=?")  //用户名密码&&启用状态
                .authoritiesByUsernameQuery("select username,'ROLE_USER' from Spitter where username=?") //用户名&&权限信息
                .passwordEncoder(new StandardPasswordEncoder("53cr3t")); //设置内置密码加密方式，自定义加密方法可PasswordEncoder实现该接口重写加密方法

        //基于LDAP认证
        auth.ldapAuthentication()
                .userSearchBase("ou=prople")  //为查找用户提供基础查询
                .userSearchFilter("{uid={0}}")  //基础LDAP查询条件：基于用户搜索条件设置
                .groupSearchBase("ou=groups")   //为查询组指定基础查询
                .groupSearchFilter("member={0}")   //基础LDAP查询条件：基于组搜索条件设置
                .contextSource().root("dc=habuma,dc=com").ldif("classpath:users.ldif"); //设置本地Spring默认LDAP服务器，并加载指定类路径下LDIF文件

        */
    }
}
