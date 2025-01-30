package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _11047 {

    public static void main(String[] args) throws IOException {
        /*

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(br.readLine());
            if(a <= k) list.add(a);
        }

        Collections.sort(list, Collections.reverseOrder());

        int answer = 0;
        for(int i=0 ; i<list.size(); i++){
                if(k==0) break;
                answer += k/list.get(i);
                k = k%list.get(i);
        }

        System.out.println(answer);
    }
}
