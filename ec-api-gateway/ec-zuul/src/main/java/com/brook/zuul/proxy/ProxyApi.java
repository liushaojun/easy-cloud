package com.brook.zuul.proxy;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.spring4all.swagger.Swagger2Configuration;
import com.spring4all.swagger.SwaggerProperties;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * @author brook
 */
@Configuration
@EnableSwagger2Doc
@ConditionalOnClass(Swagger2Configuration.class)
public class ProxyApi {

	private final ZuulProperties properties;

	@Autowired
	SwaggerProperties swaggerProperties;
	@Autowired
	public ProxyApi(ZuulProperties properties) {
		this.properties = properties;
	}

	@Primary
	@Bean
	public SwaggerResourcesProvider swaggerResourcesProvider() {
		return () -> {
			List<SwaggerResource> resources = new ArrayList<>();
			properties.getRoutes().values()
					.forEach(route -> resources.add(createResource(route.getServiceId(), route.getId(), "2.0")));
			return resources;
		};
	}

	private SwaggerResource createResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation("/" + location + "/v2/api-docs");
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}