package io.github.boasmat.validation.constraintvalidation;

import io.github.boasmat.validation.NotEmptyList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List> {
    @Override
    public void initialize(NotEmptyList constraintAnnotation) {
        System.out.println();
    }



    @Override //fala se é valido
    public boolean isValid(List value, ConstraintValidatorContext context) {
        System.out.println();
        return null != value && !value.isEmpty();
    }
}
