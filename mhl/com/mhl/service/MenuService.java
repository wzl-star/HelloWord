package com.mhl.service;

import com.mhl.dao.MenuDAO;
import com.mhl.domain.Menu;

import java.util.List;

public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();
    public List<Menu> menuList(){
        List<Menu> menusLists = menuDAO.queryMulti("select * from menu", Menu.class);
        return menusLists;
    }
    public Menu getMenuId(int id){
        Menu menu = menuDAO.querySingle("select * from menu where id=?", Menu.class, id);
        return menu;
    }
}
