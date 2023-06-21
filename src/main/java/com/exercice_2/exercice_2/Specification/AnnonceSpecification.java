package com.exercice_2.exercice_2.Specification;

import com.exercice_2.exercice_2.Model.Annonce;
import org.springframework.data.jpa.domain.Specification;

public class AnnonceSpecification {

  public static Specification<Annonce> filterByTitle(String title) {
    return (root, query, criteriaBuilder) ->
      title != null
        ? criteriaBuilder.like(
          criteriaBuilder.lower(root.get("title")),
          "%" + title.toLowerCase() + "%"
        )
        : null;
  }

  public static Specification<Annonce> filterByMinPrice(Float minPrice) {
    return (root, query, criteriaBuilder) ->
      minPrice != null
        ? criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice)
        : null;
  }

  public static Specification<Annonce> filterByMaxPrice(Float maxPrice) {
    return (root, query, criteriaBuilder) ->
      maxPrice != null
        ? criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice)
        : null;
  }

  public static Specification<Annonce> filterByType(String type) {
    return (root, query, criteriaBuilder) ->
      type != null ? criteriaBuilder.equal(root.get("type"), type) : null;
  }
}
