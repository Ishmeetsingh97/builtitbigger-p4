package com.example;

import java.util.Random;

public class Jokes {

    private Random r = new Random();


    public String getJokes()
    {
        String jokes=null;
        switch(r.nextInt(3))
        {
            case 0:
                jokes = "Client to designer It doesnt really look purple. It looks more like a mixture of red and blue";
                break;

            case 1:
                jokes = "Instagram is just Twitter for people who go outside";
                break;

            case 2:
                jokes="Hate to break it to you Facebook but the entire Internet is already a Dislike button";
                break;
        }
        return jokes;
    }
}
