package com.promineotech.recipe.entity;

import java.time.MonthDay;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Ingredients {
  private Long ingredientPK;
  private String ingredient;
  private String seasonStart;
  private String seasonEnd;

}
