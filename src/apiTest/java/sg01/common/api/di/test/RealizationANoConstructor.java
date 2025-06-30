package sg01.common.api.di.test;

public class RealizationANoConstructor implements InterfaceA {

    private RealizationANoConstructor() {}

    @Override
    public String methodA1() {
        return "methodA1";
    }

    @Override
    public String methodA2() {
        return "methodA2";
    }

}
