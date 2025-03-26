package org.zhouyiyi.generator;

import freemarker.template.TemplateException;
import org.zhouyiyi.model.MainTemplateConfig;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //当前根目录
        String projectPath = System.getProperty("user.dir");
        //输入
        String inputPath = projectPath + File.separator + "zhouyiyi-generator-demo-projects" + File.separator + "acm-template";
        //输出
        String outputPath = projectPath;
        //复制
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        //模板路径
        String input = projectPath + File.separator + "zhouyiyi-generator-basic/src/main/resources/templates/MainTemplateJava.ftl";
        String out = projectPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(input, out, new MainTemplateConfig("1111","666",false));
    }
}
