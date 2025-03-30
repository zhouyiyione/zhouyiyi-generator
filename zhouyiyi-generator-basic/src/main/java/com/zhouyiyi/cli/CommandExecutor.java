package com.zhouyiyi.cli;

import com.zhouyiyi.cli.command.ConfigCommand;
import com.zhouyiyi.cli.command.GenerateCommand;
import com.zhouyiyi.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "zhouyi", mixinStandardHelpOptions = true,version = "0.0.0.1")
public class CommandExecutor implements Runnable{

    private final CommandLine commandLine;

    {
        commandLine=new CommandLine(this)
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        System.out.println("请输入具体命令，或输入--help 查看命令列表");
    }

    /**
     * 执行命令
     */
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
