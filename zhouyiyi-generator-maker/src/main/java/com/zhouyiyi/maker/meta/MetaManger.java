package com.zhouyiyi.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManger {
    //单例模式
    //项目在运行期间 只存在一个被初始化的对象示例 防止重复创建对象 影响性能

    //双检锁单例模式
    //双检锁:多线程情况（重复初始化对象）解决:加锁

    //饿汉式
    //final修饰 属性初始化的时候就调用initMeta();

    //1.保存对象
    private static volatile Meta meta;//volatile 多线程环境下内存可见性
    //2.获取对象
    public static Meta getMeta() {
        if (meta == null) {
            synchronized (MetaManger.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }
    //3.初始化对象
    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta meta = JSONUtil.toBean(metaJson, Meta.class);
        // todo 对象校验
        return meta;
    }
}
