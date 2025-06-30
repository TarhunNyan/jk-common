package sg01.common.api.di.test;

import lombok.NoArgsConstructor;

public class RealizationBRequireA implements InterfaceB {

    public RealizationBRequireA(InterfaceA someValue) {}

    @Override
    public String methodB1() {
        return "methodB1";
    }

    @Override
    public String methodB2() {
        return "methodB2";
    }

}
