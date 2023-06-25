package com.ruoyi.system.service;

import com.ruoyi.system.domain.CountDown;

import java.util.List;

/**
 * 倒计时Service接口
 *
 * @author zhangy
 * @date 2023-06-25
 */
public interface ICountDownService {
    /**
     * 查询倒计时
     *
     * @param id 倒计时主键
     * @return 倒计时
     */
    CountDown selectCountDownById(Long id);

    /**
     * 查询倒计时列表
     *
     * @param countDown 倒计时
     * @return 倒计时集合
     */
    List<CountDown> selectCountDownList(CountDown countDown);

    /**
     * 新增倒计时
     *
     * @param countDown 倒计时
     * @return 结果
     */
    int insertCountDown(CountDown countDown);

    /**
     * 修改倒计时
     *
     * @param countDown 倒计时
     * @return 结果
     */
    int updateCountDown(CountDown countDown);

    /**
     * 批量删除倒计时
     *
     * @param ids 需要删除的倒计时主键集合
     * @return 结果
     */
    int deleteCountDownByIds(String ids);

    /**
     * 删除倒计时信息
     *
     * @param id 倒计时主键
     * @return 结果
     */
    int deleteCountDownById(Long id);
}
