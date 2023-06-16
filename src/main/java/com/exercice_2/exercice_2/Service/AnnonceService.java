package com.exercice_2.exercice_2.Service;

import com.exercice_2.exercice_2.Dto.CreateAnnonceDto;
import com.exercice_2.exercice_2.Dto.UpdateAnnonceDto;
import com.exercice_2.exercice_2.Model.Annonce;
import com.exercice_2.exercice_2.Repository.AnnonceRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceService {

  @Autowired
  private AnnonceRepository annonceRepository;

  public List<Annonce> fetchAnnonces() {
    return this.annonceRepository.findAll();
  }

  public Annonce createAnnonce(CreateAnnonceDto data) {
    Annonce newAnnonce = new Annonce(
      UUID.randomUUID(),
      data.getTitle(),
      data.getDescription(),
      data.getPrice(),
      data.getType()
    );
    return this.annonceRepository.save(newAnnonce);
  }

  public Annonce updateAnnonce(UUID id, UpdateAnnonceDto data) {
    Optional<Annonce> checkAnnonce = this.annonceRepository.findById(id);

    if (checkAnnonce.isEmpty()) throw new EntityNotFoundException(
      "Annonce doesn't exist."
    );

    Annonce existingAnnonce = this.annonceRepository.getReferenceById(id);

    if (data.getTitle() != null) {
      existingAnnonce.setTitle(data.getTitle());
    }

    if (data.getDescription() != null) {
      existingAnnonce.setDescription(data.getDescription());
    }

    if (data.getPrice() != null) {
      existingAnnonce.setPrice(data.getPrice());
    }

    if (data.getType() != null) {
      existingAnnonce.setType(data.getType());
    }

    return this.annonceRepository.save(existingAnnonce);
  }

  public String deleteAnnonce(UUID id) {
    Optional<Annonce> checkAnnonce = this.annonceRepository.findById(id);

    if (checkAnnonce.isEmpty()) throw new EntityNotFoundException(
      "Annonce doesn't exist."
    );

    this.annonceRepository.deleteById(id);
    return "deleted";
  }
}
