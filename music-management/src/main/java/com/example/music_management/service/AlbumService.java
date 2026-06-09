package com.example.music_management.service;

import com.example.music_management.repository.AlbumRepository;
import com.example.music_management.form.AlbumForm;
import com.example.music_management.entity.Album;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAllAlbums() {
        return albumRepository.getAllAlbums();//どんどん下の階層にすべてのalbumの内容をdbにもらいに行く感じ？同じことをリポでもやっている
    }

    public void createAlbum(AlbumForm albumForm) { //アルバムを作る
        Album album = new Album();
        album.setTitle(albumForm.getTitle());
        album.setArtist(albumForm.getArtist());
        album.setReleaseDate(albumForm.getReleaseDate());
        albumRepository.insertAlbum(album);
    }

    public Album getAlbumById(long albumId) {
        return albumRepository.getAlbumById(albumId);
    }

    public void deleteAlbum(long albumId) {
        albumRepository.deleteAlbum(albumId);
    }

    public void updateAlbum(long albumId, Album album) {
        if (albumId != album.getAlbumId()) {
            throw new IllegalArgumentException("Album ID does not match");
        }
        albumRepository.updateAlbum(album);
    }
}