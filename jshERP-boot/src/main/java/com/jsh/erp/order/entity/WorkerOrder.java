package com.jsh.erp.order.entity;

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
public class WorkerOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工单id
     */
    private String orderId;
    /**
     * 申请人id
     */
    private Long applyUser;

    /**
     * 申请人姓名
     */
    private String applyUserName;
    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 子单id
     */
    private Integer itemOrderId;

    /**
     * 审批人id
     */
    private Long orderApprovalUser;

    /**
     * 订单抄送人id
     */
    private Long orderCcUser;

    /**
     * 目前订单的状态
     */
    private String curStatus;

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
