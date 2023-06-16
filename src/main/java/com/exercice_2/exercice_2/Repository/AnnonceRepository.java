package com.exercice_2.exercice_2.Repository;

import com.exercice_2.exercice_2.Model.Annonce;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce, UUID> {}
