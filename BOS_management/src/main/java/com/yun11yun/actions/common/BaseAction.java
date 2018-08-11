package com.yun11yun.actions.common;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.data.domain.Page;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

    protected T model;
    protected int page;
    protected int rows;

    @Override
    public T getModel() {
        return model;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public BaseAction() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class modelClass = (Class) params[0];
        try {
            model = (T) modelClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void pushDataToValueStack(Page<T> page) {
        Map<String, Object> map = new HashMap <>();
        map.put("total", page.getTotalElements());
        map.put("rows", page.getContent());

        ActionContext.getContext().getValueStack().push(map);
    }
}
