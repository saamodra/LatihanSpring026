package com.example.latihanspring026.controller.api;

import com.example.latihanspring026.model.Orders;
import com.example.latihanspring026.model.Result;
import com.example.latihanspring026.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class OrderApiController {
    @Autowired
    OrdersService orderService;

    @GetMapping("/orders")
    public List<Orders> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/order")
    public Object getOrder(@RequestParam("id") int id) {
        Orders order = orderService.getOrderById(id);

        if (order == null) {
            return new Result(500, "Data tidak ditemukan.");
        }

        return order;
    }

    @PostMapping("/order")
    public Object saveOrder(HttpServletResponse response, @RequestBody Orders order) {
        return orderService.addOrder(order);
    }

    @PutMapping("/order")
    public Object updateOrder(HttpServletResponse response, @RequestBody Orders order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/order")
    public Object deleteOrder(HttpServletResponse response, @RequestParam("id") int id) {
        return orderService.deleteOrder(id);
    }
}
