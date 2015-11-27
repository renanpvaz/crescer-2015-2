package br.com.cwi.crescer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class LavanderiaApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(LavanderiaApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    /*
     * @Bean
     * public EmbeddedServletContainerCustomizer containerCustomizer() {
     * return new EmbeddedServletContainerCustomizer() {
     * @Override
     * public void customize(ConfigurableEmbeddedServletContainer container) {
     * // ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
     * ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
     * ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/404.html");
     * ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
     * container.addErrorPages(error400Page, error404Page, error500Page);
     * }
     * };
     * }
     */
}
