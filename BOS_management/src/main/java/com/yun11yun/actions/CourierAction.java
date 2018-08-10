package com.yun11yun.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yun11yun.domain.Courier;
import com.yun11yun.service.CourierService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@ParentPackage("json-default")
@Namespace("/")
@Actions
@Controller
@Scope("prototype")
public class CourierAction extends ActionSupport implements ModelDriven<Courier> {

    private Courier courier = new Courier();

    private int page;
    private int rows;

    @Autowired
    private CourierService courierService;

    public void setPage(int page) {
        this.page = page;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public Courier getModel() {
        return courier;
    }

    @Action(value = "courier_save",
            results = {
                @Result(name = "success",
                        type = "redirect",
                        location = "./pages/base/courier.html")
    })
    public String save() {
        System.out.println("save");
        this.courierService.save(this.courier);
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
        Page<Courier> page = this.courierService.queryPage(this.courier, this.page, this.rows);
        // 3. 封装成需要的json格式
        Map<String, Object> map = new HashMap <>();
        map.put("total", page.getTotalElements());
        map.put("rows", page.getContent());
        // 4. 压入值栈
        ActionContext.getContext().getValueStack().push(map);
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
