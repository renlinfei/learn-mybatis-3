package com.chrisren.learnmybatis3.diy.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReflectionUtil {

    public static void setPropToBean(Object bean, String propName, Object value) {
        Field field;
        try {
            field = bean.getClass().getDeclaredField(propName);
            field.setAccessible(true);
            field.set(bean, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void setPropBeanFromResult(Object entity, ResultSet resultSet) throws SQLException {
        Field[] declaredFields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            if (declaredFields[i].getType().getSimpleName().equals("String")) {
                setPropToBean(entity, declaredFields[i].getName(), resultSet.getString(declaredFields[i].getName()));
            } else if (declaredFields[i].getType().getSimpleName().equals("Integer")) {
                setPropToBean(entity, declaredFields[i].getName(), resultSet.getInt(declaredFields[i].getName()));
            } else if (declaredFields[i].getType().getSimpleName().equals("Long")) {
                setPropToBean(entity, declaredFields[i].getName(), resultSet.getLong(declaredFields[i].getName()));
            }
        }
    }
}
