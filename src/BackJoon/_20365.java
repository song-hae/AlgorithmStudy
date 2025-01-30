package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20365 {

    public static void main(String[] args) throws IOException {
        /*
        한 번에 한 색으로 칠하고 그 뒤에 다른 거 덧 씌우기, B와 R 블록으로 생각
        B>R, 1 + R개수/ B<R, 1 + B개수
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        char[] arr = s.toCharArray();

        int rcnt = 0; int bcnt = 0;

        if(arr[0] == 'B') bcnt++;
        else rcnt++;

        for(int i = 0; i < n-1; i++){
            if(arr[i] == 'B' && arr[i+1] == 'R'){
                rcnt++;
            }
            else if(arr[i] == 'R' && arr[i+1] == 'B'){
                bcnt++;
            }
        }
        System.out.println(Math.min(rcnt, bcnt) + 1);
   }
}
