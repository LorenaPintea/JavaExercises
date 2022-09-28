package Minecraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// We need you to build a small application that receives the terrain levels and outputs the amount of
// water blocks that would be on that terrain.
// Example Input: [3,2,1,3,1,1,2,1,2]
// Example Output: 6
public class Main {
    // I assume that I already know the edges don't have water blocks + the water blocks level can't be higher than the
    // terrain blocks level (for that specific portion) so if I calculate the area of each figure (rectangle) and subtract
    // the sum of the array's elements between the indexes then I get the amount of water blocks
    public static int count(List<Integer> list) {
        // return 0 if no element is in the list or if it's just the edges
        if (list.size() <= 2) {
            return 0;
        }

        int count = 0;
        int first = list.get(0);
        int last = list.get(list.size() - 1);
        int index = 0;

        for(int i = 1; i < list.size(); i++) {
            //compare the first element to the current one in order to check if we found the edge
            if (first <= list.get(i)) {
                // I considered every figure as a rectangle and checked to see what's the minimum
                // then I calculated the area of the rectangle and subtracted the sum of the list between the 2 edges
                count += (first * list.subList(index, i + 1).size()) - (list.subList(index, i).stream()
                        .mapToInt(Integer::intValue).sum() + first);
                index = i;
                first = list.get(i);
            }

            // in case the last terrain blocks level is < than the one before it, we check to see if we are indeed at
            // the end and if the edges are indeed different, if so we compute the area and subtract the sum.
            if(i == list.size() - 1 && first != last) {
                count += ((last * list.subList(index - 1, i + 1).size()) - (list.subList(index, i + 1).stream()
                        .map(e -> e > last ? last : e).mapToInt(Integer::intValue).sum() + last));
            }
        }

        return count;
    }
}