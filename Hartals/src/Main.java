import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(input.readLine().trim());
        for(int i = 0; i < T; i++){
            int days = Integer.parseInt(input.readLine().trim());
            int[] HNums = new int[Integer.parseInt(input.readLine().trim())];
            for(int j = 0; j< HNums.length; j++){
                HNums[j] = Integer.parseInt(input.readLine().trim());
            }
            int hartals = 0;
            int weekend = 7;
            for(int day = 1; day < days+1; day++){
                if(day%weekend != 0 && day%(weekend-1) != 0) {
                    for (int party = 0; party < HNums.length; party++) {
                        if (day % HNums[party] == 0) {
                            hartals++;
                            break;
                        }
                    }
                }
                if(day%7 ==0) weekend += 7;
            }
            System.out.println(hartals);
        }
    }
}
