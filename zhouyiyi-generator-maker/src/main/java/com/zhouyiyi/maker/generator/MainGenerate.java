package com.zhouyiyi.maker.generator;

import com.zhouyiyi.maker.meta.Meta;
import com.zhouyiyi.maker.meta.MetaManger;

public class MainGenerate {
    public static void main(String[] args) {
        Meta meta = MetaManger.getMeta();
        System.out.println(meta);
    }
}
