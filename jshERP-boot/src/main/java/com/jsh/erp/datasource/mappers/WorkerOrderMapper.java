package com.jsh.erp.datasource.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jsh.erp.order.entity.WorkerOrder;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Li Jinhui
 * @since 2021-07-20
 */

public interface WorkerOrderMapper extends BaseMapper<WorkerOrder> {

    List<WorkerOrder> iPageSelect(IPage<WorkerOrder> myPage);

}
