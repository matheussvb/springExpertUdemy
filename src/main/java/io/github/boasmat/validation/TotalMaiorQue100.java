package io.github.boasmat.validation;

import io.github.boasmat.validation.constraintvalidation.MaiorQue;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaiorQue.class)
public @interface TotalMaiorQue100 {

    String message() default "Deve ser maior que 100";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
