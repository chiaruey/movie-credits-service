package com.ruey.movie.credit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.ruey.movie.credit.model.MovieCredits;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/movie-credits")
public class MovieCreditsService {

	private static final String PATH = "/movie/";
	
	private Logger logger = LoggerFactory.getLogger(MovieCreditsService.class);
	
    @Value("${themoviedb.api.key}")
    private String apiKey;

    @Value("${themoviedb.url}")
    private String url;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping
	@ApiOperation(value = "Movie Credits", notes = "Return the movie credits by movie id", response = MovieCredits.class)
    public MovieCredits getMovieById(@RequestParam("movieId") String movieId) {
    	String queryUrl = url + PATH + movieId + "/credits?api_key=" +  apiKey;
    	logger.debug("queryUrl = " + queryUrl);
    	MovieCredits movieDetail = restTemplate.getForObject(queryUrl, MovieCredits.class);
        return movieDetail;
    }


}
