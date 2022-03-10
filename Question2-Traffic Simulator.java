

// Importing modules and packages 
package com.company;

import java.util.Iterator;
import java.util.Queue;

// Creating a class that will simulate the traffic program
public class Traffic_sim {
    public static void main (String[] args) throws InterruptedException{

        // Starting a new queue of cars
        queue road_circulation = new queue();
        Queue<Integer> cars = road_circulation.traffic_queue();

        
        // Simulating the traffic flow
        Iterator<Integer> iterator = cars.iterator();

        // Loop the simulation
        while (cars.size() > 1) {

            // Generating a traffic light
            Traffic_lights traffic_light = new Traffic_lights();
            String color = traffic_light.traffic_lightColor();

            // Cars will act according to the color of the traffic lights and the program will show the user how many cars are left in the queue
            if (color.equals("Green")) {
                int j = 0;

                while (j < 31 && iterator.hasNext()) {
                    System.out.println("The light is now green, you can move ");
                    Thread.sleep(1000);
                    cars.remove();
                    System.out.println(cars.size() + " Cars remaining in the traffic queue");
                    j++;
                }
            } else if (color.equals("Yellow")) {
                int k = 0;
                while (k <= 11 && iterator.hasNext()) {
                    System.out.println("The light is now yellow, be cautious of the red light");
                    Thread.sleep(1000);
                    cars.remove();
                    System.out.println(cars.size() + " Cars remaining in the traffic queue");
                    k ++;
                }
            } else if (color.equals("Red")) {
                int i= 0;
                while (i <= 21) {
                    System.out.println("The light is now red, don't move");
                    Thread.sleep(1000);
                    System.out.println(cars.size() + " Cars remaining in the traffic queue");
                    i++;

                }
            }


        }
        // The program ends as soon as the queue is empty
        System.out.println("No more cars are left in the queue");
    }
}
