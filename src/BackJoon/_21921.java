package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21921 {

            public static void main(String[] args) throws IOException {

        /*
        N일 중 X일 동안 가장 많이 들어온 방문자 수 (없으면 SAD)
        경우의 수 출력

        i ~ i+X만큼의 기간의 합을 구해서 변수에 저장
        만약 새로 구한 값이 max보다
        크다 -> 바꿈
        작다 -> 그대로
        똑같다 -> cnt+

        O(N^2)은 안 됨.. 근데 O(N^2)이네..
        -> Sliding Window Algorithm
        */
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());

                int len = Integer.parseInt(st.nextToken());
                int[] arr = new int[len];
                int x = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());

                for(int i=0; i<len; i++){
                    arr[i] = Integer.parseInt(st.nextToken());
                }
/*          기존에 생각했던
                int cnt = 0;
                int maxValue = 0;
                for(int i=0; i<len-x+1; i++){
                    int sum = 0;
                    for(int j=0; j<x; j++){
                        sum += arr[i+j];
                    }
                    if(maxValue < sum){ // 합이 기존 maxValue 보다 크면
                        maxValue = sum; // 바꿔줌
                        cnt = 1; // cnt 1로 초기화
                    }
                    else if(maxValue == sum) { //합이 기존 maxValue 와 같으면
                        cnt++; // cnt 올려줌
                    }
                }
 */
                int sum = 0;
                for(int i=0; i<x; i++){ // 첫 윈도우 계산
                    sum += arr[i];
                }

                int maxValue = sum; // 첫 윈도우로 maxValue 초기화
                int cnt = 1; // cnt 1로 초기화 (첫 윈도우로 이미 cnt 가 올라가야 하니까)

                for(int i=x; i<len; i++){
                    sum = sum + arr[i] - arr[i-x]; // 첫 번째 수를 빼고, 다음 수 하나를 더해줌, 창문 밀기
                    if(maxValue < sum){
                        maxValue = sum;
                        cnt = 1;
                    }else if(maxValue == sum){
                        cnt++;
                    }
                }

                if(maxValue == 0){
                    System.out.print("SAD");
                }else{
                    System.out.println(maxValue);
                    System.out.println(cnt);
                }
            }
        }
