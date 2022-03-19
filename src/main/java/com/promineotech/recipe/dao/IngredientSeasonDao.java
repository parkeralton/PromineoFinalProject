package com.promineotech.recipe.dao;

import java.time.MonthDay;
import java.util.List;
import com.promineotech.recipe.entity.Ingredients;

public interface IngredientSeasonDao {

  /**
   * 
   * @param date
   * @return
   */
  
  List<Ingredients> fetchIngredients(String date);

}
