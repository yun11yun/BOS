package com.yun11yun.actions;

import org.apache.struts2.StrutsSpringTestCase;

public class ActionBaseTestCase extends StrutsSpringTestCase {
    @Override
    protected String[] getContextLocations() {
        String[] contexts = {"classpath*:applicationContext*.xml"};
        return contexts;
    }
}
