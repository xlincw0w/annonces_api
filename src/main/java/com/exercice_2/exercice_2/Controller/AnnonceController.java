package com.exercice_2.exercice_2.Controller;

import com.exercice_2.exercice_2.Dto.CreateAnnonceDto;
import com.exercice_2.exercice_2.Dto.UpdateAnnonceDto;
import com.exercice_2.exercice_2.Model.Annonce;
import com.exercice_2.exercice_2.Service.AnnonceService;
import com.exercice_2.exercice_2.Templates.UseResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/annonce")
@Validated
public class AnnonceController {

  @Autowired
  private AnnonceService annonceService;

  @GetMapping
  public ResponseEntity<UseResponse<List<Annonce>>> fetchAnnonces(
    @RequestParam Map<String, String> params
  ) {
    UseResponse<List<Annonce>> response = new UseResponse<>();
    response.setPayload(this.annonceService.fetchAnnonces(params));
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PostMapping
  public ResponseEntity<UseResponse<Annonce>> createAnnonce(
    @RequestBody @Valid CreateAnnonceDto data
  ) {
    UseResponse<Annonce> response = new UseResponse<>();
    response.setPayload(this.annonceService.createAnnonce(data));
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UseResponse<Annonce>> updateAnnonce(
    @PathVariable UUID id,
    @RequestBody @Valid UpdateAnnonceDto data
  ) {
    UseResponse<Annonce> response = new UseResponse<>();
    response.setPayload(this.annonceService.updateAnnonce(id, data));
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<UseResponse<String>> deleteAnnonce(
    @PathVariable UUID id
  ) {
    UseResponse<String> response = new UseResponse<>();
    response.setPayload(this.annonceService.deleteAnnonce(id));
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
