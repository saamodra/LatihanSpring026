package com.example.latihanspring026.service;

import com.example.latihanspring026.model.Menu;
import com.example.latihanspring026.model.Result;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    private List<Menu> menus;

    @PostConstruct
    private void initialize() {
        menus = new ArrayList<>();
        menus.add(new Menu(1, "Nasi Goreng", "Nasi", "Nasi Goreng", 10000, 1));
        menus.add(new Menu(2, "Mie Goreng", "Mie", "Mie Goreng", 8000, 1));
        menus.add(new Menu(3, "Seblak", "Mie", "Seblak", 20000, 1));
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public Menu getMenuById(int id) {
        for (Menu menu : menus) {
            if (menu.getIdMenu() == id) {
                return menu;
            }
        }

        return null;
    }

    public Menu getLastData() {
        int lastIndex = menus.size() - 1;
        return menus.get(lastIndex);
    }

    public Result addMenu(Menu menu) {
        menus.add(menu);
        return new Result(200, "Tambah data berhasil.");
    }

    public Result updateMenu(Menu menu) {
        int menuId = menu.getIdMenu();
        Menu menuById = getMenuById(menuId);

        if (menuById == null) {
            return new Result(500, "Ubah data gagal! Data tidak ditemukan.");
        }

        int index = menus.indexOf(menuById);

        menus.set(index, menu);

        return new Result(200, "Ubah data berhasil!");
    }

    public Result deleteMenu(int id) {
        Menu menuById = getMenuById(id);

        if (menuById == null) {
            return new Result(500, "Hapus data gagal! Data tidak ditemukan.");
        }

        menus.remove(menuById);

        return new Result(200, "Hapus data berhasil.");
    }
}
