package com.github.rahulsom.svgbuilder;

import com.thaiopensource.relaxng.translate.Driver;

import java.io.File;

public class Converter {
    public void convert(File buildDir) {
        new Driver().run(new String[]{
                "-I", "dtd",
                "-O", "xsd",
                new File(buildDir, "schemas/svg.dtd").getAbsolutePath(),
                new File(buildDir,"schemas/svg.xsd").getAbsolutePath()
        });
    }
}
