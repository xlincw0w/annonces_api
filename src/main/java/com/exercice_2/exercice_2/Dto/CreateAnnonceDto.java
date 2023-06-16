package com.exercice_2.exercice_2.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

@Data
public class CreateAnnonceDto {

  @NotBlank
  private String title;

  @NotBlank
  private String description;

  @NotNull
  @NumberFormat
  private Float price;

  @NotNull
  @Pattern(regexp = "^(IMMOBILIER|EMPLOI|VEHICULE)$")
  private String type;
}
