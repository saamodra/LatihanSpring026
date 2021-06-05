package com.example.latihanspring026.controller;

import com.example.latihanspring026.model.Menu;
import com.example.latihanspring026.model.Result;
import com.example.latihanspring026.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping("/menus")
    public List<Menu> getMenus() {
        return menuService.getMenus();
    }

    @GetMapping("/menu")
    public Object getMenu(@RequestParam("id") int id) {
        Menu menu = menuService.getMenuById(id);

        if (menu == null) {
            return new Result(500, "Data tidak ditemukan.");
        }

        return menu;
    }

    @PostMapping("/menu")
    public Object saveMenu(HttpServletResponse response, @RequestBody Menu menu) {
        return menuService.addMenu(menu);
    }

    @PutMapping("/menu")
    public Object updateMenu(HttpServletResponse response, @RequestBody Menu menu) {
        return menuService.updateMenu(menu);
    }

    @DeleteMapping("/menu")
    public Object deleteMenu(HttpServletResponse response, @RequestParam("id") int id) {
        return menuService.deleteMenu(id);
    }
}
