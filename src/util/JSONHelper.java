package util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Admin on 2017/7/18.
 */
public class JSONHelper {
    public static <T> JSONArray getJSONArrayFromList(List<T> list) {
        JSONArray jsonArray = new JSONArray();

        for (T item : list) {
            JSONObject jsonObject = JSONHelper.getJSONObjectFromClass(item);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public static <T> JSONObject getJSONObjectFromClass(T item) {
        JSONObject jsonObject = new JSONObject();
        try {
            // properties存储所有属性
            Field[] properties = item.getClass().getDeclaredFields();
            for (Field property : properties) {
                // 属性名
                String propertyName = property.getName();
                String propertyNameUpper = propertyName.substring(0, 1).toUpperCase() +
                        propertyName.substring(1); // 首字母大写
                Method get = item.getClass().getMethod("get" + propertyNameUpper);
                // 属性值
                String propertyValue = get.invoke(item).toString();
                jsonObject.put(propertyName, propertyValue);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            //
        }
        return jsonObject;
    }
}
