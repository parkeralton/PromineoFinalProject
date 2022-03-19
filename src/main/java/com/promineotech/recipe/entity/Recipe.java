package com.promineotech.recipe.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Recipe {

  private Long recipePK;
  private String recipeName;
  private Long countryFK;
  private Boolean hasBeenCooked;

}
