package com.example.latihanspring026.controller.view;

import com.example.latihanspring026.service.MenuService;
import com.example.latihanspring026.service.OrderSegmentService;
import com.example.latihanspring026.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public String index(Model model) {
        model.addAttribute("menus", menuService.getMenus());
        return "/menu/index.html";
    }

    @GetMapping("/menu/tambah")
    public String add(Model model) {
        return "/menu/add.html";
    }

}
