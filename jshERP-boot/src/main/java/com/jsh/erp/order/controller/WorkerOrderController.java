package com.jsh.erp.order.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jsh.erp.base.entity.Result;
import com.jsh.erp.order.entity.WorkerOrder;
import com.jsh.erp.order.service.IWorkerOrderService;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.ParamUtils;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Li Jinhui
 * @since 2021-07-20
 */
@RestController
@RequestMapping("/order/worker-order")
public class WorkerOrderController {

    @Autowired
    private IWorkerOrderService workerOrderServiceImpl;

    @GetMapping("/getAllOrderList")
    public Result getAllOrderList(@RequestParam(value = Constants.PAGE_SIZE, required = false) Integer pageSize,
                                  @RequestParam(value = Constants.CURRENT_PAGE, required = false) Integer currentPage,
                                  @RequestParam String userid,
                                  HttpServletRequest request) throws Exception {


        return null;
    }


    @GetMapping("/getToApprOrders")
    public Result getToApprOrders(@RequestParam(value = Constants.PAGE_SIZE, required = false) Integer pageSize,
                                  @RequestParam(value = Constants.CURRENT_PAGE, required = false) Integer currentPage,
                                  @RequestParam String userid,
                                  HttpServletRequest request) throws Exception {

        Map<String, String> parameterMap = ParamUtils.requestToMap(request);


        if (pageSize != null && pageSize <= 0) {
            pageSize = 10;
        }
        String offset = ParamUtils.getPageOffset(currentPage, pageSize);
        if (StringUtil.isNotEmpty(offset)) {
            parameterMap.put(Constants.OFFSET, offset);
        }
        if (currentPage == null || currentPage < 0) {
            currentPage = 0;
        }
        parameterMap.put(Constants.CURRENT_PAGE, String.valueOf(currentPage));

        parameterMap.put(Constants.PAGE_SIZE, String.valueOf(pageSize));

        String offsetStr = Integer.valueOf(offset) > 0 ? ", " + QueryUtils.offset(parameterMap) : "";
        QueryWrapper<WorkerOrder> wrapper = new QueryWrapper<WorkerOrder>().select("apply_user", "order_type",
                "order_cc_user", "create_time", "update_time")
                .eq("order_approval_user", userid)
                .orderByDesc("create_time")
                .last(" limit " + QueryUtils.rows(parameterMap) + offsetStr);

        List<WorkerOrder> list = this.workerOrderServiceImpl.list(wrapper);


        return new Result().success(list);
    }

    @GetMapping("/getCCOrders")
    public Result getCCOrders(@RequestParam(value = Constants.PAGE_SIZE, required = false) Integer pageSize,
                              @RequestParam(value = Constants.CURRENT_PAGE, required = false) Integer currentPage,
                              @RequestParam String userid,
                              HttpServletRequest request) throws Exception {


        return null;
    }

    @GetMapping("/getMyOrders")
    public Result getMyOrders(@RequestParam(value = Constants.PAGE_SIZE, required = false) Integer pageSize,
                              @RequestParam(value = Constants.CURRENT_PAGE, required = false) Integer currentPage,
                              @RequestParam String userid,
                              HttpServletRequest request) throws Exception {


        return null;
    }

    @PostMapping("/create")
    public Result postOrder(@RequestBody JSONObject params, HttpServletRequest request) {

        //user, ordertype; order_content {}, tanent_id, appr_user, cc_user

        if (params != null) {


        }


        return null;
    }

    @PostMapping("/update")
    public Result updateOrder(@RequestBody JSONObject params, HttpServletRequest request) {

        //user, ordertype; order_content {}, tanent_id, appr_user, cc_user

        if (params != null) {


        }


        return null;
    }


}
