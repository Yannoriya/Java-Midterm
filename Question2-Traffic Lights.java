// Importing  modules and packages
package com.company;

import java.util.ArrayList;
import java.util.Random;

// Generating the different traffic lights colors
public class Traffic_lights {
    public String traffic_lightColor() {
        // Adding the different color of traffic lights to array
        ArrayList<String> traffic_colors = new ArrayList<String>();
        traffic_colors.add("Green");
        traffic_colors.add("Yellow");
        traffic_colors.add("Red");

        // Facilitating the element of randomness
        Random random_color = new Random();

        int i = random_color.nextInt(3);

        // Returning the traffic light color as a String
        String traffic_color = traffic_colors.get(i);
        return traffic_color;
    }
}
