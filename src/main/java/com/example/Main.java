package com.example;

import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet{

        public static int x;
    public static int y;
    public static boolean check = false;
    public static boolean blokeCrash;
    public static PApplet p;
    public Human h = new Human();
    public static ArrayList<Bloke> blokes = new ArrayList<Bloke>();
    public static int level = 0;
    public static int score = 0;

    
    public static void main(String[] args) {
        PApplet.main("com.example.Main", args);
    }

    @Override
    public void setup(){
        p = this;
        blokes.add(new Bloke((int) random(10, 255), (int) random(10, 255), (int) random(10, 255), 10, 11, 1));
        blokes.add(new Bloke((int) random(10, 255), (int) random(10, 255), (int) random(10, 255), 100, 12, 1));
        blokes.add(new Bloke((int) random(10, 255), (int) random(10, 255), (int) random(10, 255), 200, 13, 1));
        blokes.add(new Bloke((int) random(10, 255), (int) random(10, 255), (int) random(10, 255), 300, 14, 1));
        blokes.add(new Bloke((int) random(10, 255), (int) random(10, 255), (int) random(10, 255), 360, 15, 1));
        blokes.add(new Bloke((int) random(10, 255), (int) random(10, 255), (int) random(10, 255), 30, -100, 1));
        blokes.add(new Bloke((int) random(10, 255), (int) random(10, 255), (int) random(10, 255), 90, -101, 1));
        blokes.add(new Bloke((int) random(10, 255), (int) random(10, 255), (int) random(10, 255), 300, -102, 1));



    }

    @Override
    public void settings(){
        size(400, 700);
    }

    @Override
    public void draw() {
        if(!check){
            background(0);
            for (Bloke bloke : blokes) {
                bloke.makeAndShow();
            }
            for (Bloke bloke : blokes) {
                bloke.setBlokeY(bloke.getBlokeY()+4 + bloke.getSpeedY());
            }
            strokeWeight(2);
            stroke(255);
            line(0, 600, 400, 600);
            h.makeAndShow();

            //if a bloke is gone, make a new one in ransom a place.
            
            for (Bloke bloke : blokes) {
                if (bloke.getBlokeY() > 700) {
                    blokes.remove(bloke);
                    Bloke.addBloke();
                    break;
                }
            }

            //if level is 20+ add a new bloke

            if (level > 20) {
                level = 0;
                score++;
                Bloke.addBloke();
            }

            textSize(20);
            text("Score: " + String.valueOf(score) , 10, 100);
            
            //check for crashes
            crash();
        }else{
            background(0);
            fill(252, 3, 7);
            textSize(70);
            text("Game Over", 50, 300);
            textSize(30);
            text("your score is: " + String.valueOf(score), 100, 450);
        }
    }

    public void crash(){
        for (Bloke bloke : blokes) {
            if (bloke.getBlokeY() + 60 > 580 && bloke.getBlokeY() < 600) {
                if (mouseX + 4 > bloke.getBlokeX() && mouseX -2 <= bloke.getBlokeX() + 30) {
                    Main.check = true;
                }
            }
        }
    }

}