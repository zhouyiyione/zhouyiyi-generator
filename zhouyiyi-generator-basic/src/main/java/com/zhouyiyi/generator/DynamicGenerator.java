package com.zhouyiyi.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import com.zhouyiyi.model.MainTemplateConfig;

import java.io.*;

public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        String property = System.getProperty("user.dir") + File.separator + "zhouyiyi-generator-basic";
        File file = new File(property, "src/main/resources/templates");
        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(file);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate("MainTemplateJava.ftl");

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();

        Writer out = new FileWriter("MainTemplateJava1.java");

        template.process(mainTemplateConfig, out);
        // 生成文件后别忘了关闭哦
        out.close();
    }

    /**
     * 生成文件
     *
     * @param inputPath  模板文件输入路径
     * @param outputPath 输出路径
     * @param model      数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        // 生成
        // 使用 OutputStreamWriter 并指定 UTF-8 编码
        try (Writer out = new OutputStreamWriter(new FileOutputStream(outputPath), "UTF-8")) {
            // 处理模板
            template.process(model, out);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

}
