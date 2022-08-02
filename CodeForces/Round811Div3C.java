import java.util.*;
import java.io.*;

public class Round811Div3C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);

        int c = Integer.parseInt(br.readLine());

        while(c-->0){
            int sum = Integer.parseInt(br.readLine());
            int curSum = 0;
            int number = 0;
            int i = 0;
            int digit = 9;
            HashSet<Integer> used = new HashSet<>();
            while(true){
                if(curSum+digit<=sum){
                    curSum+=digit;
                    number += (int)Math.pow(10,i)*digit;
                    used.add(digit);
                    digit--;
                    i++;
                }else{
                    for(int j = digit;j >= 0;j--){
                        if(curSum+j<=sum && used.add(j)){
                            number += (int)Math.pow(10,i)*j;
                            curSum+=j;
                            used.add(j);
                        }
                    }
                    i++;
                }

                if(curSum == sum)
                    break;
            }


            pw.println(number);
        }



        pw.close();
    }
}
