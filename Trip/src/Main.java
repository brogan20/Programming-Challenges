import java.io.*;

class Main {
    static BufferedReader input;
    static BufferedWriter output;
    static int[] moneys;

    static String moneyChangeString = "";

    public static void main(String[] args) throws IOException{
        input = new BufferedReader(new InputStreamReader(System.in));
        output = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            getStudentsAndCost();
            findAverages();
            if (moneyChangeString.substring(moneyChangeString.indexOf('.')).length() != 3){
                moneyChangeString += 0;
            }
            output.write("$" + moneyChangeString + "\n");

        }
    }
    //Find how many students there are and get how much money each brought
    static void getStudentsAndCost() throws IOException{
        String num = input.readLine();
        if(num.equals("0")){
            output.close();
            System.exit(0);
        }
        moneys = new int[Integer.parseInt(num)];

        for(int i = 0; i< moneys.length; i++){
            moneys[i] = (int)Math.round(Double.parseDouble(input.readLine())*100);
        }
    }
    //Get average and find how much money needs to change
    static void findAverages(){
        //Find average
        int avg = 0;
        for (int num : moneys){
            avg += num;
        }
        avg = (int)Math.round((double)avg/moneys.length);

        //Find overpayments and underpayments
        int over = 0;
        int under = 0;
        for (int num : moneys){
            int difference = num - avg;
            if(difference > 0){
                over += difference;
            } else {
                under -= difference;
            }
            //Get the smaller one
        }
        if (under < over) {
            moneyChangeString = String.valueOf((double)under/100);
        } else {
            moneyChangeString = String.valueOf((double)over/100);
        }
    }
}