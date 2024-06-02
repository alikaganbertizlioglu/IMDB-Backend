# SE 3355 Ali Kağan Bertizlioğlu IMDb Clone Project

This project is an IMDb clone that allows users to register, login, add movies to their watchlist, and rate movies. The backend is implemented using Spring Boot and the frontend is developed with Angular.

## Table of Contents
1. [Introduction](#introduction)
2. [Project Structure](#project-structure)
3. [Backend Implementation](#backend-implementation)
4. [Frontend Implementation](#frontend-implementation)
5. [Features](#features)
6. [Usage](#usage)
7. [API Endpoints](#api-endpoints)
8. [Conclusion](#conclusion)

## Introduction
This project is an IMDb clone application that allows users to perform the following operations:
- Register
- Login
- Display movies, trailers, and detailed info.
- Add movies to their watchlist
- Rate movies
- Be effective on popularity index of movies
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
- **AuthController**
- **MovieController**
- **ActorController**
- **WatchlistController**
- **RatingController**

### Services
- **UserService**: Business logic for user operations.
- **MovieService**: Business logic for movie operations.
- **WatchlistService**: Business logic for watchlist operations.
- **RatingService**: Business logic for rating operations.
- **ActorService**: Business logic for actor operations.


### Repositories
- **UserRepository**: Interface for user data access.
- **MovieRepository**: Interface for movie data access.
- **WatchlistRepository**: Interface for watchlist data access.
- **RatingRepository**: Interface for rating data access.
- **ActorRepository**: Interface for actor data access.

### Entities
- **User**: Represents user entity.
- **Movie**: Represents movie entity.
- **Watchlist**: Represents watchlist entity.
- **Rating**: Represents rating entity.
- **Actor**: Represents Actor entity

## Frontend Implementation

### Components
- **LoginComponent**: 
- **RegisterComponent**: 
- **HomeComponent**:
- **MovieComponent**: 
- **FooterComponent**:
- **HeaderComponent**: 
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
This IMDb clone provides a robust platform for users to explore movies, manage their watchlist, and rate movies. The project demonstrates a full-stack application using Spring Boot for the backend and Angular for the frontend, showcasing essential features such as user authentication, CRUD operations, and user interaction with movies.
