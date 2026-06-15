package com.example.music_management.repository;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.music_management.entity.Kuti;
import com.example.music_management.mapper.KutiMapper;
@Repository
public class KutiRepository {
  private final KutiMapper kutimapper;

  public KutiRepository(KutiMapper kutimapper){
    this.kutimapper = kutimapper;
  }
     public void insertKutikomi(Kuti kuti) {
       kutimapper.insertKutikomi(kuti);
    }
        public List<Kuti> getKutisByshopId(long shopId){
        return kutimapper.selectKutisByshopId(shopId);
    }
}
