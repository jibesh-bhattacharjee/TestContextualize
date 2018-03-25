package com.nitm.testcontextualize;

/**
 * Created by Jibesh Bhattacharjee on 21-03-2018.
 */

public class Article {
    //Instance Vars
    private String tag;
    private String heading;
    private String description;

    //Constructor
    public Article(String t,String h, String d){
        tag = t;
        heading = h;
        description = d;
    }

    public Article(String h, String d){
        heading = h;
        description = d;
    }

    public  Article(){

    }

    //Methods
    public void setTag(String t){
        tag = t;
    }

    public void setDescription(String d){
        description = d;
    }

    public String getTag(){
        return tag;
    }

    public String getHeading(){
        return heading;
    }

    public String getDescription(){
        return description;
    }

}
