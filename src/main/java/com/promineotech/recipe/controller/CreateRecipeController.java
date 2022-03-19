package com.promineotech.recipe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
@RequestMapping("/createrecipe")
@OpenAPIDefinition(info = @Info(title = "Create New Recipe"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface CreateRecipeController {
//@formatter:off
 @Operation(
     summary = "Create new recipe",
     description = "Returns new recipe",
     responses = {
         @ApiResponse(
             responseCode = "201", 
             description = "The created recipe is returned", 
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = Recipe.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are wrong", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "The recipe componenets were not found", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "Unplanned error", 
             content = @Content(mediaType = "application/json"))
     },
     parameters = {
         @Parameter(name = "RecipeName",
             required = true,
             description = "Name of the Recipe"),   
         @Parameter(name = "CountryOfOrigin",
             required = true,
               description = "Country of Origin"), 
         @Parameter(name = "cooked",
         required = true,
           description = "Has Been Cooked?")  
     }
 )
//@formatter:on
 
@PostMapping
@ResponseStatus(code = HttpStatus.CREATED)
 
Recipe createRecipe(@RequestParam String RecipeName,
                    @RequestParam String CountryOfOrigin,
                    @RequestParam boolean cooked);
}
