# language: en
# encoding: utf-8

Feature: Popular Streaming Movies

  Background:
    Given the user clicks on view all button of popular streaming movies section

  @PopularStreamingMovies
  Scenario: Check if a movie is being displayed to be watched on Netflix
    Given the user clicks on the Netflix bubble button
    When selects the first movie listed
    Then "Netflix" bubble button must be displayed as the list of where to watch

  @PopularStreamingMovies
  Scenario: Apply filters and check if a movie is being displayed
    Given the user clicks on the Netflix bubble button
    When filters by the genre animation
    Then the movie "The Super Mario Bros. Movie" should be displayed

  @PopularStreamingMovies
  Scenario Outline: Apply a filter by genre and check if the first movie listed with on the correct genre
    Given the user filters by the genre <movieGenre>
    When selects the first movie listed
    Then the <movieGenre> must be displayed on the movie info
    Examples:
      | movieGenre |
      | 'Action' |
      | 'Comedy' |