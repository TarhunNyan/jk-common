package sg01.common.api.wrapper;

import sg01.common.api.wrapper.isp.IHaveGetProxy;
import sg01.common.api.wrapper.isp.IHaveSubstituteWrapObject;
import sg01.common.api.wrapper.isp.IHaveWrapObject;

import java.lang.reflect.InvocationHandler;

/**
 * EFP-2: [dynamic_wrapper]
 */
public interface IDynamicWrapper<T> extends
        IWrapper,
        InvocationHandler,
        IHaveWrapObject<T>,
        IHaveGetProxy<T>,
        IHaveSubstituteWrapObject<T, IDynamicWrapper<T>> {

}
