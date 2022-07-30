import java.util.*;
import java.io.*;
public class Round260Div1A {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);

        int len = Integer.parseInt(br.readLine());
        long[] freq = new long[100001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < len;i++)
            freq[Integer.parseInt(st.nextToken())]++;

        long[] dp = new long[100001];
        dp[1] = freq[1];
        for(int i = 2; i < dp.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+freq[i]*i);
        }


        pw.println(dp[100000]);

        pw.close();
    }
}
