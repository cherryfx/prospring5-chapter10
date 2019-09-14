package com.cherry.prospring5.ch10;

import com.cherry.prospring5.ch10.obj.Singer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountrySingerValidator implements ConstraintValidator<CheckCountrySinger, Singer> {
    @Override
    public void initialize(CheckCountrySinger constraintAnnotation) {

    }

    @Override
    public boolean isValid(Singer singer, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if (singer.getGenre() != null && (singer.isCountrySinger() &&
                (singer.getLastName() == null || singer.getGender() == null))) {
            result = false;
        }
        return result;
    }
}
