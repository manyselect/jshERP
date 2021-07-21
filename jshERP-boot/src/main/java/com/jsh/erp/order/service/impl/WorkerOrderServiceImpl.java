package com.jsh.erp.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jsh.erp.order.entity.WorkerOrder;
import com.jsh.erp.datasource.mappers.WorkerOrderMapper;
import com.jsh.erp.order.service.IWorkerOrderService;
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

    @Autowired
    private WorkerOrderMapper workerOrderMapper;


    public List<WorkerOrder> listOrdersByPage() {



        return null;
    }

}
