package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String loadData(Model model)
    {
        Actor a = new Actor();
        a.setName("Sandra Bullock");
        a.setRealname("Sandra Mea Bullowski");
        actorRepository.save(a);//save the actor w/o the a movie associated

        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About emojis...");
        movieRepository.save(movie);//saving the movie

        a.addMovie(movie);//link actor w the movie
        actorRepository.save(a);

        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}
