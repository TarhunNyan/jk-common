package sg01.common.api.di.isp;

import sg01.common.api.di.error.DependencyNotFoundException;

public interface IHaveResolve {

    public <T> T resolve(Class<T> type) throws DependencyNotFoundException;

}
