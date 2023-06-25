package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.CountDown;
import com.ruoyi.system.mapper.CountDownMapper;
import com.ruoyi.system.service.ICountDownService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 倒计时Service业务层处理
 *
 * @author zhangy
 * @date 2023-06-25
 */
@Service
public class CountDownServiceImpl implements ICountDownService {
    @Resource
    private CountDownMapper countDownMapper;

    /**
     * 查询倒计时
     *
     * @param id 倒计时主键
     * @return 倒计时
     */
    @Override
    public CountDown selectCountDownById(Long id) {
        return countDownMapper.selectCountDownById(id);
    }

    /**
     * 查询倒计时列表
     *
     * @param countDown 倒计时
     * @return 倒计时
     */
    @Override
    public List<CountDown> selectCountDownList(CountDown countDown) {
        return countDownMapper.selectCountDownList(countDown);
    }

    /**
     * 新增倒计时
     *
     * @param countDown 倒计时
     * @return 结果
     */
    @Override
    public int insertCountDown(CountDown countDown) {
        return countDownMapper.insertCountDown(countDown);
    }

    /**
     * 修改倒计时
     *
     * @param countDown 倒计时
     * @return 结果
     */
    @Override
    public int updateCountDown(CountDown countDown) {
        return countDownMapper.updateCountDown(countDown);
    }

    /**
     * 批量删除倒计时
     *
     * @param ids 需要删除的倒计时主键
     * @return 结果
     */
    @Override
    public int deleteCountDownByIds(String ids) {
        return countDownMapper.deleteCountDownByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除倒计时信息
     *
     * @param id 倒计时主键
     * @return 结果
     */
    @Override
    public int deleteCountDownById(Long id) {
        return countDownMapper.deleteCountDownById(id);
    }
}
