package com.promineotech.recipe.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryOfOrigin {

  private Long countryPK;
  private String countryName;
}
