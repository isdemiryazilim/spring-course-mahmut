package com.ommg;

import java.net.InetAddress;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.request.RequestContextListener;

import com.ommg.sevkiyat.fileupload.StorageProperties;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(scanBasePackages = { "tr.com.isdemir", "com.ommg" })
@EnableConfigurationProperties(StorageProperties.class)
@Slf4j
@ComponentScan({"tr.com.isdemir"})
@EntityScan("tr.com.isdemir.egitim.entity")
@EnableJpaRepositories("tr.com.isdemir.egitim.repository")
public class EgitimApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EgitimApplication.class);
	}

	public static void main(String[] args) throws Exception {
		Date startTime = new Date();
		SpringApplication.run(EgitimApplication.class, args);
		/*HTTPUtils.addInterceptorForRestTemplate(new RestTemplateTokenInterceptor(), "restTemplate");
		HTTPUtils.addInterceptorForRestTemplate(new RestTemplateRequestResponseLogInterceptor(), "restTemplate");*/
		Date finishTime = new Date();
		log.info("Proje660 Application Started... App.host:" + InetAddress.getLocalHost().getHostAddress());
		log.info("Start Time: " + startTime.toString() + " - Finish Time: " + finishTime.toString()
				+ " / Aradaki fark(sn): " + ((finishTime.getTime() - startTime.getTime()) / 1000));
	}

	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}
}
