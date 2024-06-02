# SE 3355 Ali Kağan Bertizlioğlu IMDb Clone Project

This project is an IMDb clone that incorporates a robust architecture based on N-layered design and adheres to SOLID principles. It allows users to register, login, add movies to their watchlist, and rate movies.

## Table of Contents
1. [Project Structure](#project-structure)
2. [Database and Relationships](#db-relationships)
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
foto gelcek


### Frontend (Angular)
- `src/test`
  - `test`
  - `test`
  - `test`

 
  
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
