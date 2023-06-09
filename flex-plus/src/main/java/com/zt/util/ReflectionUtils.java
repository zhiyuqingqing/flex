package com.zt.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Author: zhoutian
 * @CreateTime: 2023-06-09  11:44
 * @Description: TODO
 * @Version: 1.0
 */
public class ReflectionUtils {

    // 获取字段
    public static Object getField(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

    // 设置字段的值
    public static void setField(Object object, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }

    // 调用方法
    public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] arguments) throws NoSuchMethodException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
        Class<?> clazz = object.getClass();
        Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(object, arguments);
    }

    // 创建实例
    public static Object createInstance(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    public static boolean isWrapper(Class<?> clazz) {
        return clazz.isPrimitive() || clazz.equals(Boolean.class) ||
                clazz.equals(Byte.class) || clazz.equals(String.class) ||
                clazz.equals(Short.class) || clazz.equals(Integer.class) ||
                clazz.equals(Long.class) || clazz.equals(Float.class) ||
                clazz.equals(Double.class) || clazz.equals(Void.class);
    }

    public static void getAllFieldValues(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        while (clazz != null && !clazz.equals(Object.class)) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers())) continue;
                field.setAccessible(true);
                Object value = field.get(object);
                if (value != null && !isWrapper(field.getType())) {
                    getAllFieldValues(value); // 递归处理嵌套对象
                } else {
                    System.out.println(field.getName() + ": " + value);
                }
            }
            clazz = clazz.getSuperclass();
        }

    }
}
