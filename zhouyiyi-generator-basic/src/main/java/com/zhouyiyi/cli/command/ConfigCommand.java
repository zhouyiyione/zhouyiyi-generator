package com.zhouyiyi.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.zhouyiyi.model.MainTemplateConfig;
import picocli.CommandLine;

import java.lang.reflect.Field;
@CommandLine.Command(name = "config",mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("类型:"+field.getType());
            System.out.println("名称:"+field.getName());
        }
    }
}
