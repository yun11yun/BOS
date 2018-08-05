package com.yun11yun.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.yun11yun.domain.User;
import com.yun11yun.service.UserService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/user")
@Results(
        @Result(name = "jsonList", type = "json", params = {"root", "userList"})
)
public class UserAction extends ActionSupport {

    @Autowired
    private UserService userService;

    private List<User> userList = new ArrayList <>();

    @Action(value = "all")
    public String getAll() {
        userList = userService.getAll();
        return "jsonList";
    }

    public List <User> getUserList() {
        return userList;
    }
}
