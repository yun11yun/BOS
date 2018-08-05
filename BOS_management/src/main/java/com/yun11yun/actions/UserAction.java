package com.yun11yun.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.yun11yun.domain.User;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/user")
@Results(
        @Result(name = "success", type = "json", params = {"root", "userList"})
)
public class UserAction extends ActionSupport{

    private List<User> list = new ArrayList <>();

    @Action(value = "all")
    public String getAll() {
        return SUCCESS;
    }

}
