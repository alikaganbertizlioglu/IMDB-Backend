# SE 3355 Ali Kağan Bertizlioğlu IMDb Clone Project

This project is an IMDb clone that allows users to register, login, add movies to their watchlist, and rate movies. The backend is implemented using Spring Boot and the frontend is developed with Angular.

## Table of Contents
1. [Introduction](#introduction)
2. [Project Structure](#project-structure)
3. [Backend Implementation](#backend-implementation)
4. [Frontend Implementation](#frontend-implementation)
5. [Features](#features)
6. [Installation and Setup](#installation-and-setup)
7. [Usage](#usage)
8. [API Endpoints](#api-endpoints)
9. [Conclusion](#conclusion)

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
- **AuthController**: 
- **MovieController**:
- **ActorController**: 
- **WatchlistController**:
- **RatingController**: 

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
- **WatchlistService**: Manages watchlist operations.
- **RatingService**: Manages rating operations.

### Models
- **User**: Represents user data.
- **Movie**: Represents movie data.
- **Watchlist**: Represents watchlist data.
- **Rating**: Represents rating data.

## Features
- **User Registration**: Users can register with email, name, password, city, and country.
- **User Login**: Registered users can log in to access their account.
- **Movie Management**: Users can view movie details.
- **Watchlist Management**: Users can add movies to their watchlist.
- **Movie Rating**: Users can rate movies.

## Installation and Setup

### Backend
1. Clone the repository.
2. Navigate to the backend directory: `cd backend`.
3. Install dependencies: `mvn install`.
4. Configure the `application.properties` file with your database settings.
5. Run the application: `mvn spring-boot:run`.

### Frontend
1. Navigate to the frontend directory: `cd frontend`.
2. Install dependencies: `npm install`.
3. Run the application: `ng serve`.

## Usage
1. Register a new user.
2. Login with the registered user credentials.
3. Browse movies and add them to your watchlist.
4. Rate movies as per your preference.

## API Endpoints

### User Endpoints
- `POST /api/users/register`: Register a new user.
- `POST /api/users/login`: User login.

### Movie Endpoints
- `GET /api/movies`: Get all movies.
- `GET /api/movies/{id}`: Get movie details by ID.

### Watchlist Endpoints
- `GET /api/watchlists`: Get the user's watchlist.
- `POST /api/watchlists/{movieId}`: Add a movie to the user's watchlist.

### Rating Endpoints
- `POST /api/ratings`: Rate a movie.

## Conclusion
This IMDb clone provides a robust platform for users to explore movies, manage their watchlist, and rate movies. The project demonstrates a full-stack application using Spring Boot for the backend and Angular for the frontend, showcasing essential features such as user authentication, CRUD operations, and user interaction with movies.
