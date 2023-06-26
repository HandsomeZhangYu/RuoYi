package com.ruoyi.web.controller.countdown;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.CountDown;
import com.ruoyi.system.service.ICountDownService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 倒计时Controller
 *
 * @author zhangy
 * @date 2023-06-25
 */
@Controller
@RequestMapping("/count/down")
public class CountDownController extends BaseController {
    private String prefix = "system/countdown";

    @Autowired
    private ICountDownService countDownService;

    @GetMapping()
    public String countDown() {
        return prefix + "/countdown";
    }

    /**
     * 查询倒计时列表
     */
    @PostMapping("/list")
    @ResponseBody
    @RequiresPermissions("countdown:list")
    public TableDataInfo list(CountDown countDown) {
        startPage();
        List<CountDown> list = countDownService.selectCountDownList(countDown);
        return getDataTable(list);
    }

    /**
     * 导出倒计时列表
     */
    @Log(title = "倒计时", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @RequiresPermissions("countdown:export")
    public AjaxResult export(CountDown countDown) {
        List<CountDown> list = countDownService.selectCountDownList(countDown);
        ExcelUtil<CountDown> util = new ExcelUtil<CountDown>(CountDown.class);
        return util.exportExcel(list, "倒计时数据");
    }

    /**
     * 新增倒计时
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存倒计时
     */
    @Log(title = "倒计时", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @RequiresPermissions("countdown:add")
    public AjaxResult addSave(CountDown countDown) {
        return toAjax(countDownService.insertCountDown(countDown));
    }

    /**
     * 修改倒计时
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("countdown:edit")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        CountDown countDown = countDownService.selectCountDownById(id);
        mmap.put("countDown", countDown);
        return prefix + "/edit";
    }

    /**
     * 修改保存倒计时
     */
    @Log(title = "倒计时", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    @RequiresPermissions("countdown:edit")
    public AjaxResult editSave(CountDown countDown) {
        return toAjax(countDownService.updateCountDown(countDown));
    }

    /**
     * 删除倒计时
     */
    @Log(title = "倒计时", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("countdown:delete")
    public AjaxResult remove(String ids) {
        return toAjax(countDownService.deleteCountDownByIds(ids));
    }
}
