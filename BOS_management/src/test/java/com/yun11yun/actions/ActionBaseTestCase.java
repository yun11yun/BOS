package com.yun11yun.actions;

import org.apache.struts2.StrutsSpringTestCase;

public class ActionBaseTestCase extends StrutsSpringTestCase {

    @Override
    protected String[] getContextLocations() {
        String[] locations = {"classpath*:applicationContext*.xml"};
        return locations;
    }
}
