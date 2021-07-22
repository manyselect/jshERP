package com.jsh.erp.order.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jsh.erp.base.entity.Result;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.order.entity.WorkerOrder;
import com.jsh.erp.order.service.IWorkerOrderService;
import com.jsh.erp.service.user.UserService;
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

    @Autowired
    private UserService userService;

    @GetMapping("/getAllOrderList")
    public Result getAllOrderList(@RequestParam(value = Constants.PAGE_SIZE, required = false) Integer pageSize,
                                  @RequestParam(value = Constants.CURRENT_PAGE, required = false) Integer currentPage,
                                  HttpServletRequest request) throws Exception {






        return null;
    }

    @GetMapping("/getApprovers")
    public Result getApprovers(HttpServletRequest request) throws Exception {

        //获取当前这个人， todo:注意token和session的维护
        User user = userService.getCurrentUser();

        List<User> managers = userService.getManagers();

        JSONArray resultUsers = new JSONArray();

        managers.stream().forEach( m -> {
            JSONObject o = new JSONObject();
            o.put("name", m.getUsername());
            resultUsers.add(o);
        });

        return new Result().success(resultUsers);
    }


    @GetMapping("/getToApprOrders")
    public Result getToApprOrders(@RequestParam(value = Constants.PAGE_SIZE, required = false) Integer pageSize,
                                  @RequestParam(value = Constants.CURRENT_PAGE, required = false) Integer currentPage,
                                  HttpServletRequest request) throws Exception {

        //获取当前这个人， todo:注意token和session的维护
        User user = userService.getCurrentUser();

        //查审批单
        List<WorkerOrder> workerOrders = workerOrderServiceImpl.listApprovalOrdersByPage(user.getId(), currentPage, pageSize);

        return new Result().success(workerOrders);
    }

    @GetMapping("/getCCOrders")
    public Result getCCOrders(@RequestParam(value = Constants.PAGE_SIZE, required = false) Integer pageSize,
                              @RequestParam(value = Constants.CURRENT_PAGE, required = false) Integer currentPage,
                              HttpServletRequest request) throws Exception {

        //获取当前这个人， todo:注意token和session的维护
        User user = userService.getCurrentUser();

        //查审批单
        List<WorkerOrder> workerOrders = workerOrderServiceImpl.listCCOrdersByPage(user.getId(), currentPage, pageSize);

        return new Result().success(workerOrders);
    }

    @GetMapping("/getMyOrders")
    public Result getMyOrders(@RequestParam(value = Constants.PAGE_SIZE, required = false) Integer pageSize,
                              @RequestParam(value = Constants.CURRENT_PAGE, required = false) Integer currentPage,
                              HttpServletRequest request) throws Exception {

        //获取当前这个人， todo:注意token和session的维护
        User user = userService.getCurrentUser();

        //查审批单
        List<WorkerOrder> workerOrders = workerOrderServiceImpl.listCCOrdersByPage(user.getId(), currentPage, pageSize);

        return new Result().success(workerOrders);
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
