package sg01.common.di;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import sg01.common.api.di.error.ConstructorNotFoundException;
import sg01.common.api.di.error.DependencyCreateException;
import sg01.common.api.di.error.DependencyNotFoundException;
import sg01.common.api.di.isp.IHaveCreateInstance;
import sg01.common.api.di.isp.IHaveResolve;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class CreateInstance implements IHaveCreateInstance {

    @Override
    public <T> T createInstance(@NonNull Class<T> type, @NonNull IHaveResolve container) {
        try {
            Constructor<?>[] constructors = type.getConstructors();
            if (constructors.length != 1) {
                throw new ConstructorNotFoundException("Class must have 1 public constructor. Cannot create instance for: " + type.getName());
            }
            Constructor<?> constructor = constructors[0];
            Class<?>[] paramTypes = constructor.getParameterTypes();
            Object[] params = new Object[paramTypes.length];
            try {
                for (int i = 0; i < paramTypes.length; i++) {
                    Object resolve = container.resolve(paramTypes[i]);
                    params[i] = resolve;
                }
            } catch (DependencyNotFoundException e) {
                checkParamsExist((Class<Object>) type, paramTypes, container);
            }
            return type.cast(constructor.newInstance(params));
        } catch (SecurityException e) {
            throw new DependencyCreateException("Cannot get constructor for: " + type.getName() + ". Security exception", e);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new DependencyCreateException("Cannot create instance of: " + type.getName(), e);
        }
    }

    private void checkParamsExist(Class<Object> type, Class<?>[] paramTypes, IHaveResolve container) {
        List<String> notFoundTypes = new ArrayList<>();
        for (int i = 0; i < paramTypes.length; i++) {
            try {
                container.resolve(paramTypes[i]);
            } catch (DependencyNotFoundException e) {
                notFoundTypes.add(" - parameter index: " + i + ", type: " + paramTypes[i].getName());
            }
        }
        if(notFoundTypes.isEmpty()) return;
        throw new DependencyNotFoundException("Container not contain dependency. Cannot create instance for: " + type.getName() + ". The following dependencies were not found:\n" + String.join(";\n", notFoundTypes));
    }

}
