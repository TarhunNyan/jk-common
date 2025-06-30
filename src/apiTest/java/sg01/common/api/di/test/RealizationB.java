package sg01.common.api.di.test;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RealizationB implements InterfaceB {

    @Override
    public String methodB1() {
        return "methodB1";
    }

    @Override
    public String methodB2() {
        return "methodB2";
    }

}
