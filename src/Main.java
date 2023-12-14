import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<int[]> airplanes = new ArrayList<>();
        // Test case: [[3, 8], [0, 5], [10, 18], [0, 3], [5, 10], [2, 6]]
        airplanes.add(new int[]{3, 8});
        airplanes.add(new int[]{0, 5});
        airplanes.add(new int[]{10, 18});
        airplanes.add(new int[]{0, 3});
        airplanes.add(new int[]{5, 10});
        airplanes.add(new int[]{2, 6});
        System.out.println(numberOfMechanics(airplanes));
    }

    // Pre: takes in List<int[]> schedule of times it takes to repair airplanes
    // Post: returns the minimum number of mechanics needed to repair said airplanes
    public static int numberOfMechanics(List<int[]> schedule) {

        List<int[]> breakdown = new ArrayList<>();


        // O(N) runtime, splits up start and end times and denotes which is which
        for (int[] airplane : schedule) {
            breakdown.add(new int[]{airplane[0], 1});  // Start event
            breakdown.add(new int[]{airplane[1], -1}); // End event
        }

        // O(nlogn) runtime, sorts all my runtimes by start, and then end.
        Collections.sort(breakdown, Comparator
                .comparingInt((int[] array) -> array[0])
                .thenComparingInt(array -> array[1]));


        int max = 0;
        int numMechanics = 0;

        // O(n) max runtime, determines the number of mechanics
        // needed at each time and stores the max.
        for (int[] time : breakdown) {
            numMechanics += time[1];
            max = Math.max(numMechanics, max);
        }

        return max;
    }




}