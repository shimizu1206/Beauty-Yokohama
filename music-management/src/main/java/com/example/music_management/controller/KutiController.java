package com.example.music_management.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.music_management.entity.Kuti;
import com.example.music_management.form.KutiForm;
import com.example.music_management.service.KutiService;

@Controller
public class KutiController {
    private final KutiService kutiService;

    public KutiController(KutiService kutiService){
        this.kutiService = kutiService;
    }
    @GetMapping("shops/Kutis/{shopId}")
     public String kuti(@PathVariable long shopId, Model model) {
        List<Kuti> KutiForms = kutiService.getKutisByshopId(shopId);
        model.addAttribute("KutiForms", KutiForms);
        return "shop/kutikomi-form";
    }

    @PostMapping("shops/Kutis/{shopId}")
    public String createAlbum(KutiForm kutiForm) {
        kutiService.createKutikomi(kutiForm);
        return "redirect:/Kutis";
    }
}
