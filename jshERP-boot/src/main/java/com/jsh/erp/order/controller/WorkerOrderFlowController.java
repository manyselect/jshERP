package com.jsh.erp.order.controller;


import com.jsh.erp.base.entity.Result;
import com.jsh.erp.utils.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Li Jinhui
 * @since 2021-07-20
 */
@RestController
@RequestMapping("/order/worker-order-flow")
public class WorkerOrderFlowController {

    @GetMapping("/getOrderFlow")
    public Result getOrderFlows(@RequestParam(value = Constants.PAGE_SIZE, required = false) Integer pageSize,
                                @RequestParam(value = Constants.CURRENT_PAGE, required = false) Integer currentPage,
                                @RequestParam String userid,
                                @RequestParam String orderid,
                                HttpServletRequest request) throws Exception {


        return null;
    }
}
