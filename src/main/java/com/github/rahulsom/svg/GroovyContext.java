package com.github.rahulsom.svg;

import groovy.lang.MetaClass;
import groovy.lang.MetaMethod;
import groovy.transform.CompileStatic;
import groovy.transform.Memoized;
import groovy.transform.TypeChecked;
import jakarta.xml.bind.JAXBElement;
import org.codehaus.groovy.runtime.InvokerHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CompileStatic
@TypeChecked
public class GroovyContext {
    List<JAXBElement<?>> things = new ArrayList<>();

    public List<JAXBElement<?>> getThings() {
        return things;
    }

    public boolean leftShift(Object object) {
        if (object instanceof JAXBElement<?> o) {
            return things.add(o);
        } else {
            var factory = new ObjectFactory();
            var metaClass = InvokerHelper.getMetaClass(factory);
            var objectClass = object.getClass();
            MetaMethod method = getMethod(metaClass, objectClass);

            return things.add((JAXBElement<?>) method.invoke(factory, new Object[]{object}));
        }
    }

    @Memoized
    private static MetaMethod getMethod(MetaClass metaClass, Class<?> objectClass) {
        return metaClass.getMethods().stream().filter(it ->
                Objects.equals(it.getReturnType(), JAXBElement.class) &&
                        it.getParameterTypes().length == 1 &&
                        it.getParameterTypes()[0].isAssignableFrom(objectClass) &&
                        !Objects.equals(it.getParameterTypes()[0].getName(), "java.lang.Object")
        ).findAny().orElse(null);
    }
}
