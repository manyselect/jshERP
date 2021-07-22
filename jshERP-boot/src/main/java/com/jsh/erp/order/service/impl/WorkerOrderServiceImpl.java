package com.jsh.erp.order.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jsh.erp.order.entity.WorkerOrder;
import com.jsh.erp.datasource.mappers.WorkerOrderMapper;
import com.jsh.erp.order.service.IWorkerOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Li Jinhui
 * @since 2021-07-20
 */
@Service
public class WorkerOrderServiceImpl extends ServiceImpl<WorkerOrderMapper, WorkerOrder> implements IWorkerOrderService {

    private static final Logger LOG = LoggerFactory.getLogger(WorkerOrderServiceImpl.class);

    @Autowired
    private WorkerOrderMapper workerOrderMapper;


    public List<WorkerOrder> listApprovalOrdersByPage(Long userid, int currentPage, int pageSize) {

        if (pageSize < 1) {
            pageSize = 10;
        }

        if (currentPage < 1) {
            currentPage = 1;
        }

        Page<WorkerOrder> page = new Page<>(currentPage, pageSize);
        page.setDesc("create_time");
        IPage<WorkerOrder> workerOrdersPage = workerOrderMapper
                .selectPage(page, Wrappers.<WorkerOrder>lambdaQuery().eq(WorkerOrder::getOrderApprovalUser, userid));

        return workerOrdersPage.getRecords();
    }

    @Override
    public List<WorkerOrder> listCCOrdersByPage(Long userid, int currentPage, int pageSize) {
        if (pageSize < 1) {
            pageSize = 10;
        }

        if (currentPage < 1) {
            currentPage = 1;
        }

        Page<WorkerOrder> page = new Page<>(currentPage, pageSize);
        page.setDesc("create_time");
        IPage<WorkerOrder> workerOrdersPage = workerOrderMapper
                .selectPage(page, Wrappers.<WorkerOrder>lambdaQuery().eq(WorkerOrder::getOrderCcUser, userid));


        return workerOrdersPage.getRecords();
    }

    @Override
    public List<WorkerOrder> listMyOrdersByPage(Long userid, int currentPage, int pageSize) {
        if (pageSize < 1) {
            pageSize = 10;
        }

        if (currentPage < 1) {
            currentPage = 1;
        }

        Page<WorkerOrder> page = new Page<>(currentPage, pageSize);
        page.setDesc("create_time");
        IPage<WorkerOrder> workerOrdersPage = workerOrderMapper
                .selectPage(page, Wrappers.<WorkerOrder>lambdaQuery().eq(WorkerOrder::getApplyUser, userid));

        return workerOrdersPage.getRecords();

    }
}
