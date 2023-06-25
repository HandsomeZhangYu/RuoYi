package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 倒计时对象 count_down
 *
 * @author zhangy
 * @date 2023-06-25
 */
@Data
public class CountDown extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long id;

    /**
     * 倒计时名称
     */
    @Excel(name = "倒计时名称")
    private String name;

    /**
     * 倒计时开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "倒计时开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 倒计时天数
     */
    @Excel(name = "倒计时天数")
    private Integer countDownDay;
}
