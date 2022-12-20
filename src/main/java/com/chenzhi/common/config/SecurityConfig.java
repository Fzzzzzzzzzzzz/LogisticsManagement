package com.chenzhi.common.config;

import com.chenzhi.security.filter.JwtAuthenticationTokenFilter;
import com.chenzhi.service.impl.MyUserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;
import java.util.Arrays;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //认证过滤器
    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    private MyUserDetailServiceImpl myUserDetailService;

//    //密码加盐机密
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }


    //自定义的AuthenticationManager(自定义以后覆盖默认的AuthenticationManager-providerManager) 推荐   并没有在工厂中暴露出来
    //其实自定义的的AuthenticationManager也是一个providerManager（？）然后通过userDetailsService指定自定义的数据源
//    AuthenticationManagerBuilder用来构建一个providerManager（其位置在本地）
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("自定义的AuthenticationManager"+auth);
        auth.userDetailsService(myUserDetailService);
    }
    //作用：自定义出来的用来在自定义AuthenticationManager在工厂中进行暴露出来 可以在任意位置注入
    //    在本地new出来的一个providerManager对象，在其他的组件中就无法注入了，所以曝露出来
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//

        http.authorizeRequests().mvcMatchers("/user/login").permitAll()
                            .anyRequest().authenticated().and()
                             // CSRF禁用，因为不使用session
                              .csrf().disable()
                .cors()
                //跨域处理方案
                .configurationSource(configurationSource())
                .and()
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //在UsernamePasswordAuthenticationFilter过滤器之前添加jwtAuthenticationTokenFilterr认证过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }

    CorsConfigurationSource configurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
}
