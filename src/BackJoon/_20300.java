package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _20300 {

    public static void main(String[] args) throws IOException {
        /*
        n개의 운동기구 중 2개의 근손실 정도의 합이 최소가 되도록
        -> n이 짝수이면, 오름차순 정렬 시, a[0] + a[n-1], a[1] + a[n-2], ... a[i] + a[n-(1+i)]로
        -> n이 홀수이면, 오름차순 정렬 시,a[0] + a[n-2], a[1] + a[n-3], ... a[i] + a[n-(i+2)]로 하고, a[n] 따로
        10^18까지 원소로 들어갈 수 있기 때문에 long 배열 사용
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long m = 0;
        if(n%2 == 0){
            for(int i = 0; i < n/2; i++){
                m = Math.max(m, arr[i] + arr[n-(i+1)]);
            }
        } else{
            m = arr[n-1];
            for(int i = 0; i < n/2; i++){
                m = Math.max(m, arr[i] + arr[n-(i+2)]);
            }
        }
        System.out.println(m);
    }
}
