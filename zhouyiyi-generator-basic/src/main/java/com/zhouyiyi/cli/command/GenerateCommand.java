package com.zhouyiyi.cli.command;

import cn.hutool.core.bean.BeanUtil;
import freemarker.template.TemplateException;
import lombok.Data;
import com.zhouyiyi.generator.MainGenerator;
import com.zhouyiyi.model.MainTemplateConfig;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "generate", version = "0.0.0.1", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {


    /**
     * 开关
     */
    @Option(names = {"-l", "--loop"}, description = "是否循环：", arity = "0..1", interactive = true, echo = true)
    private Boolean loop;
    /**
     * 作者
     */
    @Option(names = {"-a", "--author"}, description = "作者名称：", arity = "0..1", interactive = true, echo = true)
    private String author;

    /**
     * 输出
     */
    @Option(names = {"-o", "--output"}, description = "输出文本：", arity = "0..1", interactive = true, echo = true)
    private String output;


    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        try {
            MainGenerator.doGenerate(mainTemplateConfig);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
