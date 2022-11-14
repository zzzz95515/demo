package ru.mpei.prob.model.CIMProfile.ResourceAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AssociationSetter {
    String fieldName();

    String cardinality();

    String assocType();
}
