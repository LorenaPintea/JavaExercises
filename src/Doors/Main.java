package Doors;

import java.util.*;

public class Main {

    static boolean isPrime(int number) {
        //this method checks if a number is prime or not
        if (number < 1) {
            return false;
        }
        else {
            for(int i = 2; i <= number/2; i++) {
                if(number % i == 0) return false;
            }
            return true;
        }
    }

    static void bruteForce(int n) {
        //declare the list of doors
        List<List<Integer>> doors = new ArrayList<>();

        // check every possibility and if the criteria fits then add the pair into the list
        // 1st position: doesn't want odd numbers
        // 2nd position: just prime numbers
        // 3rd position: doesn't allow numbers that end in 3
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if ((i % 2 == 0) && (isPrime(j)) && (k % 10 != 3) && i != j && j != k && i != k) {
                        doors.add(Arrays.asList(i, j, k));
                    }
                }
            }
        }

        System.out.println(doors);
        System.out.println("Total: " + doors.size());
    }

    static void littleTimeOptimization(int n) {
        //declare the lists of doors
        List<Integer> sherifDoors = new ArrayList<>();
        List<Integer> fireChiefDoors = new ArrayList<>();
        List<Integer> courtDoors = new ArrayList<>();
        List<List<Integer>> finalDoors = new ArrayList<>();

        // check the criteria for each door and if TRUE add it into its specific list
        for(int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sherifDoors.add(i);
            }
            if (isPrime(i)) {
                fireChiefDoors.add(i);
            }
            if(i % 10 != 3) {
                courtDoors.add(i);
            }
        }

        // loop through the lists and pair them
        for (Integer sherifDoor : sherifDoors) {
            for (Integer fireChiefDoor : fireChiefDoors) {
                for (Integer courtDoor : courtDoors) {
                    if (!sherifDoor.equals(fireChiefDoor) && !fireChiefDoor.equals(courtDoor)
                            && !sherifDoor.equals(courtDoor)) {
                        finalDoors.add(Arrays.asList(sherifDoor, fireChiefDoor, courtDoor));
                    }
                }
            }
        }

        System.out.println(finalDoors);
        System.out.println("Total: " + finalDoors.size());
    }

    public static void main(String[] args) {
        bruteForce(99);
        littleTimeOptimization(99);
    }
}
