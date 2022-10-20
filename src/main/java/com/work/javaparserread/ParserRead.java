package com.work.javaparserread;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Objects;

public class ParserRead {
    public static void main(String[] args) throws FileNotFoundException {
        ergodicDir(Paths.get("C:\\Users\\cuidj\\Desktop\\test").toFile());
    }

    public static void ergodicDir(File dir) throws FileNotFoundException {
        if (dir.isDirectory()) {
            for (File file : Objects.requireNonNull(dir.listFiles())) {
                if (file.isDirectory()) {
                    ergodicDir(file);
                }
                if (file.isFile() && file.getName().endsWith("java")) {
                    CompilationUnit cu = StaticJavaParser.parse(file);
                    if (cu.getType(0).getName().toString().toLowerCase().contains("input")) {
                        cu.getType(0).getChildNodes().stream().filter(x -> x.getTokenRange().toString().contains("@")).forEach(y -> y.getTokenRange().stream().filter(x -> x.toString().contains("name")).forEach(z -> {
                            String inputBean = StringUtils.substringBetween(z.toString(), "\"", "\"");
                            System.out.println("input.set" + inputBean + "(form.get" + inputBean + "());");
                        }));
                    } else if (cu.getType(0).getName().toString().toLowerCase().contains("output")) {
                        cu.getType(0).getChildNodes().stream().filter(x -> x.getTokenRange().toString().contains("@")).forEach(y -> y.getTokenRange().stream().filter(x -> x.toString().contains("name")).forEach(z -> {
                            String outputBean = StringUtils.substringBetween(z.toString(), "\"", "\"");
                            System.out.println("form.set" + outputBean + "(output.get" + outputBean + "());");
                        }));
                    }
                }
            }
        }
    }
}
