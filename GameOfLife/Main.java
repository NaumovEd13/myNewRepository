package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try {
            Game.startTheGame();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}