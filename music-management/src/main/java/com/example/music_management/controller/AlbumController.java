package com.example.music_management.controller;
import com.example.music_management.entity.Album;
import com.example.music_management.entity.Item;
import com.example.music_management.entity.Menu;
import com.example.music_management.entity.Reserve;
import com.example.music_management.entity.Shop;
import com.example.music_management.entity.Staff;
import com.example.music_management.service.AlbumService;
import com.example.music_management.service.ItemService;
import com.example.music_management.service.MenuService;
import com.example.music_management.service.ReserveService;
import com.example.music_management.service.ShopService;
import com.example.music_management.service.StaffService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.example.music_management.form.ReserveForm;
import com.example.music_management.form.StaffView;
import com.example.music_management.securiry.CustomUserDetails;

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
    private final ReserveService reserveService;


    public AlbumController(AlbumService albumService,ShopService shopService,ItemService itemService,MenuService menuService,StaffService staffService,ReserveService reserveService) {
        this.albumService = albumService;
        this.shopService = shopService;
        this.itemService = itemService;
        this.menuService = menuService; 
        this.staffService = staffService;
        this.reserveService = reserveService;
    }

    @GetMapping 
     public String shops(Model model){
        List<StaffView> shops = shopService.getAllShops();
        model.addAttribute("shops", shops);
        return "shop/shop-detail";
    }
 
    public String postMethodName(@RequestBody String entity) {
        return entity;
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

    
    @GetMapping("/menus/{shopId}")
    public String menu(@PathVariable long shopId, Model model) {
        List<Menu> menu = menuService.getMenusByshopId(shopId);
        model.addAttribute("menus", menu);
        return "shop/menu-list";
    }

   @GetMapping("/new/{shopId}") // 画面から入力のところ
    public String reserveForm(@PathVariable long shopId, Model model) {// getの時はhtmlに渡すからmodelを使う？
        ReserveForm reserveForm = new ReserveForm(); // albumform型のalbumformを作成
        List<Menu> menu = menuService.getMenusByshopId(shopId);
        List<Staff> staff = staffService.getStaffsBystaffId(shopId);
        List<Item> item = itemService.getItemsByshopId(shopId);
        Shop shop = shopService.getShopById(shopId);
        reserveForm.setShopName(shop.getShopName());
        reserveForm.setShopId(shop.getShopId());
        model.addAttribute("reserveForm", reserveForm);
        model.addAttribute("menus", menu);
        model.addAttribute("staffs", staff);
        model.addAttribute("items", item);

        return "shop/reserve-form";// ここのhtmlに返す
    }

    @PostMapping("/new")
    public String createReserve(ReserveForm reserveForm,@AuthenticationPrincipal CustomUserDetails userDetails) {
        reserveForm.setUserId(userDetails.getUserId());
        reserveService.createReserve(reserveForm);
        return "redirect:/shops/reserved";
    }

    @GetMapping("/reserved")
    public String Reaserved(Model model ,@AuthenticationPrincipal CustomUserDetails userDetails){
        List<Reserve> reserved = reserveService.getReserveById(userDetails.getUserId());
        model.addAttribute("user",userDetails);
        model.addAttribute("reserved",reserved);
        return "shop/reserved-form";
    }

    @PostMapping("/reserved/{reservedId}/delete")
    public String deleteReseve(@PathVariable long reservedId) {
        reserveService.deleteReserve(reservedId);
        return "redirect:/shops";
    }

}