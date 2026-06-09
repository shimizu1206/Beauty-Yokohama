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
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;//フィールド
    private final YoyakuService yoyakuService;

    public AlbumController(AlbumService albumService,YoyakuService yoyakuService) {
        this.albumService = albumService;
        this.yoyakuService = yoyakuService;
    }

    @GetMapping //"/album"が実行された時点でこのメソッドも起動
    public String albums(Model model) { //modelはデータを運ぶ箱みたい
        List<Album> albums = albumService.getAllAlbums(); //list<Album>型のalbumにすべてのアルバムを入れる
        model.addAttribute("albums", albums);//modelという箱にalbumsという名前で上のalbumを入れる
        return "album/album-list";//album-list.htmlに返す
    }
    @GetMapping("/re")
     public String yoyakus(Model model){
        List<Yoyaku> yoyakus = yoyakuService.getAllYoyakus();
        model.addAttribute("yoyakus", yoyakus);
        return "album/album-htmllist";
     }

    
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
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

    @GetMapping("/{albumId}")
    public String album(@PathVariable long albumId, Model model) {
        Album album = albumService.getAlbumById(albumId); //getAlbumByIdに引数でもらったidを渡す
        model.addAttribute("album", album);
        return "album/album-detail";
    }

    @PostMapping("/{albumId}/delete")
    public String deleteAlbum(@PathVariable long albumId) {
        albumService.deleteAlbum(albumId);//deleteAlbumに引数でもらったidを渡す
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