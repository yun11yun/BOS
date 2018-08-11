package com.yun11yun.actions;

import com.opensymphony.xwork2.ActionContext;
import com.yun11yun.actions.common.BaseAction;
import com.yun11yun.domain.Area;
import com.yun11yun.service.AreaService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParentPackage("json-default")
@Namespace("/")
@Actions
@Controller
@Scope("prototype")
public class AreaAction extends BaseAction<Area> {

    private File file;
    private String fileFileName;

    public void setFile(File file) {
        this.file = file;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    @Autowired
    private AreaService areaService;

    @Action(value = "area_add",
            results = {@Result(
                    name = "success",
                    type = "redirect",
                    location = "./pages/base/area.html"
            )}
    )
    public String save() {
        this.areaService.save(this.model);
        return SUCCESS;
    }

    @Action(value = "area_findPage",
            results = {@Result(
                    name = "success",
                    type = "json"
            )}
    )
    public String findByPage() {
        Page<Area> result = this.areaService.findByPage(this.model, this.page, this.rows);
        pushDataToValueStack(result);
        return SUCCESS;
    }

    @Action(value = "area_batchImport",
            results = {@Result(
                    name = "error",
                    type = "json"
            )}
    )
    public String batchImport() throws IOException {

        // 验证文件
        if (!fileFileName.endsWith(".xls") && !fileFileName.endsWith(".xlsx")) {
            Map<String, Object> map = new HashMap <>();
            map.put("errMsg", "文件格式错误");
            ActionContext.getContext().getValueStack().push(map);
            return ERROR;
        }

        List<Area> list = new ArrayList <>();
        // 根据文件名生成excel解析对象
        Workbook workbook = null;
        if (this.fileFileName.endsWith(".xls")) {
            workbook = new HSSFWorkbook(new FileInputStream(file));
        } else {
            workbook = new XSSFWorkbook(new FileInputStream(file));
        }
        // 解析文件
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            // 跳过第一行和空行
            if (row.getRowNum() == 0
                    || row.getCell(0) == null
                    || StringUtils.isBlank(row.getCell(0).getStringCellValue())) {
                continue;
            }

            Area area = new Area();
            area.setId(row.getCell(0).getStringCellValue());
            area.setProvince(row.getCell(1).getStringCellValue());
            area.setCity(row.getCell(2).getStringCellValue());
            area.setDistrict(row.getCell(3).getStringCellValue());
            area.setPostcode(row.getCell(4).getStringCellValue());

            list.add(area);
        }

        areaService.saveBatch(list);

        return NONE;
    }
}
