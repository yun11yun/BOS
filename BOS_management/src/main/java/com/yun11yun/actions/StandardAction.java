package com.yun11yun.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yun11yun.actions.common.BaseAction;
import com.yun11yun.domain.Standard;
import com.yun11yun.service.StandardService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParentPackage("json-default")
@Namespace("/")
@Controller
@Scope("prototype")
public class StandardAction extends BaseAction<Standard> {

    @Autowired
    private StandardService standardService;

    public void setStandardService(StandardService standardService) {
        this.standardService = standardService;
    }

    @Action(value = "standard_save",
            results = {
                @Result(name = "success",
                        type = "redirect",
                        location = "pages/base/standard.html")
    })
    public String save() {
        standardService.save(this.model);
        return SUCCESS;
    }


    @Action(value = "standard_findByPage",
            results = {
                @Result(name = "success",
                        type = "json"
                )
            }
    )
    public String queryPage() {
        // 1. 接受page和rows
        System.out.println(rows);
        System.out.println(page);
        
        // 2. 查询数据
        Page<Standard> page = standardService.findByPage(this.page, this.rows);

        // 3. 将结果压入值栈
        pushDataToValueStack(page);

        return SUCCESS;
    }

    @Action(value = "standard_findAll",
            results = {
                @Result(name = "success", type = "json")
            }
    )
    public String findAll() {
        List<Standard> list = this.standardService.findAll();
        ActionContext.getContext().getValueStack().push(list);
        return SUCCESS;
    }
}
