package sg01.common.api.di.test;

public class RealizationAMultiConstructor implements InterfaceA {

    public RealizationAMultiConstructor() {}
    public RealizationAMultiConstructor(InterfaceB someValue) {}

    @Override
    public String methodA1() {
        return "methodA1";
    }

    @Override
    public String methodA2() {
        return "methodA2";
    }

}
