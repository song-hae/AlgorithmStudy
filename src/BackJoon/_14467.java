package BackJoon;

import java.util.HashMap;
import java.util.Scanner;

public class _14467 {

    //1. 첫 N으로 반복문
    //2. 해시맵에 넣기 (이미 있으면 안 넣기)
    //3. 이미 있으면 value 더해서 1이면 cnt++ 아니면 말고

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //반복 횟수
        int cnt = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int cowNum = sc.nextInt(); // 소 번호
        int cowLoc = sc.nextInt(); // 소 위치
        map.put(cowNum, cowLoc);

        for(int i=1 ; i<n ; i++){
            cowNum = sc.nextInt();
            cowLoc = sc.nextInt();
            if(map.containsKey(cowNum)){
                if(map.get(cowNum) +cowLoc ==1) {
                    cnt++;
                    map.replace(cowNum,cowLoc);
                }
            }else map.put(cowNum,cowLoc);
        }
        System.out.println(cnt);
    }
}
