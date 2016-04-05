package com.javarush.test.level21.lesson16.big01;


import java.util.ArrayList;

public class Hippodrome
{

    private ArrayList<Horse> horses = new ArrayList<>();

    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {

        game = new Hippodrome();

        game.getHorses().add(new Horse("horseName1",3,0));
        game.getHorses().add(new Horse("horseName2",3,0));
        game.getHorses().add(new Horse("horseName3",3,0));

        game.run();
        game.printWinner();

    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move () {
        for (Horse horse : horses)
            horse.move();
    }

    public void print() {
        for (Horse horse : horses)
            horse.print();
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {

        double maxDistance = 0;
        Horse winnerHorse = null;

        for (Horse horse : horses) {
            if (horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
                winnerHorse = horse;
            }
        }

        return winnerHorse;
    }

    public void printWinner() {

        System.out.println("Winner is " + getWinner().getName() +"!");
    }

}
