package com.promineotech.recipe.service;

import java.time.MonthDay;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.recipe.dao.IngredientSeasonDao;
import com.promineotech.recipe.entity.Ingredients;

@Service
public class DefaultIngredientSeasonService implements IngredientSeasonService {

  @Autowired
  private IngredientSeasonDao ingredientSeasonDao;
  
  @Override
  public List<Ingredients> fetchIngredients(String date) {
    // TODO Auto-generated method stub
    return ingredientSeasonDao.fetchIngredients(date);
  }

}