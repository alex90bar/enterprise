package ru.skillbox.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	GlobalFilter customGF(){
		return new CustomGlobalFilter();
	}

	@Bean
	RouteLocator customRoutes(RouteLocatorBuilder builder){
		return builder
				.routes()
				.route("test2",
						r -> r.path("/**")
								.uri("http://localhost/api"))
				.build();
	}

}
