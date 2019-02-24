package template;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	/**
	 * 配置多视图解析器 参考
	 * https://github.com/Samciu/lit/blob/master/lit-support/src/main/java/com/github/lit/support/web/WebMcvConfig.java
	 * 
	 * @param manager       manager 会自动构建，configureContentNegotiation可以进行配置
	 * @param viewResolvers 当前项目的 viewResolver, (此时会包含上面配置的 freemarkerViewResolver)
	 * @return ContentNegotiatingViewResolver
	 * @see WebMvcConfigurerAdapter#configureContentNegotiation(org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer)
	 */
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager,
			List<ViewResolver> viewResolvers) {

		ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
		viewResolver.setContentNegotiationManager(manager);

		// 设置默认view, default view 每次都会添加到 真正可用的视图列表中, json视图没有对应的ViewResolver
		View jackson2JsonView = new MappingJackson2JsonView();
		viewResolver.setDefaultViews(Collections.singletonList(jackson2JsonView));

		viewResolver.setViewResolvers(viewResolvers);
		return viewResolver;
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true).favorParameter(true).parameterName("format").ignoreAcceptHeader(false)

				/* 请求以.html结尾的会被当成MediaType.TEXT_HTML */
				.mediaType("html", MediaType.TEXT_HTML)
				/* 请求以.json结尾的会被当成MediaType.APPLICATION_JSON */
				.mediaType("json", MediaType.APPLICATION_JSON).defaultContentType(MediaType.APPLICATION_JSON);
	}

}