package com.promineotech.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.recipe.dao.AddCountryDao;
import com.promineotech.recipe.entity.CountryOfOrigin;

@Service
public class DefaultAddCountryService implements AddCountryService {

  @Autowired
  private AddCountryDao addCountryDao;
  
  @Override
  @Transactional
  public CountryOfOrigin addCountry(String countryName) {
    // TODO Auto-generated method stub
    return addCountryDao.addCountry(countryName);
  }

}
