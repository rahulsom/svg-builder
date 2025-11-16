package com.github.rahulsom.svg

import org.junit.jupiter.api.Test

import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.assertThatCode

class SvgSpec {
    private static final String EXPECTED = '''\
        <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
        <svg width="7" height="3" xmlns="http://www.w3.org/2000/svg" xmlns:ns2="http://www.w3.org/1999/xlink">
            <circle/>
            <a/>
        </svg>
        '''.stripIndent()

    @Test
    void javaBuilderWorks() {
        assertThat(JavaBuilder.createSvg()).isEqualTo(EXPECTED)
    }

    @Test
    void kotlinBuilderWorks() {
        assertThat(KotlinBuilder.createSvg()).isEqualTo(EXPECTED)
    }

    @Test
    void groovyBuilderWorks() {
        assertThat(GroovyBuilder.createSvg()).isEqualTo(EXPECTED)
    }

    @Test
    void groovyBuilderWorksWithStyle() {
        assertThatCode(() -> GroovyBuilder.createWithStyle()).doesNotThrowAnyException()
    }
}
