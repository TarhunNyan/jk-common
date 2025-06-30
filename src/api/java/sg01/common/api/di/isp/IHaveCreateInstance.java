package sg01.common.api.di.isp;

import sg01.common.api.di.IContainer;
import sg01.common.api.di.error.ConstructorNotFoundException;
import sg01.common.api.di.error.DependencyCreateException;
import sg01.common.api.di.error.DependencyNotFoundException;

public interface IHaveCreateInstance {

    public <T> T createInstance(Class<T> type, IHaveResolve container) throws DependencyNotFoundException, DependencyCreateException, ConstructorNotFoundException;

}
