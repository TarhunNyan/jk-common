package sg01.common.wrapper.test;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RealizationB implements InterfaceA {

    @Override
    public String methodA1() {
        return "realizationB: methodA1";
    }

    @Override
    public String methodA2() {
        return "realizationB: methodA2";
    }

}
