package pl.malopolska.irregularities.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.malopolska.irregularities.convertersFromString.ConverterBeneficiaryFromString;
import pl.malopolska.irregularities.convertersFromString.ConverterDocumentBIFromString;
import pl.malopolska.irregularities.convertersFromString.ConverterInstitutionFromString;
import pl.malopolska.irregularities.convertersFromString.ConverterIrregularityTypeFromString;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.malopolska.irregularities")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.malopolska.irregularities")
public class AppConfig implements WebMvcConfigurer {

//    @Bean
//    public LocalEntityManagerFactoryBean entityManagerFactory() {
//        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
//        emfb.setPersistenceUnitName("irregularitiesPersistenceUnit");
//        return emfb;
//    }
//    @Bean
//    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager tm = new JpaTransactionManager(emf);
//        return tm;
//    }
//
//    @Override
//    public void configureDefaultServletHandling(
//            DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//
//    @Bean(name="localeResolver")
//    public LocaleContextResolver getLocaleContextResolver() {
//        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        localeResolver.setDefaultLocale(new Locale("pl","PL"));
//        return localeResolver; }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getConverterInstitutionFromLong());
        registry.addConverter(getConverterBeneficiaryFromString());
        registry.addConverter(getConverterDocumentBIFromString());
        registry.addConverter(getConverterIrregularityTypeFromString());
    }

    @Bean
    public ConverterInstitutionFromString getConverterInstitutionFromLong() {return new ConverterInstitutionFromString();}

    @Bean
    public ConverterBeneficiaryFromString getConverterBeneficiaryFromString() {return new ConverterBeneficiaryFromString();}

    @Bean
    public ConverterDocumentBIFromString getConverterDocumentBIFromString() {return new ConverterDocumentBIFromString();}

    @Bean
    public ConverterIrregularityTypeFromString getConverterIrregularityTypeFromString() {return new ConverterIrregularityTypeFromString();}

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/resources/META-INF/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/resources/META-INF/webjars/");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/403").setViewName("403");
    }
}