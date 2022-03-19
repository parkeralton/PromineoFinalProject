package com.promineotech.recipe.service;

import java.time.MonthDay;
import java.util.List;
import com.promineotech.recipe.entity.Ingredients;

public interface IngredientSeasonService {

  List<Ingredients> fetchIngredients(String date);
}
