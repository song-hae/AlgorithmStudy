package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1940 {

    public static void main(String[] args) throws IOException {

        /*
        N : A 개수
        M : A 중 2개를 합쳐서 나와야 하는 값
        A : 수들

        이거 A를 배열에 넣고, 순회하면서 M - A의 원소가 배열에 존재하는지를 따져서 cnt를 올리면 됨
        다만 전체를 다 돌면 중복이 포함되기 때문에 /2 (고유한 번호라 중복은 없으니 무조건 2배)
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<len; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        for(int i=0; i<len; i++){
            if(list.contains(m - list.get(i))){
                cnt++;
            }
        }
        System.out.println(cnt/2);

    }
}