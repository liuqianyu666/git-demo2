package com.tjetc.service.impl;


import com.tjetc.dao.TJobMapper;
import com.tjetc.entity.TJob;
import com.tjetc.service.ITJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-11-06
 */
@Service
public class TJobServiceImpl implements ITJobService
{
    @Autowired
    private TJobMapper tJobMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param jId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TJob selectTJobByJId(Long jId)
    {
        return tJobMapper.selectTJobByJId(jId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tJob 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TJob> selectTJobList(TJob tJob)
    {
        return tJobMapper.selectTJobList(tJob);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tJob 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTJob(TJob tJob)
    {
        return tJobMapper.insertTJob(tJob);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tJob 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTJob(TJob tJob)
    {
        return tJobMapper.updateTJob(tJob);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param jIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTJobByJIds(Long[] jIds)
    {
        return tJobMapper.deleteTJobByJIds(jIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param jId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTJobByJId(Long jId)
    {
        return tJobMapper.deleteTJobByJId(jId);
    }
}
