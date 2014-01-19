package net.chitta.cinema;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
/**
 * 25th Mar @0900
 */
public class Movie implements Serializable 
{
    private String title;
    private String rating;
    private String director; 
    private String actors;
    private String synopsis; 
    private String clip;

    public Movie(String titleIn, String ratingIn, String directorIn, String actorsIn, String synopsisIn, String clipIn)   
    {    
        title = titleIn;
        rating = ratingIn;
        director = directorIn;
        actors = actorsIn;
        synopsis = synopsisIn;
        clip = clipIn;       
    }

    public boolean equals(Object o){        
        if (o instanceof Movie){
            Movie m = (Movie)o;
            return m.getTitle().equals(this.title) && 
            m.getRating().equals(this.rating)&& 
            m.getDirector().equals(this.director)&&
            m.getActors().equals(this.actors)&& 
            m.getSynopsis().equals(this.synopsis)&&
            m.getClip().equals(this.clip);
        }
        return false;
    }

    public String toString(){
        return "Movie Title: " + title + " Age Rating: " + rating + " Director " + director + "Actors " + actors + " Synopsis " + synopsis + "Short Clip " + clip;
    }

    public String getTitle()
    {
        return title;
    }

    public String getRating()
    {
        return rating;
    }

    public String getDirector()
    {
        return director;
    }

    public String getActors()
    {
        return actors;
    }

    public String getSynopsis()
    {
        return synopsis;
    }

    public String getClip()
    {
        return clip;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setClip(String clip) {
        this.clip = clip;
    }

}    



		