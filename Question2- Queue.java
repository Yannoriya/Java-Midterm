
// Importing modules and packages
package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

// Creating a class that will generate a queue containing a 100 cars
public class queue {

    public Queue<Integer> traffic_queue(){
        // Creating a queue that will keep receiving cars
        Queue<Integer> traffic_queue =  new LinkedList<>();

        // Making a loop that will generate random cars from 0 to 99
        for(int i=0; i<100; i++){

            // This integer represents a randomely generated car
            Random car_id = new Random();

            // get a random number from the available ID that will serve as an identifier
            int rand_nbr = car_id.nextInt(100);
            traffic_queue.add(rand_nbr);
        }
        // once the queue is full it will be returned
        return traffic_queue;

    }

}
