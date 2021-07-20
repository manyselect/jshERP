package com.jsh.erp.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Li Jinhui
 * @since 2021-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("worker_order_flow")
public class WorkerOrderFlow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 之前订单的状态
     */
    private String oriStatus;

    /**
     * 目前订单的状态
     */
    private String curStatus;

    /**
     * 更新id
     */
    private Long updater;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
