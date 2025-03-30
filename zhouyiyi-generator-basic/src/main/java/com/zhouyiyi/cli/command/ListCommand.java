package com.zhouyiyi.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

@CommandLine.Command(name = "list",version = "0.0.0.1",mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{

    //当前根路径
    private static String path = System.getProperty("user.dir");
    //模板项目路径
    private static String templatePath = path + File.separator + "zhouyiyi-generator-demo-projects";

    @Override
    public void run() {
        String absolutePath = new File(templatePath).getAbsolutePath();
        List<File> files = FileUtil.loopFiles(absolutePath);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
