package com.parting_soul.arouter_common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author parting_soul
 * @date 2019-11-19
 */
public class RecordManager {
    private static RecordManager sRecordManager;

    private Map<String, List<PathBean>> mPathMap = new HashMap<>();

    private RecordManager() {
    }

    public static RecordManager getInstance() {
        if (sRecordManager == null) {
            synchronized (RecordManager.class) {
                if (sRecordManager == null) {
                    sRecordManager = new RecordManager();
                }
            }
        }
        return sRecordManager;
    }

    /**
     * 添加路径信息
     *
     * @param group       所在组
     * @param path        路径
     * @param targetClass 对应的Class
     */
    public void addPath(String group, String path, Class<?> targetClass) {
        List<PathBean> pathBeans = mPathMap.get(group);
        if (pathBeans == null) {
            //组不存在，则创建组并且加入
            pathBeans = new ArrayList<>();
            pathBeans.add(new PathBean(path, targetClass));
            mPathMap.put(group, pathBeans);
        } else {
            Class<?> clazz = getTargetClass(group, path);
            if (clazz == null) {
                //组中不存在该路径，则加入该路径
                pathBeans.add(new PathBean(path, targetClass));
            }
        }
    }

    /**
     * 根据组合路径获取目标Class
     *
     * @param group
     * @param path
     * @return
     */
    public Class<?> getTargetClass(String group, String path) {
        List<PathBean> pathBeans = mPathMap.get(group);
        Class<?> clazz = null;
        if (pathBeans != null) {
            for (PathBean p : pathBeans) {
                if (p.getPath().equalsIgnoreCase(path)) {
                    clazz = p.getTargetClass();
                    break;
                }
            }
        }
        return clazz;
    }
}
