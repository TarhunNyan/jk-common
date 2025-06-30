package sg01.common.api.di;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sg01.common.api.di.error.ConstructorNotFoundException;
import sg01.common.api.di.error.DependencyNotFoundException;
import sg01.common.api.di.test.*;

import static org.junit.jupiter.api.Assertions.*;

public abstract class IContainerTest {

    public abstract ISimpleContainer createContainer();

    @Test
    @DisplayName("Should throw ConstructorNotFoundException when no constructor is present")
    public void IContainerTest4() {
        // GIVEN
        ISimpleContainer container = createContainer();
        // WHEN
        container.register(InterfaceA.class, RealizationANoConstructor.class);
        // THEN
        assertThrows(ConstructorNotFoundException.class, () -> container.resolve(InterfaceA.class));
    }

    @Test
    @DisplayName("Should throw ConstructorNotFoundException when multiple constructors are present")
    public void IContainerTest5() {
        // GIVEN
        ISimpleContainer container = createContainer();
        // WHEN
        container.register(InterfaceA.class, RealizationAMultiConstructor.class);
        // THEN
        assertThrows(ConstructorNotFoundException.class, () -> container.resolve(InterfaceA.class));
    }

    @Test
    @DisplayName("Should throw DependencyNotFoundException when dependency is not registered")
    public void IContainerTest6() {
        // GIVEN
        ISimpleContainer container = createContainer();
        // WHEN
        container.register(InterfaceB.class, RealizationBRequireA.class);
        // THEN
        assertThrows(DependencyNotFoundException.class, () -> container.resolve(InterfaceB.class));
    }

    @Test
    @DisplayName("Should resolve the correct instance of InterfaceA")
    public void IContainerTest1() {
        // GIVEN
        ISimpleContainer container = createContainer();
        // WHEN
        container.register(InterfaceA.class, RealizationA.class);
        // THEN
        assertEquals(container.resolve(InterfaceA.class), container.resolve(InterfaceA.class));
        assertTrue(container.resolve(InterfaceA.class) instanceof RealizationA);
    }

    @Test
    @DisplayName("Should resolve the same instance of InterfaceA with consistent method results")
    public void IContainerTest2() {
        // GIVEN
        ISimpleContainer container = createContainer();
        // WHEN
        container.register(InterfaceA.class, RealizationA.class);
        // THEN
        InterfaceA resolve1 = container.resolve(InterfaceA.class);
        InterfaceA resolve2 = container.resolve(InterfaceA.class);
        assertAll("Check method results",
                () -> assertEquals(resolve1.methodA1(), resolve2.methodA1()),
                () -> assertEquals(resolve1.methodA2(), resolve2.methodA2()),
                () -> assertNotEquals(resolve1.methodA1(), resolve2.methodA2())
        );
    }

    @Test
    @DisplayName("Should resolve instances of InterfaceA and InterfaceB correctly")
    public void IContainerTest3() {
        // GIVEN
        ISimpleContainer container = createContainer();
        // WHEN
        container.register(InterfaceA.class, RealizationA.class);
        container.register(InterfaceB.class, RealizationB.class);
        // THEN
        assertAll("Check resolved instances",
                () -> assertEquals(container.resolve(InterfaceB.class), container.resolve(InterfaceB.class)),
                () -> assertEquals(container.resolve(InterfaceB.class), container.resolve(InterfaceB.class)),
                () -> assertTrue(container.resolve(InterfaceA.class) instanceof RealizationA),
                () -> assertTrue(container.resolve(InterfaceB.class) instanceof RealizationB)
        );

    }

}