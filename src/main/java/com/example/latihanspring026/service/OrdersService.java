package com.example.latihanspring026.service;

import com.example.latihanspring026.model.OrderSegment;
import com.example.latihanspring026.model.Orders;
import com.example.latihanspring026.model.Result;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrdersService {
    private List<Orders> orders;

    @PostConstruct
    private void initialize() {
        orders = new ArrayList<>();
        orders.add(new Orders(1, "Rifqy Herdiyanto", new Date(), 2, 18000.0, 5000.0, 23000.0));
        orders.add(new Orders(2, "Putri Ramadani", new Date(), 1, 16000.0, 5000.0, 21000.0));
        orders.add(new Orders(3, "Samodra", new Date(), 1, 20000.0, 5000.0, 25000.0));
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public Orders getOrderById(int id) {
        for (Orders order : orders) {
            if (order.getIdOrder() == id) {
                return order;
            }
        }

        return null;
    }

    public Result addOrder(Orders order) {
        if (order == null) {
            return new Result(500, "Tambah data gagal.");
        }

        orders.add(order);

        return new Result(200, "Tambah data berhasil.");
    }

    public Result updateOrder(Orders order) {
        int orderId = order.getIdOrder();
        Orders orderById = getOrderById(orderId);

        if (orderById == null) {
            return new Result(500, "Ubah data gagal! Data tidak ditemukan.");
        }

        int index = orders.indexOf(orderById);

        orders.set(index, order);

        return new Result(200, "Ubah data berhasil.");
    }


    public Result updateOrder(int id, double orderBill, int orderCount) {
        Orders order = getOrderById(id);

        if (order == null) {
            return new Result(500, "Data order tidak ditemukan.");
        }

        order.setOrderBill(orderBill);
        order.setOrderCount(orderCount);
        order.setOrderTotal(order.getOrderBill() + order.getOrderDelivery());

        updateOrder(order);

        return new Result(200, "Ubah data berhasil.");
    }

    public Result deleteOrder(int id) {
        Orders orderById = getOrderById(id);

        if (orderById == null) {
            return new Result(500, "Hapus data gagal! Data tidak ditemukan.");
        }

        orders.remove(orderById);

        return new Result(200, "Hapus data berhasil.");
    }

    public Result deleteOrderSegment(OrderSegment orderSegment) {
        if (orderSegment == null) {
            return new Result(500, "Hapus data gagal. Order Segment tidak ditemukan.");
        }

        Orders order = getOrderById(orderSegment.getIdOrder());

        if (order == null) {
            return new Result(500, "Data order tidak ditemukan.");
        }

        order.setOrderBill(order.getOrderBill() - orderSegment.getOsPrice());
        order.setOrderCount(order.getIdOrder() - 1);
        order.setOrderTotal(order.getOrderBill() + order.getOrderDelivery());

        updateOrder(order);

        return new Result(200, "Ubah data berhasil.");
    }
}
