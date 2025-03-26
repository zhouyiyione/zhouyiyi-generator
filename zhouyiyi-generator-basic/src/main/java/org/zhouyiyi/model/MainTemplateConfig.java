package org.zhouyiyi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 静态模板配置
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainTemplateConfig {

    /**
     * 作者
     */
    private String author = "zhouyiyi";

    /**
     * 输出
     */
    private String output = "输出：";

    /**
     * 开关
     */
    private Boolean loop = true;

}
