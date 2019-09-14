package com.cherry.prospring5.ch10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service("singerValidationService")
public class SingerValidationService {
    @Autowired
    private Validator validator;

    public Set<ConstraintViolation<com.cherry.prospring5.ch10.obj.Singer>>
    validateSinger(com.cherry.prospring5.ch10.obj.Singer singer) {
        return validator.validate(singer);
    }
}
