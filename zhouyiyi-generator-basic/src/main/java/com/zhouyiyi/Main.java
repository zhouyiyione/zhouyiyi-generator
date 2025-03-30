package com.zhouyiyi;

import com.zhouyiyi.cli.CommandExecutor;

public class Main {

    public static void main(String[] args) {
//        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
        args = new String[]{"generate","--help"};
        CommandExecutor commandExecutor = new CommandExecutor();

        commandExecutor.doExecute(args);
    }
}
