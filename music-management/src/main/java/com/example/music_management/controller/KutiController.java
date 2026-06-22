package com.example.music_management.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.music_management.entity.Kuti;
import com.example.music_management.entity.Shop;
import com.example.music_management.form.KutiForm;
import com.example.music_management.securiry.CustomUserDetails;
import com.example.music_management.service.KutiService;
import com.example.music_management.service.ShopService;

@Controller
public class KutiController {
    private final KutiService kutiService;
    private final ShopService shopService;

    public KutiController(KutiService kutiService, ShopService shopService) {
        this.kutiService = kutiService;
        this.shopService = shopService;
    }

    @GetMapping("shops/Kutis/{shopId}")
    public String kuti(@PathVariable long shopId, Model model,@AuthenticationPrincipal CustomUserDetails userDetails) {
        List<Kuti> Kutis = kutiService.getKutisByshopId(shopId);
        Shop shop = shopService.getShopById(shopId);
        KutiForm KutiForms = new KutiForm();
        KutiForms.setShopId(shopId);
        if(userDetails == null){
            model.addAttribute("user","");
        }else {
            model.addAttribute("user", userDetails.getUsername());
        }
        model.addAttribute("shop", shop);
        model.addAttribute("Kutis", Kutis);
        model.addAttribute("KutiForms", KutiForms);
        return "shop/kutikomi-form";
    }

    @PostMapping("shops/Kutis/{shopId}")
    public String createAlbum(@PathVariable long shopId,@AuthenticationPrincipal CustomUserDetails userDetails, KutiForm kutiForm) {
        String result = "";
        if(userDetails != null){
        kutiService.createKutikomi(kutiForm);
        result = "redirect:/shops/Kutis/" + shopId;
         }else {
        result = "redirect:/shops/Kutis/" + shopId;
         }
         return result;
    }

    @PostMapping("shops/Kutis/{kutiId}/delete")
    public String deleteKuti(@PathVariable long kutiId,@AuthenticationPrincipal CustomUserDetails userDetails,@RequestParam long shopId) {
        String result = "";
        if(userDetails.getUsername() .equals("key")){
        kutiService.deleteKuti(kutiId);
             result = "redirect:/shops/Kutis/" + shopId;
        }else {
             result = "redirect:/shops/Kutis/" + shopId;
        }
        return result;
    }
    }

    