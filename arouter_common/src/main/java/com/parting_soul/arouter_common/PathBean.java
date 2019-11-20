package com.parting_soul.arouter_common;

/**
 * 路径
 *
 * @author parting_soul
 * @date 2019-11-19
 */
public class PathBean {
    private String path;
    private Class<?> targetClass;

    public PathBean(String path, Class<?> targetClass) {
        this.path = path;
        this.targetClass = targetClass;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }
}
