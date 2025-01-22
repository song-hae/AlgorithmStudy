package BackJoon;

import java.util.Arrays;
import java.util.Scanner;

public class _2309 {

    public static void main(String[] args) {

        /*
        1. 가능한 경우 중 '아무거나' 출력 -> 처음으로 성립하면 바로 리턴
        2. 9명 중 7명(9C7)의 합이 100
        3. 반대로 생각하면 9C2 -> 전체 합 - 2명의 합 = 100 이면 됨
        배열 사용, N이 작기 때문에 시간 복잡도 고려 x
         */
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++){
            arr[i] = sc.nextInt(); //난쟁이 키 모음
            sum += arr[i]; // 전체 합
        }
        Arrays.sort(arr); // 오름차 순 정렬

        for(int i = 0; i < 8; i++){
            for(int j = i+1; j < 9; j++){
                if(sum - arr[i] - arr[j] == 100){ // 전체 합 - 2명 == 100일 때
                    for(int k=0; k<9; k++){
                        if(k != i && k !=j) System.out.println(arr[k]); // 그 2명 빼고 출력
                    }
                    return; // 한 번 성립하면 바로 리턴
                }
            }
        }
    }
}