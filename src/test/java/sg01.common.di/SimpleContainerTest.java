package sg01.common.di;

import sg01.common.api.di.IContainerTest;
import sg01.common.api.di.ISimpleContainer;

public class SimpleContainerTest extends IContainerTest{

    @Override
    public ISimpleContainer createContainer() {
        return new SimpleContainer(new CreateInstance());
    }

}
