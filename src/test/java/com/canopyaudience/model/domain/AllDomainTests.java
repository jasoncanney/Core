package com.canopyaudience.model.domain;

import com.canopyaudience.model.domain.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
 /** runs all domain level classes in this suite */
@RunWith(Suite.class)
@SuiteClasses({ advertisementTest.class, consumerTest.class, consumerHistoryTest.class, couponTest.class, loginTest.class, myadsTest.class, preferenceTest.class})
public class AllDomainTests {

}
