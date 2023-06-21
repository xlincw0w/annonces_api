package com.exercice_2.exercice_2.Unit.Annonce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.exercice_2.exercice_2.Model.Annonce;
import com.exercice_2.exercice_2.Repository.AnnonceRepository;
import com.exercice_2.exercice_2.Service.AnnonceService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AnnonceUnitTest {

  @InjectMocks
  private AnnonceService annonceService;

  @Mock
  private AnnonceRepository annonceRepository;

  @Test
  public void itShouldFetchAnnonces() {
    // GIVEN
    Annonce a1 = Annonce
      .builder()
      .id(new UUID(0, 8))
      .title("title 1")
      .description("description 1")
      .price(1000)
      .type("EMPLOI")
      .build();

    Annonce a2 = Annonce
      .builder()
      .id(new UUID(0, 8))
      .title("title 2")
      .description("description 2")
      .price(1300)
      .type("IMMOBILIER")
      .build();

    Annonce a3 = Annonce
      .builder()
      .id(new UUID(0, 8))
      .title("title 3")
      .description("description 3")
      .price(2100)
      .type("VEHICULE")
      .build();

    Mockito
      .lenient()
      .when(
        annonceRepository.findAll(
          ArgumentMatchers.<Specification<Annonce>>any()
        )
      )
      .thenReturn(List.of(a1, a2, a3));

    Map<String, String> params = new HashMap<>();

    // WHERE
    List<Annonce> annonces = this.annonceService.fetchAnnonces(params);

    // THEN
    assertEquals(3, annonces.size());
  }
}
