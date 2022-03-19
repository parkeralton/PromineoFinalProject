package com.promineotech.recipe.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
  
public class RecipeIngredient {
  
  private Long recipe_id;
  private Long ingredient_id;

}
