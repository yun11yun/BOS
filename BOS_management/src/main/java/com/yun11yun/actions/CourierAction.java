package com.yun11yun.actions;

import com.yun11yun.actions.common.BaseAction;
import com.yun11yun.domain.Courier;
import com.yun11yun.service.CourierService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

@ParentPackage("json-default")
@Namespace("/")
@Actions
@Controller
@Scope("prototype")
public class CourierAction extends BaseAction<Courier> {

    @Autowired
    private CourierService courierService;

    @Action(value = "courier_save",
            results = {
                @Result(name = "success",
                        type = "redirect",
                        location = "./pages/base/courier.html")
    })
    public String save() {
        System.out.println("save");
        this.courierService.save(this.model);
        return SUCCESS;
    }

    @Action(value = "courier_query",
            results = {@Result(
                    name = "success",
                    type = "json"
            )}
    )
    public String queryPage() {
        // 1. 获取查询参数
        // 2. 查询数据
        Page<Courier> page = this.courierService.queryPage(this.model, this.page, this.rows);
        // 3. 压入值栈
        pushDataToValueStack(page);
        return SUCCESS;
    }


    private String ids;

    public void setIds(String ids) {
        this.ids = ids;
    }

    @Action(value = "courier_delBatch",
            results = {
                    @Result(name = "success", type = "redirect", location = "./pages/base/courier.html")
            }
    )
    public String delBatch() {
        String[] idArray = ids.split(",");
        courierService.delBatch(idArray);
        return SUCCESS;
    }
}
