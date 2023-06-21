package com.exercice_2.exercice_2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Annonce {

  @Id
  private UUID id;

  private String title;
  private String description;
  private float price;
  private String type;
}
