package com.tjetc.service;



import com.tjetc.entity.TJob;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-11-06
 */
public interface ITJobService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param jId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TJob selectTJobByJId(Long jId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tJob 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TJob> selectTJobList(TJob tJob);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tJob 【请填写功能名称】
     * @return 结果
     */
    public int insertTJob(TJob tJob);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tJob 【请填写功能名称】
     * @return 结果
     */
    public int updateTJob(TJob tJob);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param jIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTJobByJIds(Long[] jIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param jId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTJobByJId(Long jId);
}
