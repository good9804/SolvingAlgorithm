

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int setSize = Integer.parseInt(stringTokenizer.nextToken());//집합 S의 문자열 개수
        int checkSize = Integer.parseInt(stringTokenizer.nextToken());//검사해야하는 문자열 개수
        HashSet<String> hashSet = new HashSet<>();//HashSet
        for(int i=0;i<setSize;i++){
            hashSet.add(br.readLine());//집합 S에 문자열 넣어주기
        }
        int answer=0;//답
        for(int i=0;i<checkSize;i++){
            if(hashSet.contains(br.readLine())){//만약 검사하는 문자열이 집합에 포함된다면 답++
                answer++;
            }
        }
        System.out.print(answer);
    }
}
