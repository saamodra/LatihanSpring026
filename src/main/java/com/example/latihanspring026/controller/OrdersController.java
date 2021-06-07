package com.example.latihanspring026.controller;

import com.example.latihanspring026.model.Menu;
import com.example.latihanspring026.model.OrderSegment;
import com.example.latihanspring026.model.Orders;
import com.example.latihanspring026.service.MenuService;
import com.example.latihanspring026.service.OrderSegmentService;
import com.example.latihanspring026.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    OrdersService orderService;

    @Autowired
    MenuService menuService;

    @Autowired
    OrderSegmentService orderSegmentService;

    @GetMapping("/orders")
    public String index(Model model) {
        model.addAttribute("orders", orderService.getOrders());
        return "/orders/index";
    }

    @GetMapping("/orders/tambah")
    public String add(Model model) {
        model.addAttribute("orders", new Orders());
        return "/orders/add";
    }

    @PostMapping("/orders/tambah")
    public String store(Orders orders, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/orders/add";
        }

        // set ID menu sesuai dengan id terakhir ditambah 1
        orders.setIdOrder(orderService.getLastData().getIdOrder() + 1);
//        Date a = orders.getOrderDate();
//        orders.setOrderDate(a);
        orderService.addOrder(orders);

        return "redirect:/orders";
    }

    @GetMapping("/orders/view/{id}")
    public String view(@PathVariable int id, Model model) {
        Orders order = orderService.getOrderById(id);
        OrderSegment orderSegment = new OrderSegment();
        orderSegment.setIdOrder(order.getIdOrder());

        model.addAttribute("order", order);
        model.addAttribute("ordersegment", orderSegment);
        return "/orders/view";
    }

    @GetMapping("/orders/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Orders order = orderService.getOrderById(id);

        model.addAttribute("order", order);

        List<OrderSegment> myOrder = orderSegmentService.getOrderSegmentsByIdOrder(order.getIdOrder());

        model.addAttribute("orderSegments", myOrder);
        return "/orders/detail";
    }
}
