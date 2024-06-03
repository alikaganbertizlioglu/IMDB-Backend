# SE 3355 Ali Kağan Bertizlioğlu IMDb Clone Project

Presentation video : https://www.youtube.com/watch?v=Ff7O7cpDdCM


The IMDb clone project is based on N-layered Architecture and was prepared by adhering to SOLID principles. It allows users to register, log in, add movies to watchlist, and rate movies.

It was prepared using the latest technology such as Java 17, Spring Boot 3, Azure SQL Database, Angular 17. It also comes with the JWT token system, BCrypt encryption algorithm, multi-language support and a responsive design.
Frontend, database and backend deployed to Microsoft Azure.

#### Frontend Source Code: https://github.com/alikaganbertizlioglu/se3355-frontend-angular
#### Backend Live Link: https://se3355finalbackend.azurewebsites.net/swagger-ui/index.html
#### Web App Live Link: https://wonderful-mushroom-0269ae10f.5.azurestaticapps.net/home
![Ekran Resmi 2024-06-02 20 41 03](https://github.com/alikaganbertizlioglu/se3355final/assets/93092438/7aa2f6b6-6902-4506-8447-57c7f56d837d)

![Başlıksız Diyagram drawio](https://github.com/alikaganbertizlioglu/se3355final/assets/93092438/b295f858-2443-426a-a989-fe4b77f766c4)


## Table of Contents
1. [Project Structure](#project-structure)
2. [Database and Relationships](#database-and-relationships)
3. [Backend Implementation](#backend-implementation)
4. [Frontend Implementation](#frontend-implementation)
5. [API Endpoints](#api-endpoints)
6. [Conclusion](#conclusion)

## Introduction
This project is an IMDb clone application that allows users to perform the following operations:
- Register
- Login
- Display movies, trailers, and detailed info.
- Add movies to their watchlist
- Rate movies and be effective on popularity index
- Switch languages between Turkish and English
  
## Database and Relationships
### ER Diagram 
![mermaid-diagram-2024-06-02-201552](https://github.com/alikaganbertizlioglu/se3355final/assets/93092438/f545b6cf-f5de-4f7a-95d9-b4c440e20c54)

### Relationships Between Entities 

- **One-to-Many Relationship**: One user can have multiple ratings, and a rating belongs to only one user.
  - **Entities**: User (One) - Rating (Many)
  - **Implementation**: `@OneToMany` annotation in the User entity referencing the ratings field.

- **Many-to-One Relationship**: Many ratings can belong to one movie, and one movie can have multiple ratings.
  - **Entities**: Rating (Many) - Movie (One)
  - **Implementation**: `@ManyToOne` annotation in the Rating entity referencing the movie field.

- **Many-to-Many Relationship**: Many movies can have multiple actors, and an actor can act in multiple movies.
  - **Entities**: Movie (Many) - Actor (Many)
  - **Implementation**: `@ManyToMany` annotation in both the Movie and Actor entities with a join table `movie_actor`.

- **One-to-One Relationship**: Each user has one watchlist, and a watchlist belongs to only one user.
  - **Entities**: User (One) - Watchlist (One)
  - **Implementation**: `@OneToOne` annotation in the Watchlist entity referencing the user field with `mappedBy` attribute in the User entity.
    
- **Many-to-Many Relationship**: Many movies can be added to multiple watchlists, and a watchlist can contain multiple movies.
  - **Entities**: Movie (Many) - Watchlist (Many)
  - **Implementation**: `@ManyToMany` annotation in both the Movie and Watchlist entities with a join table `watchlist_movies`.

# IMPORTANT! Popularity Ranking Update Algorithm

## Overview

Implemented an algorithm that updates the popularity ranking in ascending order based on a combination of the average rating and the number of viewers. Utilized stored procedures, functions, and SQL triggers for this functionality.

## Stored Procedure (`update_popularity_rankings`)

The stored procedure calculates the popularity score for each movie, orders them by the score, and updates the popularity ranking.

```sql
CREATE PROCEDURE update_popularity_rankings
AS
BEGIN
    -- Create a temporary table to hold the movie IDs and their calculated popularity scores
    CREATE TABLE #temp_popularity_ranking (
        id BIGINT,
        popularity_score FLOAT
    );

    -- Insert the movie IDs and their calculated popularity scores into the temporary table
    INSERT INTO #temp_popularity_ranking (id, popularity_score)
    SELECT
        m.id,
        0.7 * ISNULL(AVG(r.rating), 0) + 0.3 * m.number_of_viewer AS popularity_score
    FROM
        movies m
        LEFT JOIN ratings r ON m.id = r.movie_id
    GROUP BY
        m.id, m.number_of_viewer;

    -- Update the movies table with the new popularity ranking
    UPDATE m
    SET m.popularity_ranking = pr.new_rank
    FROM
        movies m
        JOIN (
            SELECT
                id,
                ROW_NUMBER() OVER (ORDER BY popularity_score DESC) AS new_rank
            FROM
                #temp_popularity_ranking
        ) pr ON m.id = pr.id;

    -- Drop the temporary table
    DROP TABLE #temp_popularity_ranking;
END
```
### Triggers  (`after_rating_insert`) and  (`after_movie_update`)

Triggers are created for the ratings and movies tables to call the stored procedure whenever a relevant update occurs.
```sql

CREATE TRIGGER after_rating_insert
ON ratings
AFTER INSERT
AS
BEGIN
    EXEC update_popularity_rankings;
END
GO

CREATE TRIGGER after_rating_update
ON ratings
AFTER UPDATE
AS
BEGIN
    EXEC update_popularity_rankings;
END
GO

This trigger will call the stored procedure whenever the number of viewers changes.
sql
Kodu kopyala
CREATE TRIGGER after_movie_update
ON movies
AFTER UPDATE
AS
BEGIN
    IF UPDATE(number_of_viewer)
    BEGIN
        EXEC update_popularity_rankings;
    END
END
GO
```

## Explanation

1. **Stored Procedure**:
    - **update_popularity_rankings**: This procedure calculates a popularity score for each movie using a weighted combination of the average rating and the number of viewers. It then assigns a rank based on the descending order of these scores using the `ROW_NUMBER()` function. The new ranks are updated in the movies table.

2. **Triggers**:
    - **after_rating_insert** and **after_rating_update**: These triggers execute the stored procedure whenever a new rating is inserted or an existing rating is updated.
    - **after_movie_update**: This trigger executes the stored procedure whenever the `number_of_viewer` field is updated in the movies table.

  
## Project Structure
### Backend (Spring Boot)
- `src/main/java/com/imdb/clone`
  - `controller`
  - `service`
  - `repository`
  - `entity`
  - `exceptions`
  - `DTO's including request and responses`
  - `config,filter and utils`

### Frontend (Angular)
- `src/app`
  - `components`
  - `services`
  - `models`
  - `app.module.ts`
  - `app.component.ts`
  - `app-routing.module.ts`
  - `assets -> i18n -> tr.json and en.json for multilanguage support`



## Backend Implementation
### Controllers
- AuthController, MovieController, ActorController, WatchlistController, RatingController

### Services
- UserService, MovieService, WatchlistService, RatingService, ActorService

### Repositories
- UserRepository, MovieRepository, WatchlistRepository, RatingRepository, ActorRepository

### Entities
- User, Movie, Watchlist, Rating, Actor


## Frontend Implementation

### Components
- **LoginComponent**
- **RegisterComponent**
- **HomeComponent**
- **MovieComponent**
- **FooterComponent**
- **HeaderComponent**
### Services
- **AuthService**: Handles authentication and user services.
- **MovieService**: Handles movie-related operations.
- **RatingService**: Manages rating operations.
- **SpinnerService**: Manages and displays loading spinner
- **AlertifyService**: Manages alert messages such as success,message,errror or warning
- **LanguageService**: Implemented in app.component.ts, manages multilanguage functionality 

## API Endpoints

### auth-controller
- POST /public/auth/signup
- POST /public/auth/login

### watchlist-controller
- POST /api/watchlist/add
- GET /api/watchlist/get/{userId}

### rating-controller
- POST /api/ratings/add

### movie-controller
- GET /public/api/movies/search/{searchStr}
- GET /public/api/movies/getall
- GET /public/api/movies/get/{id}

### actor-controller
- GET /public/api/actors/search/{searchStr}


## Conclusion
This IMDb clone provides a robust platform for users to explore movies, manage their watchlist, and rate movies. The project demonstrates a full-stack application using Spring Boot for the backend and Angular for the frontend, showcasing essential features such as user authentication, CRUD operations, and user interactions.
