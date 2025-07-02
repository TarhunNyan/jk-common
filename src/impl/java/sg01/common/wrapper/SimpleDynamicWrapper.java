package sg01.common.wrapper;

import lombok.Getter;
import sg01.common.api.wrapper.IDynamicWrapper;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleDynamicWrapper<T> implements IDynamicWrapper<T> {

    @Getter
    protected T wrappedObject;
    private Class<T> interfaceType;

    public <O extends T> SimpleDynamicWrapper(Class<T> interfaceType, O wrappedObject) {
        this.wrappedObject = wrappedObject;
        this.interfaceType = interfaceType;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(wrappedObject, args);
    }

    @Override
    public T getProxy() {
        @SuppressWarnings("unchecked")
        T proxyInstance = (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                this
        );
        return proxyInstance;
    }

    @Override
    public IDynamicWrapper<T> substituteWrapObject(T object) {
        this.wrappedObject = object;
        return this;
    }

}
