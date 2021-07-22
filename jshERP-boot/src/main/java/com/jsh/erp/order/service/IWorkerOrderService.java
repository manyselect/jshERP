package com.jsh.erp.order.service;

import com.jsh.erp.order.entity.WorkerOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Li Jinhui
 * @since 2021-07-20
 */
public interface IWorkerOrderService extends IService<WorkerOrder> {

    List<WorkerOrder> listApprovalOrdersByPage(Long userid, int currentPage, int pageSize);

    List<WorkerOrder> listCCOrdersByPage(Long userid, int currentPage, int pageSize);

    List<WorkerOrder> listMyOrdersByPage(Long userid, int currentPage, int pageSize);

}
