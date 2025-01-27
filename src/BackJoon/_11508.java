package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class _11508 {

    public static void main(String[] args) throws IOException {
        /*
        2차원 배열에 3개씩 가격을 저장해서 가장 낮은 값을 제외한채로 더 함
        마지막 배열에 0이 있으면 다 더함 (3개 안 사서 할인 x)
        3개보다 덜 사도 다 더함 (3개 안 사서 할인 x)
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        int sum = 0;

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i=0; i<n; i++) {
            if(i % 3 != 2) sum += arr[i];
        }

        System.out.println(sum);
    }
}
