package com.example.latihanspring026.controller;

import com.example.latihanspring026.model.Menu;
import com.example.latihanspring026.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/menu/ubah/{id}")
    public String edit(@PathVariable int id, Model model) {
        Menu menu = menuService.getMenuById(id);

        model.addAttribute("menu", menu);
        return "/menu/update";
    }

    @PostMapping("/menu/tambah")
    public String store(Menu menu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/menu/add";
        }

        // set ID menu sesuai dengan id terakhir ditambah 1
        menu.setIdMenu(menuService.getLastData().getIdMenu() + 1);

        menuService.addMenu(menu);

        return "redirect:/menu";
    }

    @PostMapping("/menu/ubah/{id}")
    public String update(@PathVariable int id, Menu menu, BindingResult result, Model model) {
        menu.setIdMenu(id);
        if (result.hasErrors()) {
            return "/menu/ubah";
        }

        menuService.updateMenu(menu);

        return "redirect:/menu";
    }

    @GetMapping("/menu/hapus/{id}")
    public String destroy(@PathVariable int id, Model model) {
        menuService.deleteMenu(id);

        return "redirect:/menu";
    }

}
