package com.exercice_2.exercice_2.Repository;

import com.exercice_2.exercice_2.Model.Annonce;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AnnonceRepository
  extends JpaRepository<Annonce, UUID>, JpaSpecificationExecutor<Annonce> {
  List<Annonce> findByTitleContainingIgnoreCase(String title);
}
