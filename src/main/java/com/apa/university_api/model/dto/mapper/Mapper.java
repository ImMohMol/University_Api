package com.apa.university_api.model.dto.mapper;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {
    public <TS, TT> TT convert(TS source, Type targetType) {
        try {
            TT target = (TT) Class.forName(targetType.getTypeName()).newInstance();
            List<Method> targetAccessorMethods = createAccessorsList(target, false);
            List<Method> sourceAccessorMethods = createAccessorsList(source, true);

            for (Method handler : targetAccessorMethods) {
                for (Method sourceAccessorMethod : sourceAccessorMethods) {
                    if (sourceAccessorMethod.getName().substring(3).equals(handler.getName().substring(3))) {
                        handler.invoke(target, sourceAccessorMethod.invoke(source));
                        break;
                    }
                }
            }
            return target;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Method> createAccessorsList(Object object, boolean isCreatingGetters) {
        Field[] fields = object.getClass().getDeclaredFields();
        Method[] methods = object.getClass().getDeclaredMethods();
        List<Method> accessorMethods = new ArrayList<>();

        for (Field field : fields) {
            // Creating the method name based on the field name
            StringBuilder handler = new StringBuilder(field.getName());
            handler.deleteCharAt(0);
            handler.insert(0, Character.toUpperCase(field.getName().charAt(0)));
            handler.insert(0, isCreatingGetters ? "get" : "set");

            // finding method
            for (Method method : methods) {
                if (method.getName().equals(handler.toString())) {
                    accessorMethods.add(method);
                    break;
                }
            }
        }
        return accessorMethods;
    }
}
