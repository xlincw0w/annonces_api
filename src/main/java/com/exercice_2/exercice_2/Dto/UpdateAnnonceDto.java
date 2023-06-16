package com.exercice_2.exercice_2.Dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import lombok.Data;

@Data
public class UpdateAnnonceDto {

  @Nullable
  @Size(min = 1)
  private String title;

  @Nullable
  @Size(min = 1)
  private String description;

  @Nullable
  @NumberFormat
  private Float price;

  @Nullable
  @Pattern(regexp = "^(IMMOBILIER|EMPLOI|VEHICULE)$")
  private String type;
}
