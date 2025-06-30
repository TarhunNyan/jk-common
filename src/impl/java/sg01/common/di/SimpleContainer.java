package sg01.common.di;

import sg01.common.api.di.error.DependencyNotFoundException;
import sg01.common.api.di.isp.IHaveCreateInstance;
import sg01.common.api.di.ISimpleContainer;

import java.util.HashMap;
import java.util.Map;

public class SimpleContainer implements ISimpleContainer {

    private final Map<Class<?>, Object> instanceCollection;
    private final Map<Class<?>, Class<?>> implementationCollection;
    private final IHaveCreateInstance createInstance;

    public SimpleContainer(IHaveCreateInstance createInstance) {
        this.instanceCollection = new HashMap<>();
        this.implementationCollection = new HashMap<>();
        this.createInstance = createInstance;
    }

    @Override
    public <T> void register(Class<T> interfaceType, Class<? extends T> implementationType) {
        implementationCollection.put(interfaceType, implementationType);
    }

    @Override
    public <T> T resolve(Class<T> type) {
        Object instance = instanceCollection.get(type);
        if (instance == null) {
            Class<?> clazz = this.implementationCollection.get(type);
            if(clazz == null) throw new DependencyNotFoundException("Container not contain dependency");
            instance = createInstance.createInstance(clazz, this);
            instanceCollection.put(type, instance);
        }
        return type.cast(instance);
    }

}
