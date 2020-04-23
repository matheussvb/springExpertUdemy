package io.github.boasmat.validation.constraintvalidation;

import io.github.boasmat.validation.TotalMaiorQue100;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class MaiorQue implements ConstraintValidator<TotalMaiorQue100, BigDecimal> {
    @Override
    public void initialize(TotalMaiorQue100 constraintAnnotation) {
        constraintAnnotation.message();
    }

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        return value.intValue() > 100;
    }
}
