insert into ingredients(ingredient_name, season_start, season_end) Values('Tortilla', '2000-01-01', '2000-12-31');
insert into ingredients(ingredient_name, season_start, season_end) Values('Cheese', '2000-01-01', '2000-12-31');
insert into ingredients(ingredient_name, season_start, season_end) Values('Beef', '2000-01-01', '2000-12-31');
insert into ingredients(ingredient_name, season_start, season_end) Values('Salmon', '2000-01-01', '2000-12-31');
insert into ingredients(ingredient_name, season_start, season_end) Values('Honey', '2000-01-01', '2000-12-31');
insert into ingredients(ingredient_name, season_start, season_end) Values('Chicken', '2000-01-01', '2000-12-31');
insert into ingredients(ingredient_name, season_start, season_end) Values('Bagel', '2000-01-01', '2000-12-31');
insert into ingredients(ingredient_name, season_start, season_end) Values('Dough', '2000-01-01', '2000-12-31');
insert into ingredients(ingredient_name, season_start, season_end) Values('Cream Cheese', '2000-01-01', '2000-12-31');
insert into ingredients(ingredient_name, season_start, season_end) Values('Egg', '2000-01-01', '2000-12-31');

insert into country_of_origin(country_name) values('United States of America');
insert into country_of_origin(country_name) values('Mexico');
insert into country_of_origin(country_name) values('Georgia');
insert into country_of_origin(country_name) values('Norway');

insert into recipe(recipe_name, has_been_cooked, country_fk)
	select 'Quesadilla', 
	false,
	country_pk from country_of_origin where country_name = 'Mexico';
	
insert into recipe(recipe_name, has_been_cooked, country_fk)
	select 'Honey Chicken', 
	true,
	country_pk from country_of_origin where country_name = 'United States of America';
	
insert into recipe(recipe_name, has_been_cooked, country_fk)
	select 'Khachapuri', 
	false,
	country_pk from country_of_origin where country_name = 'Georgia';
	
insert into recipe(recipe_name, has_been_cooked, country_fk)
	select 'Bagel and Salmon', 
	true,
	country_pk from country_of_origin where country_name = 'Norway';
	
insert into recipe_ingredient(recipe_fk, ingredient_fk) values
	((select recipe_pk from recipe where recipe_name  = 'Quesadilla'),
	(select ingredient_pk from ingredients where ingredient_name = 'Tortilla'));
	
insert into recipe_ingredient(recipe_fk, ingredient_fk) values
	((select recipe_pk from recipe where recipe_name = 'Quesadilla'),
	(select ingredient_pk from ingredients where ingredient_name = 'Cheese'));
	
insert into recipe_ingredient(recipe_fk, ingredient_fk) values
	((select recipe_pk from recipe where recipe_name  = 'Honey Chicken'),
	(select ingredient_pk from ingredients where ingredient_name = 'Chicken'));
	
insert into recipe_ingredient(recipe_fk, ingredient_fk) values
	((select recipe_pk from recipe where recipe_name = 'Honey Chicken'),
	(select ingredient_pk from ingredients where ingredient_name = 'Honey'));
	
insert into recipe_ingredient(recipe_fk, ingredient_fk) values
	((select recipe_pk from recipe where recipe_name  = 'Khachapuri'),
	(select ingredient_pk from ingredients where ingredient_name = 'Cheese'));
	
insert into recipe_ingredient(recipe_fk, ingredient_fk) values
	((select recipe_pk from recipe where recipe_name = 'Khachapuri'),
	(select ingredient_pk from ingredients where ingredient_name = 'Dough'));
	
insert into recipe_ingredient(recipe_fk, ingredient_fk) values
	((select recipe_pk from recipe where recipe_name  = 'Khachapuri'),
	(select ingredient_pk from ingredients where ingredient_name = 'Egg'));
	
insert into recipe_ingredient(recipe_fk, ingredient_fk) values
	((select recipe_pk from recipe where recipe_name = 'Bagel and Salmon'),
	(select ingredient_pk from ingredients where ingredient_name = 'Cream Cheese'));
	
insert into recipe_ingredient(recipe_fk, ingredient_fk) values
	((select recipe_pk from recipe where recipe_name = 'Bagel and Salmon'),
	(select ingredient_pk from ingredients where ingredient_name = 'Salmon'));
	
insert into recipe_ingredient(recipe_fk, ingredient_fk) values
	((select recipe_pk from recipe where recipe_name = 'Bagel and Salmon'),
	(select ingredient_pk from ingredients where ingredient_name = 'Bagel'));