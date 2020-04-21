package pl.malopolska.irregularities.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.malopolska.irregularities.convertersFromString.*;

import javax.validation.Validator;

@Configuration
@ComponentScan(basePackages = "pl.malopolska.irregularities")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.malopolska.irregularities")
public class AppConfig implements WebMvcConfigurer {


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
        registry.addConverter(getConverterFromStringProject());
        registry.addConverter(getConverterPaymentRequestFromString());
    }

    @Bean
    public ConverterInstitutionFromString getConverterInstitutionFromLong() {return new ConverterInstitutionFromString();}

    @Bean
    public ConverterBeneficiaryFromString getConverterBeneficiaryFromString() {return new ConverterBeneficiaryFromString();}

    @Bean
    public ConverterDocumentBIFromString getConverterDocumentBIFromString() {return new ConverterDocumentBIFromString();}

    @Bean
    public ConverterIrregularityTypeFromString getConverterIrregularityTypeFromString() {return new ConverterIrregularityTypeFromString();}

    @Bean
    public ConverterFromStringProject getConverterFromStringProject() {return new ConverterFromStringProject();}

    @Bean
    public ConverterPaymentRequestFromString getConverterPaymentRequestFromString() {return new ConverterPaymentRequestFromString();}

    @Bean
    public ConverterUserFromString getConverterUserFromString() {return new ConverterUserFromString();}

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/resources/META-INF/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/resources/META-INF/webjars/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/WEB-INF/view/react/build/static/");
        registry.addResourceHandler("/*.js")
                .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/*.json")
                .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/*.ico")
                .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/index.html")
                .addResourceLocations("/WEB-INF/view/react/build/index.html");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("loginForm");
        registry.addViewController("/403").setViewName("403");
    }
}