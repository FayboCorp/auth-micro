package uship.auth.authmicro.config.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import javax.sql.DataSource

@Configuration
class SecurityConfig {

    @Bean
    fun defaultSecurityFilterChain(http: HttpSecurity) : SecurityFilterChain {
        http.authorizeHttpRequests{ auth -> auth
            .requestMatchers("/auth/validate").authenticated()
        }
            .csrf{ csrf -> csrf.disable() }
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults())
        return http.build()
    }

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder, userDetails: UShipUserDetails) {
        auth
            .userDetailsService(userDetails)
            .passwordEncoder(passwordEncoder())
    }

    @Bean
    fun userDetailsService(dataSource: DataSource) : UserDetailsService{
        return JdbcUserDetailsManager(dataSource)
    }

    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }

}