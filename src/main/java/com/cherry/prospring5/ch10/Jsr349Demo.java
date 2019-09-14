package com.cherry.prospring5.ch10;

import com.cherry.prospring5.ch10.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class Jsr349Demo {
    private static Logger logger =
            LoggerFactory.getLogger(Jsr349Demo.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        SingerValidationService singerBeanValidationService =
                ctx.getBean( SingerValidationService.class);
        com.cherry.prospring5.ch10.obj.Singer singer = new com.cherry.prospring5.ch10.obj.Singer();
        singer.setFirstName("J");
        singer.setLastName("Mayer");
        singer.setGenre(null);
        singer.setGender(null);
        validateSinger(singer, singerBeanValidationService);
        ctx.close();
    }

    private static void validateSinger(com.cherry.prospring5.ch10.obj.Singer singer,
                                       SingerValidationService singerValidationService) {
        Set<ConstraintViolation<com.cherry.prospring5.ch10.obj.Singer>> violations =
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
