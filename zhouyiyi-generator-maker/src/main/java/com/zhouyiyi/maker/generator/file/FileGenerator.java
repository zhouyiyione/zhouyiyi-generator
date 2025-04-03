package com.zhouyiyi.maker.generator.file;

import freemarker.template.TemplateException;
import com.zhouyiyi.maker.model.DataModel;

import java.io.File;
import java.io.IOException;

public class FileGenerator {

    //当前根路径
    private static String path = System.getProperty("user.dir");
    //模板项目路径
    private static String templatePath = path + File.separator + "zhouyiyi-generator-demo-projects";
    //当前项目路径
    private static String projectPath = path + File.separator + "zhouyiyi-generator-maker";

    public static void doGenerate(Object model) throws TemplateException, IOException {

        //输入
        String inputPath = templatePath + File.separator + "acm-template";
        //输出
        String outputPath = path;
        //复制
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);

        //模板路径
        String input = projectPath+ File.separator+"src/main/resources/templates/MainTemplateJava.ftl";
        String out = path + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";

        DynamicFileGenerator.doGenerate(input, out, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {

        //输入
        String inputPath = templatePath + File.separator + "acm-template";
        //输出
        String outputPath = path;
        //复制
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);

        //模板路径
        String input = projectPath+ File.separator+"src/main/resources/templates/MainTemplateJava.ftl";
        String out = path + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerate(input, out, new DataModel());
    }
}
