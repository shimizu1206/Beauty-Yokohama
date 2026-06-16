package com.example.music_management.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.music_management.entity.Kuti;
import com.example.music_management.entity.Shop;
import com.example.music_management.form.KutiForm;
import com.example.music_management.service.KutiService;
import com.example.music_management.service.ShopService;

@Controller
public class KutiController {
    private final KutiService kutiService;
    private final ShopService shopService;

    public KutiController(KutiService kutiService,ShopService shopService){
        this.kutiService = kutiService;
        this.shopService = shopService;
    }
    @GetMapping("shops/Kutis/{shopId}")
     public String kuti(@PathVariable long shopId, Model model) {
        List<Kuti> Kutis = kutiService.getKutisByshopId(shopId);
        Shop shop = shopService.getShopById(shopId);
        KutiForm KutiForms = new KutiForm();
        KutiForms.setShopId(shopId);
        model.addAttribute("shop", shop);
        model.addAttribute("Kutis", Kutis);
        model.addAttribute("KutiForms", KutiForms);
        return "shop/kutikomi-form";
    }

    @PostMapping("shops/Kutis/{shopId}")
    public String createAlbum(@PathVariable long shopId, KutiForm kutiForm) {
        kutiService.createKutikomi(kutiForm);
        return "redirect:/shops/Kutis/"+shopId;
    }
}
