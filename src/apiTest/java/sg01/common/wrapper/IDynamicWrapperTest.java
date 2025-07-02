package sg01.common.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sg01.common.api.wrapper.IDynamicWrapper;
import sg01.common.wrapper.test.InterfaceA;
import sg01.common.wrapper.test.RealizationA;
import sg01.common.wrapper.test.RealizationB;

import static org.junit.jupiter.api.Assertions.*;

public abstract class IDynamicWrapperTest {

    public abstract <T, O extends T> IDynamicWrapper<T> createWrapper(Class<T> interfaceType, O wrapped);

    @Test
    @DisplayName("Should return the same results from the proxy as the wrapped object")
    public void IDynamicWrapperTest1() {
        // GIVEN
        RealizationA wrapped = new RealizationA();
        IDynamicWrapper<InterfaceA> wrapper = createWrapper(InterfaceA.class, wrapped);
        // WHEN
        InterfaceA proxy = wrapper.getProxy();
        // THEN
        assertAll("Check method results",
                () -> assertEquals(wrapped.methodA1(), proxy.methodA1()),
                () -> assertEquals(wrapped.methodA2(), proxy.methodA2())
        );
    }

    @Test
    @DisplayName("Should substitute the wrapped object with a new object")
    public void IDynamicWrapperTest2() {
        // GIVEN
        RealizationA wrapped = new RealizationA();
        IDynamicWrapper<InterfaceA> wrapper = createWrapper(InterfaceA.class, wrapped);
        // WHEN
        InterfaceA substitute = new RealizationB();
        wrapper.substituteWrapObject(substitute);
        // THEN
        assertAll("Check reference",
                () -> assertNotSame(wrapped, wrapper.getWrappedObject()),
                () -> assertSame(substitute, wrapper.getWrappedObject())
        );
    }

    @Test
    @DisplayName("Should return results from the substitute object after substitution")
    public void IDynamicWrapperTest3() {
        // GIVEN
        RealizationA wrapped = new RealizationA();
        IDynamicWrapper<InterfaceA> wrapper = createWrapper(InterfaceA.class, wrapped);
        InterfaceA proxy = wrapper.getProxy();
        // WHEN
        InterfaceA substitute = new RealizationB();
        wrapper.substituteWrapObject(substitute);
        // THEN
        assertAll("Check method results",
                () -> assertEquals(substitute.methodA1(), proxy.methodA1()),
                () -> assertEquals(substitute.methodA2(), proxy.methodA2()),
                () -> assertNotEquals(wrapped.methodA1(), proxy.methodA1()),
                () -> assertNotEquals(wrapped.methodA2(), proxy.methodA2())
        );
    }

}
