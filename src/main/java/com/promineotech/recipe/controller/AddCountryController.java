package com.promineotech.recipe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.recipe.entity.CountryOfOrigin;
import com.promineotech.recipe.entity.Recipe;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/addCountry")
@OpenAPIDefinition(info = @Info(title = "Add New Country"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface AddCountryController {
//@formatter:off
 @Operation(
     summary = "Add new country",
     description = "Add new country of origin",
     responses = {
         @ApiResponse(
             responseCode = "201", 
             description = "The added country is returned", 
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = Recipe.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are wrong", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "The country componenets were not found", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "Unplanned error", 
             content = @Content(mediaType = "application/json"))
     },
     parameters = {
         @Parameter(name = "CountryName",
             required = true,
             description = "Name of the Country"),   

     }
 )
//@formatter:on
 
@PostMapping
@ResponseStatus(code = HttpStatus.CREATED)
 
CountryOfOrigin addCountry(@RequestParam String CountryName);
}
