package com.example.music_management.controller;

import com.example.music_management.entity.Album;
import com.example.music_management.entity.Item;
import com.example.music_management.entity.Menu;
import com.example.music_management.entity.Shop;
import com.example.music_management.entity.Staff;
import com.example.music_management.service.AlbumService;
import com.example.music_management.service.ItemService;
import com.example.music_management.service.MenuService;
import com.example.music_management.service.ShopService;
import com.example.music_management.service.StaffService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.example.music_management.form.AlbumForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/shops")
public class AlbumController {
    private final AlbumService albumService;//フィールド
    private final ShopService shopService;
    private final ItemService itemService;
    private final MenuService menuService;
    private final StaffService staffService;

    public AlbumController(AlbumService albumService,ShopService shopService,ItemService itemService,MenuService menuService,StaffService staffService) {
        this.albumService = albumService;
        this.shopService = shopService;
        this.itemService = itemService;
        this.menuService = menuService; 
        this.staffService = staffService;
    }

    @GetMapping 
     public String shops(Model model){
        List<Shop> shops = shopService.getAllShops();
        model.addAttribute("shops", shops);
        return "shop/shop-list";
    }
    @GetMapping("/re")
     public String albums(Model model) { 
        List<Album> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);
        return "album/album-list";
     }

    
    public String postMethodName(@RequestBody String entity) {
        return entity;
    }
    
    @GetMapping("/new")//画面から入力のところ
    public String albumForm(Model model) {//getの時はhtmlに渡すからmodelを使う？
        AlbumForm albumForm = new AlbumForm(); //albumform型のalbumformを作成
        model.addAttribute("albumForm", albumForm);//modelにalbumformという名前でalbumformを入れる
        return "album/album-form";//ここのhtmlに返す
    }

    
    @PostMapping("/new")//入力された内容を登録DBに渡す？
    public String createAlbum(AlbumForm albumForm) {
        albumService.createAlbum(albumForm);
        return "redirect:/albums";
    }

    @GetMapping("/{shopId}")
    public String shops(@PathVariable long shopId, Model model) {
        Shop shop = shopService.getShopById(shopId);
        model.addAttribute("shop", shop);
        return "shop/shop-detail";
    }

    @PostMapping("/{albumId}/delete")
    public String deleteAlbum(@PathVariable long albumId) {
        albumService.deleteAlbum(albumId);
        return "redirect:/albums";
    }

    @GetMapping("/{albumId}/edit")
    public String editAlbum(@PathVariable long albumId, Model model) {
        Album album = albumService.getAlbumById(albumId);
        model.addAttribute("album", album);
        return "album/album-edit";
    }

    @PostMapping("/{albumId}/edit")
    public String updateAlbum(@PathVariable long albumId, Album album) {
        albumService.updateAlbum(albumId, album);//updateAlbumに引数でもらったidとalbumを渡す。
        return "redirect:/albums";
    }

    @GetMapping("/items")
    public String items(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "shop/item-list";
    }

    @GetMapping("/items/{shopId}")
    public String item(@PathVariable long shopId, Model model) {
        List<Item> item = itemService.getItemsByshopId(shopId);
        model.addAttribute("items", item);
        return "shop/item-list";
    }
    @GetMapping("/staffs/{shopId}")
    public String staff(@PathVariable long shopId, Model model) {
        List<Staff> staff = staffService.getStaffsBystaffId(shopId);
        model.addAttribute("staffs", staff);
        return "shop/staff-list";
    }

    @GetMapping("/menus")
    public String menus(Model model) {
        List<Menu> menus = menuService.getAllMenus();
        model.addAttribute("menus", menus);
        return "album/menu-list";
    }

    @GetMapping("/menus/{menuId}")
    public String menu(@PathVariable long menuId, Model model) {
        Menu menu = menuService.getMenuById(menuId);
        model.addAttribute("menu", menu);
        return "album/menu-list";
    }

}