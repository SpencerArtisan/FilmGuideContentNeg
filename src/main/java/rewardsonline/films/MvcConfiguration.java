package rewardsonline.films;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@ComponentScan(basePackages = "rewardsonline", useDefaultFilters = false, includeFilters = @Filter(Controller.class))
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	private Logger logger = Logger.getLogger(MvcConfiguration.class);

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean(name="tilesViewResolver")
	public ViewResolver getTilesViewResolver() {
		TilesViewResolver resolver = new TilesViewResolver();
		resolver.setContentType("text/html");
		return resolver;
	}

	@Bean
	public TilesConfigurer getTilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		String[] tilesDefFiles = { "/WEB-INF/tiles.xml", "/WEB-INF/films/tiles.xml" };
		configurer.setDefinitions(tilesDefFiles);
		return configurer;
	}

	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		// Simple strategy: only path extension is taken into film
		configurer.favorPathExtension(false)
                .favorParameter(true)
                .parameterName("format")
                .ignoreAcceptHeader(false)
				.useJaf(false).defaultContentType(MediaType.TEXT_HTML)
				.mediaType("html", MediaType.TEXT_HTML)
				.mediaType("json", MediaType.APPLICATION_JSON);
		logger.warn("The configurer is a " + configurer.getClass());
	}
	
	@Bean(name="contentNegotiatingViewResolver")
	public ViewResolver getContentNegotiatingViewResolver(
			ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);
		logger.warn("Created ContentNegotiatingViewResolver");
		return resolver;
	}

	@Bean(name="messageSource")
	// Mandatory name
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource msgSrc = new ReloadableResourceBundleMessageSource();
		msgSrc.setBasename("/WEB-INF/messages/global");
		return msgSrc;
	}

	/**
	 * Replaces use of {@link MvcConfiguringPostProcessor}.
	 */
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {

		// List is initially empty. Create and configure what we need.
		MappingJacksonHttpMessageConverter jmc = new MappingJacksonHttpMessageConverter();
		jmc.setPrettyPrint(true);
		logger.info("Creating Jackson V1 convertor: "
				+ jmc.getClass().getSimpleName());
		converters.add(jmc);

		return;
	}
}
