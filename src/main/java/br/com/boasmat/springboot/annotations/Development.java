package br.com.boasmat.springboot.annotations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Profile("development")
@Configuration
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Development {

//    Retention(RetentionPolicy.RUNTIME) means that the annotation can be
//    accessed via reflection at runtime. If you do not set this directive,
//    the annotation will not be preserved at runtime, and thus not available via reflection.

//    @Target(ElementType.TYPE) means that the annotation can only be
//    used ontop of types (classes and interfaces typically).
//    You can also specify METHOD or FIELD, or you can leave the target out
//    alltogether so the annotation can be used for both classes, methods and fields.
}
