package sg01.common.wrapper;

import sg01.common.api.wrapper.IDynamicWrapper;

public class SimpleDynamicWrapperTest extends IDynamicWrapperTest {

    @Override
    public <T, O extends T> IDynamicWrapper<T> createWrapper(Class<T> interfaceType, O wrapped) {
        return new SimpleDynamicWrapper<T>(interfaceType, wrapped);
    }

}
