package com.github.rahulsom.svg

import java.lang.reflect.Method
import jakarta.xml.bind.JAXBElement

class KotlinContext {
    val things = mutableListOf<JAXBElement<*>>()

    fun add(thing: Any) =
        when (thing) {
            is JAXBElement<*> -> things.add(thing)
            else -> getMethod(thing)?.let { addThing(it, thing) } ?: false
        }

    private fun addThing(it: Method, thing: Any) =
        things.add(it.invoke(ObjectFactory(), thing) as JAXBElement<*>)

    private fun getMethod(thing: Any): Method? {
        return ObjectFactory::class.java.declaredMethods
            .filter {
                it.returnType == JAXBElement::class.java &&
                        it.parameterTypes.size == 1 &&
                        it.parameterTypes[0].isAssignableFrom(thing::class.java) &&
                        it.parameterTypes[0].name != "java.lang.Object"

            }
            .sortedBy { it.name.length }
            .firstOrNull()
    }
}
