package com.github.rahulsom.svgbuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GroovyNewifyBuilder {
    public void createFile(File buildDir) {
        String sourcesDir = new File(buildDir, "generated/sources/xjc/java/main/com/github/rahulsom/svg").getAbsolutePath();
        String classNames = Arrays.stream(new File(sourcesDir).listFiles())
                .map(it -> it.getName().replace(".java", ""))
                .filter(it -> !it.equals("package-info"))
                .collect(Collectors.joining(", ", "@Newify([", "])"));

        try {
            File dir = new File(buildDir, "groovysupport/generated-sources/com/github/rahulsom/svg/");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            PrintWriter fileWriter =
                    new PrintWriter(new FileWriter(new File(buildDir, "groovysupport/generated-sources/com/github/rahulsom/svg/NewifySvg.groovy")));
            fileWriter.println("package com.github.rahulsom.svg");
            fileWriter.println("");
            fileWriter.println("import groovy.transform.AnnotationCollector");
            fileWriter.println("@AnnotationCollector");
            fileWriter.println(classNames);
            fileWriter.println("@interface NewifySvg {}");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
