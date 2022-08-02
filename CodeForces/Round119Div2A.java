import java.util.*;
import java.io.*;

public class Round119Div2A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);

        st = new StringTokenizer(br.readLine());

        int[] dp = new int[Integer.parseInt(st.nextToken())+1];
        int[] lengths = new int[3];
        for(int i = 0; i < 3;i++) {
            lengths[i] = Integer.parseInt(st.nextToken());
            if(lengths[i] < dp.length)
                dp[lengths[i]] = 1;
        }


        for(int i = 0; i < dp.length;i++){
            for(int j = 0; j < lengths.length;j++){
                if(i-lengths[j] >= 0 && dp[i-lengths[j]] != 0){
                    dp[i] = Math.max(dp[i],dp[i-lengths[j]]+1);
                }
            }
        }



        pw.println(dp[dp.length-1]);

        pw.close();
    }
}