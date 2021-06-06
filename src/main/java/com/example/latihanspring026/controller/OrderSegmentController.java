package com.example.latihanspring026.controller;

import com.example.latihanspring026.model.OrderSegment;
import com.example.latihanspring026.model.Result;
import com.example.latihanspring026.service.OrderSegmentService;
import com.example.latihanspring026.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class OrderSegmentController {
    @Autowired
    OrderSegmentService orderSegmentService;

    @Autowired
    OrdersService ordersService;

    @GetMapping("/order-segments")
    public String getOrderSegment() {
//        model.addAttribute("orderSegments", orderSegmentService.getOrderSegment());
        return "/dashboard.html";
    }

    @GetMapping("/order-segment")
    public Object getOrderSegment(@RequestParam("id") int id) {
        OrderSegment order = orderSegmentService.getOrderSegmentById(id);

        if (order == null) {
            return new Result(500, "Data tidak ditemukan.");
        }

        return order;
    }

    @GetMapping("/order-segment/orders")
    public Object getOrders(@RequestParam("id") int id) {
        List<OrderSegment> orders = orderSegmentService.getOrderSegmentsByIdOrder(id);

        if (orders == null) {
            return new Result(500, "Data tidak ditemukan.");
        }

        return orders;
    }

    private Result updateOrder(int idOrder) {
        // ambil data orders untuk menghitung ulang orderBill berdasarkan idOrder
        List<OrderSegment> orders = orderSegmentService.getOrderSegmentsByIdOrder(idOrder);

        // ambil sum dari osPrice pada orderSegment (orders)
        double orderBill = orders.stream().mapToDouble(OrderSegment::getOsPrice).sum();
        // ambil ordercount berdasarkan jumlah orderSegment
        int orderCount = orders.size();

        return ordersService.updateOrder(idOrder, orderBill, orderCount);
    }

    @PostMapping("/order-segment")
    public Object saveOrderSegment(HttpServletResponse response, @RequestBody OrderSegment orderSegment) {
        Result addOrderSegment = orderSegmentService.addOrderSegment(orderSegment);

        if (addOrderSegment.getStatus() == 500) {
            return addOrderSegment;
        }

        return updateOrder(orderSegment.getIdOrder());
    }

    @PutMapping("/order-segment")
    public Object updateOrderSegment(HttpServletResponse response, @RequestBody OrderSegment orderSegment) {
        Result updateOrderSegment = orderSegmentService.updateOrderSegment(orderSegment);

        if (updateOrderSegment.getStatus() == 500) {
            return updateOrderSegment;
        }

        return updateOrder(orderSegment.getIdOrder());
    }

    @DeleteMapping("/order-segment")
    public Object deleteOrderSegment(HttpServletResponse response, @RequestParam("id") int id) {
        OrderSegment orderSegment = orderSegmentService.getOrderSegmentById(id);
        Result deleteOrderSegment = orderSegmentService.deleteOrderSegment(id);

        if (deleteOrderSegment.getStatus() == 500) {
            return deleteOrderSegment;
        }

        return updateOrder(orderSegment.getIdOrder());
    }
}
