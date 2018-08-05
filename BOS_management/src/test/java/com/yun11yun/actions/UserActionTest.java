package com.yun11yun.actions;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

public class UserActionTest extends ActionBaseTestCase {

    public void testGetActionMapping() {
        ActionMapping mapping = getActionMapping("/user/all.action");
        assertNotNull(mapping);
        assertEquals("/user", mapping.getNamespace());
        assertEquals("all", mapping.getName());
    }

    public void testGetAll() throws Exception {
        ActionProxy actionProxy = getActionProxy("/user/all.action");
        UserAction action = (UserAction) actionProxy.getAction();

        String result = action.getAll();
        assertEquals("jsonList", result);
        assertTrue(action.getUserList().size() > 0);
    }
}