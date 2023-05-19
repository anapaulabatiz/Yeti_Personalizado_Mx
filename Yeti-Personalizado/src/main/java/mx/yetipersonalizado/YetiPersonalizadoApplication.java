package mx.yetipersonalizado;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import mx.yetipersonalizado.config.JwtFilter;

@SpringBootApplication
public class YetiPersonalizadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(YetiPersonalizadoApplication.class, args);
	} // main
	
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter() {
		FilterRegistrationBean<JwtFilter> registrationBean =
				new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/producto/*");
		registrationBean.addUrlPatterns("/usuario/*");
		return registrationBean;
	}

} // class YetiPersonalizadoApplication