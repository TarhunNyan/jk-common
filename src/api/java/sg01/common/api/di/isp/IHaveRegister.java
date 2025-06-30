package sg01.common.api.di.isp;

public interface IHaveRegister {

    public <T> void register(Class<T> interfaceType, Class<? extends T> implementationType);

}
