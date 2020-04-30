package com.activiti.demo.util;

import org.activiti.engine.impl.cfg.IdGenerator;

import java.util.UUID;

/**
 * @ClassName hhl
 * @Description TODO
 * @Author Administrator
 * @Date 2020/4/28 15:08
 * @Version 1.0
 **/
public class IdGen implements IdGenerator {
    @Override
    public String getNextId() {
        return IdGen.uuid();
    }

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
