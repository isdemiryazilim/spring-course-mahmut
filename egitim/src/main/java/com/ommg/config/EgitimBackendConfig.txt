package com.ommg.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import com.ommg.sevkiyat.converter.BooleanToEvetHayirConverter;
//import com.ommg.sevkiyat.entity.view.VeKullanici;
//import com.ommg.sevkiyat.interceptor.RestTemplateRequestResponseLogInterceptor;
//import com.ommg.sevkiyat.interceptor.RestTemplateTokenInterceptor;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableJpaAuditing
@Slf4j
//@EnableSwagger2
public class EgitimBackendConfig implements WebMvcConfigurer {

	@Autowired
	RestTemplate restTemplate;

//	@Bean
//	AuditorAware<VeKullanici> auditorProvider() {
//		return new AuditAwareImpl();
//	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		//registry.addConverter(new BooleanToEvetHayirConverter());
	}

	/**
	 * Tüm sınıfların rest servilerini taraması için: <br>
	 * return new Docket(DocumentationType.SWAGGER_2) .select()
	 * .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any()) .build();
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(p -> p.findControllerAnnotation(com.ommg.config.EnableAPI.class).isPresent()
						|| p.isAnnotatedWith(EnableAPI.class))
				.paths(PathSelectors.any()).build();
	}

	@Bean
	public void interceptor() {
		List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
		if (CollectionUtils.isEmpty(interceptors)) {
			interceptors = new ArrayList<>();
		}
//		interceptors.add(new RestTemplateRequestResponseLogInterceptor());
//		interceptors.add(new RestTemplateTokenInterceptor());
		restTemplate.setInterceptors(interceptors);
		restTemplate.setRequestFactory(new InterceptingClientHttpRequestFactory(
				new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()), interceptors));
	}
}
