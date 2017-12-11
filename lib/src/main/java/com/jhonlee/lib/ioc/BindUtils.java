package com.jhonlee.lib.ioc;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/1
 * @Version 1.0
 * @Description  ioc 绑定工具
 */
public class BindUtils {

    private BindUtils() {
    }

    public static void init(Activity activity) {
        init(new BindFinder(activity), activity);
    }

    public static void init(View view) {
        init(new BindFinder(view), view);
    }

    public static void init(View view, Object object) {
        init(new BindFinder(view), object);
    }

    public static void init(BindFinder finder, Object object) {
        initFiled(finder, object);
        initEvent(finder, object);
    }

    //反射绑定view
    private static void initFiled(BindFinder finder, Object object) {

        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field :
                fields) {
            Bind bind = field.getAnnotation(Bind.class);
            if (bind != null) {
                int bindId = bind.value();
                View view = finder.findViewByid(bindId);
                field.setAccessible(true);
                try {
                    field.set(object, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static void initEvent(BindFinder finder, Object object) {
        Class clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method :
                methods) {
            Click click = method.getAnnotation(Click.class);
            if (click != null) {
                int[] valueIds = click.value();
                for (int valueId :
                        valueIds) {
                    View view = finder.findViewByid(valueId);
                    if (view != null) {
                        view.setOnClickListener(new DeclearedOnClickListener(method, object));
                    }
                }
            }
        }
    }
    private static class DeclearedOnClickListener implements View.OnClickListener {

        private Method mMethod;
        private Object mObj;

        public DeclearedOnClickListener(Method mMethod, Object mObj) {
            this.mMethod = mMethod;
            this.mObj = mObj;
        }
        @Override
        public void onClick(View v) {
            try {
                mMethod.setAccessible(true);
                mMethod.invoke(mObj, v);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    mMethod.invoke(mObj);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
