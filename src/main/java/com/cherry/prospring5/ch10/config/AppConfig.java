package com.cherry.prospring5.ch10.config;

import com.cherry.prospring5.ch10.ApplicationConversionServiceFactoryBean;
import com.cherry.prospring5.ch10.Singer;
import com.cherry.prospring5.ch10.SingerToAnotherSingerConverter;
import com.cherry.prospring5.ch10.StringToDateTimeConverter;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.net.URL;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

//@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan(basePackages = "com.cherry.prospring5.ch10")
public class AppConfig {
//    @Value("${date.format.pattern}")
//    private String dateFormatPattern;
//
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer
//    propertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//
//    @Bean
//    public Singer john(@Value("${countrySinger.firstName}") String firstName,
//                       @Value("${countrySinger.lastName}") String lastName,
//                       @Value("${countrySinger.personalSite}") URL personalSite,
//                       @Value("${countrySinger.birthDate}") DateTime birthDate)
//            throws Exception {
//        Singer singer = new Singer();
//        singer.setFirstName(firstName);
//        singer.setLastName(lastName);
//        singer.setPersonalSite(personalSite);
//        singer.setBirthDate(birthDate);
//        return singer;
//    }
//
//    @Bean
//    public ConversionServiceFactoryBean conversionService() {
//        ConversionServiceFactoryBean conversionServiceFactoryBean =
//                new ConversionServiceFactoryBean();
//        Set<Converter> convs = new HashSet<>();
//        convs.add(converter());
//        conversionServiceFactoryBean.setConverters(convs);
//        conversionServiceFactoryBean.afterPropertiesSet();
//        return conversionServiceFactoryBean;
//    }
//
//    @Bean
//    StringToDateTimeConverter converter() {
//        StringToDateTimeConverter conv = new StringToDateTimeConverter();
//        conv.setDatePattern(dateFormatPattern);
//        conv.init();
//        return conv;
//    }


//    @Bean
//    public Singer john() throws Exception {
//        Singer singer = new Singer();
//        singer.setFirstName("John");
//        singer.setLastName("Mayer");
//        singer.setPersonalSite(new URL("http://johnmayer.com/"));
//        singer.setBirthDate(converter().convert("1977-10-16"));
//        return singer;
//    }
//
//    @Bean
//    public ConversionServiceFactoryBean conversionService() {
//        ConversionServiceFactoryBean conversionServiceFactoryBean =
//                new ConversionServiceFactoryBean();
//        Set<Converter> convs = new HashSet<>();
//        convs.add(converter());
//        convs.add(singerConverter());
//        conversionServiceFactoryBean.setConverters(convs);
//        conversionServiceFactoryBean.afterPropertiesSet();
//        return conversionServiceFactoryBean;
//    }
//
//    @Bean
//    StringToDateTimeConverter converter() {
//        return new StringToDateTimeConverter();
//    }
//
//    @Bean
//    SingerToAnotherSingerConverter singerConverter() {
//        return new SingerToAnotherSingerConverter();
//    }

//    @Autowired
//    ApplicationConversionServiceFactoryBean conversionService;
//
//    @Bean
//    public Singer john() throws Exception {
//        Singer singer = new Singer();
//        singer.setFirstName("John");
//        singer.setLastName("Mayer");
//        singer.setPersonalSite(new URL("http://johnmayer.com/"));
//        singer.setBirthDate(conversionService.
//                getDateTimeFormatter().parse("1977-10-16", Locale.ENGLISH));
//        return singer;
//    }

    @Bean
    LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
}
