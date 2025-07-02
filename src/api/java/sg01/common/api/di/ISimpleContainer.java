package sg01.common.api.di;

import sg01.common.api.di.isp.IHaveRegister;
import sg01.common.api.di.isp.IHaveResolve;

/**
 * EFP-1: [container]
 */
public interface ISimpleContainer extends IContainer, IHaveRegister, IHaveResolve {

}
