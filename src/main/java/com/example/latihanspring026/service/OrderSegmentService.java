package com.example.latihanspring026.service;

import com.example.latihanspring026.model.Menu;
import com.example.latihanspring026.model.OrderSegment;
import com.example.latihanspring026.model.Orders;
import com.example.latihanspring026.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderSegmentService {
    private List<OrderSegment> orderSegments;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private MenuService menuService;


    @PostConstruct
    private void initialize() {
        orderSegments = new ArrayList<>();
        List<Menu> menuList = menuService.getMenus();
        List<Orders> orderList = ordersService.getOrders();

        orderSegments.add(new OrderSegment(1, 1, 1, 1, 10000.0, "Pedas"));
        orderSegments.get(0).setMenu(menuList.get(0));
        orderSegments.get(0).setOrder(orderList.get(0));

        orderSegments.add(new OrderSegment(2, 1, 2, 1, 8000.0, "Sedang"));
        orderSegments.get(1).setMenu(menuList.get(1));
        orderSegments.get(1).setOrder(orderList.get(0));

        orderSegments.add(new OrderSegment(3, 2, 2, 2, 16000.0, "Sedang"));
        orderSegments.get(2).setMenu(menuList.get(1));
        orderSegments.get(2).setOrder(orderList.get(1));

        orderSegments.add(new OrderSegment(4, 3, 3, 1, 20000.0, "Pedas"));
        orderSegments.get(3).setMenu(menuList.get(2));
        orderSegments.get(3).setOrder(orderList.get(2));
    }

    public List<OrderSegment> getOrderSegment() {
        return orderSegments;
    }

    public OrderSegment getOrderSegmentById(int id) {
        for (OrderSegment orderSegment : orderSegments) {
            if (orderSegment.getIdOrderSegment() == id) {
                return orderSegment;
            }
        }

        return null;
    }

    public List<OrderSegment> getOrderSegmentsByIdOrder(int idOrder) {
        return orderSegments.stream().filter(os -> os.getIdOrder() == idOrder)
                .collect(Collectors.toList());
    }

    public Result addOrderSegment(OrderSegment orderSegment) {
        if (orderSegment == null) {
            return new Result(500, "Tambah data gagal.");
        }

        orderSegments.add(orderSegment);

        return new Result(200, "Tambah data berhasil.");
    }

    public Result updateOrderSegment(OrderSegment orderSegment) {
        int orderSegmentId = orderSegment.getIdOrderSegment();
        OrderSegment orderSegmentById = getOrderSegmentById(orderSegmentId);

        if (orderSegmentById == null) {
            return new Result(500, "Ubah data gagal! Data tidak ditemukan.");
        }

        int index = orderSegments.indexOf(orderSegmentById);

        orderSegments.set(index, orderSegment);

        return new Result(200, "Ubah data berhasil!");
    }

    public Result deleteOrderSegment(int id) {
        OrderSegment orderSegmentById = getOrderSegmentById(id);

        if (orderSegmentById == null) {
            return new Result(500, "Hapus data gagal! Data tidak ditemukan.");
        }

        orderSegments.remove(orderSegmentById);

        return new Result(200, "Hapus data berhasil.");
    }

    public OrderSegment getLastData() {
        int lastIndex = orderSegments.size() - 1;
        return orderSegments.get(lastIndex);
    }
}
