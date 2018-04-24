package edu.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    /* The following configuration is use to authenticate the user, if user needs to be
    * authenticated via repo then use ReactiveUserDetails and remove the following
    **/
    /*@Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }*/

    /**
     * Once you implemented this you will get There is no PasswordEncoder mapped
     * to resolve it we need to specify password encoder
     * @return
     */
    /*@Bean
    MapReactiveUserDetailsService userDetailsService() {
        UserDetails noman = User.withUsername("n@abbasi.com")
                .password("x")
                .roles("USER")
                .build();

        return new MapReactiveUserDetailsService(noman);
    }*/

    /**
     * Following example is taken from @see WebFluxSecurityConfiguration in EnableWebFluxSecurity
     */
    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http.authorizeExchange().pathMatchers("/login","/signup","/webjars/**").permitAll()
            .anyExchange().authenticated()
            .and()
            .httpBasic().and()
            .formLogin().loginPage("/login");
        return http.build();
    }
}
