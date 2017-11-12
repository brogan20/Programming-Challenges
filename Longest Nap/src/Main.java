import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int day = 0;
        String num = "";
        while (!(num = input.readLine()).equals("") && input.ready()) {
            ArrayList<Integer> start = new ArrayList<>();
            ArrayList<Integer> end = new ArrayList<>();
            ArrayList<Integer> openTimes = new ArrayList<>();
            day++;
            int appointments = Integer.parseInt(num);
            for (int appointment = 0; appointment < appointments; appointment++) {
                //Splits inputs into the start and end time of each appointment
                //Also puts the info about appointments into in[2] but that's irrelevant
                String[] in = input.readLine().split(" ");
                int startHour;
                int startMin;
                int endHour;
                int endMin;
                //Get start time of the appointments
                startHour = Integer.parseInt(in[0].substring(0, in[0].indexOf(":"))) * 60;
                startMin = Integer.parseInt(in[0].substring(in[0].indexOf(":") + 1));
                start.add(startHour + startMin);
                //Get end time of each appointment
                endHour = Integer.parseInt(in[1].substring(0, in[1].indexOf(":"))) * 60;
                endMin = Integer.parseInt(in[1].substring(in[1].indexOf(":") + 1));
                end.add(endHour + endMin);
            }
            //Should keep the same pairings but put them in order
            Collections.sort(start);
            Collections.sort(end);

            //Sets start.size = end.size+1
            //Will be needed for the loop
            start.add(1080);

            //Go through the differences between the ends to the starts
            //Finds the longest possible nap
            //Ensures the beginning isn't skipped
            int longestNap = start.get(0) - 600;
            int time = 600;
            int nap;
            for (int i = 0; i < end.size(); i++) {
                nap = start.get(i + 1) - end.get(i);
                if (nap > longestNap) {
                    longestNap = nap;
                    time = end.get(i);
                }
            }
            int mins = time % 60;
            if (mins == 0) {
                if (longestNap < 60) {
                    System.out.printf("Day #%d: the longest nap starts at %d:00 and will last for %d minutes.\n", day, time / 60, longestNap);
                } else {
                    System.out.printf("Day #%d: the longest nap starts at %d:00 and will last for %d hours and %d minutes.\n", day, time / 60, longestNap / 60, longestNap % 60);
                }
            } else if (mins < 10) {
                if (longestNap < 60) {
                    System.out.printf("Day #%d: the longest nap starts at %d:0%d and will last for %d minutes.\n", day, time / 60, time % 60, longestNap);
                } else {
                    System.out.printf("Day #%d: the longest nap starts at %d:0%d and will last for %d hours and %d minutes.\n", day, time / 60, time % 60, longestNap / 60, longestNap % 60);
                }
            } else {
                if (longestNap < 60) {
                    System.out.printf("Day #%d: the longest nap starts at %d:%d and will last for %d minutes.\n", day, time / 60, time % 60, longestNap);
                } else {
                    System.out.printf("Day #%d: the longest nap starts at %d:%d and will last for %d hours and %d minutes.\n", day, time / 60, time % 60, longestNap / 60, longestNap % 60);
                }
            }

        }
    }
}
