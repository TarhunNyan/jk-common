package sg01.common.wrapper.test;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RealizationA implements InterfaceA {

    @Override
    public String methodA1() {
        return "methodA1";
    }

    @Override
    public String methodA2() {
        return "methodA2";
    }

}
