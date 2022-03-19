drop table if exists recipe_ingredient;
drop table if exists recipe;
drop table if exists country_of_origin;
drop table if exists ingredients;


create table country_of_origin(
	country_pk int unsigned not null auto_increment,
	country_name varchar(50) not null,
	primary key (country_pk)
);

create table recipe(
	recipe_pk int unsigned not null auto_increment,
	recipe_name varchar(50) not null,
	country_fk int unsigned not null,
	has_been_cooked bool not null,
	primary key (recipe_pk),
	foreign key (country_fk) references country_of_origin (country_pk)
);

create table ingredients(
	ingredient_pk int unsigned not null auto_increment,
	ingredient_name varchar(50) not null,
	season_start date not null,
	season_end date not null,
	primary key (ingredient_pk)
);

create table recipe_ingredient(
	recipe_fk int unsigned not null,
	ingredient_fk int unsigned not null,
	foreign key (recipe_fk) references recipe (recipe_pk),
	foreign key (ingredient_fk) references ingredients (ingredient_pk)
);
