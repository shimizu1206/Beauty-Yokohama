package com.example.music_management.controller;

import com.example.music_management.entity.Album;
import com.example.music_management.entity.Yoyaku;
import com.example.music_management.service.AlbumService;
import com.example.music_management.service.YoyakuService;

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
@RequestMapping("/yoyakus")
public class AlbumController {
    private final AlbumService albumService;//フィールド
    private final YoyakuService yoyakuService;

    public AlbumController(AlbumService albumService,YoyakuService yoyakuService) {
        this.albumService = albumService;
        this.yoyakuService = yoyakuService;
    }

    @GetMapping 
     public String yoyakus(Model model){
        List<Yoyaku> yoyakus = yoyakuService.getAllYoyakus();
        model.addAttribute("yoyakus", yoyakus);
        return "album/album-htmllist";
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

    @GetMapping("/{yoyakuId}")
    public String yoyaku(@PathVariable long yoyakuId, Model model) {
        Yoyaku yoyaku = yoyakuService.getAlbumById(yoyakuId);
        model.addAttribute("yoyaku", yoyaku);
        return "album/album-detail";
    }
    @PostMapping("/{yoyakuId}/{humanId}")
    public String human(@PathVariable long yoyakuId, Model model) {
        Yoyaku yoyaku = yoyakuService.getAlbumById(yoyakuId);
        model.addAttribute("yoyaku", yoyaku);
        return "album/album-human";
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

}