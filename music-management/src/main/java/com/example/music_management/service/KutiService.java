package com.example.music_management.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.music_management.entity.Kuti;
import com.example.music_management.form.KutiForm;
import com.example.music_management.repository.KutiRepository;

@Service
public class KutiService {
  private KutiRepository kutiRepository;

  public KutiService(KutiRepository kutiRepository) {
    this.kutiRepository = kutiRepository;
  }

  public void createKutikomi(KutiForm kutiForm) {
    Kuti kuti = new Kuti();
    kuti.setAge(kutiForm.getAge());
    kuti.setGender(kutiForm.getGender());
    kuti.setKansou(kutiForm.getKansou());
    kuti.setShopId(kutiForm.getShopId());
    kutiRepository.insertKutikomi(kuti);
  }

  public List<Kuti> getKutisByshopId(long shopId) {
    return kutiRepository.getKutisByshopId(shopId);
  }

  public void deleteKuti(long kutiId) {
    kutiRepository.deleteKuti(kutiId);
  }
}
