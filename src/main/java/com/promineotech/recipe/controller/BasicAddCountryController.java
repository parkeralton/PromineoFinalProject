package com.promineotech.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.recipe.entity.CountryOfOrigin;
import com.promineotech.recipe.service.AddCountryService;
@RestController
@Service
public class BasicAddCountryController implements AddCountryController {

  @Autowired
  private AddCountryService addCountryService;
  @Override
  public CountryOfOrigin addCountry(String CountryName) {
    // TODO Auto-generated method stub
    return addCountryService.addCountry(CountryName);
  }

}
