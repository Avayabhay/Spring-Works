package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // Add Support for JDBC.....and no more hard code users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve user by username
        //basically this is the place where we say spring securty this is how you find user from username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );

        //define query to retrieve authorites/roles from roles
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/employees/**").hasRole("ADMIN")
                );
        //since we are using our own request matcher, we need to tell spring that authentication method
        //use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable CSRF(Cross Site Request Forgery), because it is not needed for stateless REST API calls
        http.csrf(csrf -> csrf.disable());

        return http.build();

    }

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}johnpass")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}marypass")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}susanpass")
                .roles("ADMIN", "EMPLOYEE","MANAGER")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
     */

}
