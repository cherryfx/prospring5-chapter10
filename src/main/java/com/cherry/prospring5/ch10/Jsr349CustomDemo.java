package com.cherry.prospring5.ch10;

import com.cherry.prospring5.ch10.config.AppConfig;
import com.cherry.prospring5.ch10.obj.Genre;

import com.cherry.prospring5.ch10.obj.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class Jsr349CustomDemo {

    private static Logger logger =
            LoggerFactory.getLogger(Jsr349CustomDemo.class);

    public static void main(String[] args) {
        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setGenre(Genre.COUNTRY);
        singer.setGender(null);

        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        SingerValidationService singerValidationService =
                ctx.getBean(SingerValidationService.class);


        validateSinger(singer, singerValidationService);
    }

    private static void validateSinger(com.cherry.prospring5.ch10.obj.Singer singer,
                                       SingerValidationService singerValidationService) {
        Set<ConstraintViolation<Singer>> violations =
                singerValidationService.validateSinger(singer);
        listViolations(violations);
    }

    private static void listViolations(
            Set<ConstraintViolation<com.cherry.prospring5.ch10.obj.Singer>> violations) {
        logger.info("No. of violations: " + violations.size());
        for (ConstraintViolation<com.cherry.prospring5.ch10.obj.Singer> violation : violations) {
            logger.info("Validation error for property: " +
                    violation.getPropertyPath()
                    + " with value: " + violation.getInvalidValue()
                    + " with error message: " + violation.getMessage());
        }
    }
}
