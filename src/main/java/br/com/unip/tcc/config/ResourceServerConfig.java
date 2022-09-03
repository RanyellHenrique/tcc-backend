package br.com.unip.tcc.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableResourceServer
@RequiredArgsConstructor
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final Environment env;
    private final JwtTokenStore tokenStore;

    private static final String[] PUBLIC = {"/oauth/token", "/h2-console/**", "/trabalhadores", "/clientes"};
    private static final String[] ADMIN = {"/categorias/**", "/usuarios/**",};
    private static final String[] CLIENTE = {"/ofertas/**", "/propostas/clientes/**"};
    private static final String[] TRABALHADOR = {"/propostas/**"};
    private static final String[] PUBLIC_ONLY_READING = {"/categorias/**", "/ofertas/**", "/trabalhadores/**"};

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        http.authorizeRequests()
                .antMatchers(PUBLIC).permitAll()
                .antMatchers(GET, PUBLIC_ONLY_READING).permitAll()
                .antMatchers(CLIENTE).hasAnyAuthority("CLIENTE")
                .antMatchers(POST, TRABALHADOR).hasAnyAuthority("TRABALHADOR")
                .antMatchers(ADMIN).hasAnyAuthority("ADMIN")
                .anyRequest().authenticated();

        http.cors().configurationSource(corsConfigurationSource());

    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOriginPatterns(Arrays.asList("*"));
        corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "PATCH"));
        corsConfig.setAllowCredentials(true);
        corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean
                = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

}
