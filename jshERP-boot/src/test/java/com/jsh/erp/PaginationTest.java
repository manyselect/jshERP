package com.jsh.erp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jsh.erp.datasource.mappers.WorkerOrderMapper;
import com.jsh.erp.order.entity.WorkerOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ErpApplication.class)
public class PaginationTest {

    private static final Logger LOG = LoggerFactory.getLogger(PaginationTest.class);

    @Autowired
    private WorkerOrderMapper workerOrderMapper;

    @Test
    public void test01() {

        LOG.error("----------------------------------baseMapper 自带分页-------------------------------------------------------");

        Page<WorkerOrder> page = new Page<>(1, 2);
        page.setDesc("create_time");
        IPage<WorkerOrder> workerOrdersPage = workerOrderMapper
                .selectPage(page, Wrappers.<WorkerOrder>lambdaQuery().eq(WorkerOrder::getOrderApprovalUser, 11l));


        workerOrdersPage.getRecords().stream().forEach(
                w -> LOG.error(w.toString()));

    }
}
