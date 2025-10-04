package com.github.rahulsom.svg

import groovy.transform.CompileStatic
import groovy.transform.Memoized
import groovy.transform.TypeChecked
import jakarta.xml.bind.JAXBElement

@CompileStatic
@TypeChecked
class GroovyContext {
    List<JAXBElement> things = new ArrayList<>();

    boolean leftShift(Object object) {

        if (object instanceof JAXBElement) {
            things.add(object)
        } else {

            def factory = new ObjectFactory()
            def metaClass = factory.metaClass
            def objectClass = object.class
            MetaMethod method = getMethod(metaClass, objectClass)

            things.add(method.invoke(factory, [object] as Object[]) as JAXBElement)
        }

    }

    @Memoized
    private static MetaMethod getMethod(MetaClass metaClass, Class objectClass) {
        metaClass.methods.find {
            it.returnType == JAXBElement &&
                    it.parameterTypes.length == 1 &&
                    it.parameterTypes[0].isAssignableFrom(objectClass) &&
                    it.parameterTypes[0].name != 'java.lang.Object'
        }
    }
}
