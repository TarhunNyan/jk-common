package sg01.common.api.wrapper.isp;

public interface IHaveSubstituteWrapObject<T, This extends IHaveSubstituteWrapObject<T, This>> {

    public This substituteWrapObject(T object);

}
