package com.tjetc.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.common.JsonResult;
import com.tjetc.common.TableDataInfo;
import com.tjetc.entity.TJob;
import com.tjetc.entity.User;
import com.tjetc.service.ITJobService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2023-11-06
 */
@RestController
@RequestMapping("/job")
public class TJobController
{
    @Autowired
    private ITJobService tJobService;

    /**
     * 查询【请填写功能名称】列表
     */
    @GetMapping("/list")
    public TableDataInfo list(TJob tJob)
    {
        PageHelper.startPage(1,10);
        List<TJob> list = tJobService.selectTJobList(tJob);
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{jId}")
    public JsonResult getInfo(@PathVariable("jId") Long jId)
    {
        TJob tJob = tJobService.selectTJobByJId(jId);
        return new JsonResult(0,"查看成功",tJob);
    }

    /**
     * 新增【请填写功能名称】
     */
    @PostMapping
    public JsonResult add(TJob tJob)
    {
        int i = tJobService.insertTJob(tJob);
        return new JsonResult(0,"查看成功",i);
    }

    /**
     * 修改【请填写功能名称】
     */
    @PostMapping("update")
    public JsonResult edit( TJob tJob)
    {
        int i = tJobService.updateTJob(tJob);
        if (i != 0){
            return new JsonResult(0,"修改成功",i);
        }else {
            return new JsonResult(1,"修改失败",i);
        }
    }

    /**
     * 删除【请填写功能名称】
     */
	@DeleteMapping("/{jIds}")
    public JsonResult remove(@PathVariable Long[] jIds)
    {
        int i = tJobService.deleteTJobByJIds(jIds);
        return new JsonResult(0,"查看成功",i);
    }
}
