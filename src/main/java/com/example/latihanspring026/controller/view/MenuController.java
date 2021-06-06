package com.example.latihanspring026.controller.view;

import com.example.latihanspring026.model.Menu;
import com.example.latihanspring026.service.MenuService;
import com.example.latihanspring026.service.OrderSegmentService;
import com.example.latihanspring026.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public String index(Model model) {
        model.addAttribute("menus", menuService.getMenus());
        return "/menu/index";
    }

    @GetMapping("/menu/tambah")
    public String add(Model model) {
        model.addAttribute("menu", new Menu());
        return "/menu/add";
    }

    @PostMapping("/menu/tambah")
    public String store(Menu menu, BindingResult result, Model model) {
        // set ID menu sesuai dengan id terakhir ditambah 1
        menu.setIdMenu(menuService.getLastData().getIdMenu() + 1);

        menuService.addMenu(menu);

        if (result.hasErrors()) {
            return "/menu/add";
        }

        return "redirect:/menu";
    }

}
