

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int size;
    static HashSet<String> hashSet=new HashSet<>();//식을 담을 해쉬셋

    static boolean[] strVisted;//괄호를 구분하여 식을 만들기위해 식의 boolean[] 배열
    static String str;//입력받을 식
    static ArrayList<Point> points;//괄호 짝을 지어줄 Point List
    static boolean isFirst=true;//입력받는 식을 담으면 안되니 boolean 선언
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        Stack<Integer> stack = new Stack<>();//(의 인덱스를 담을 스택
        points=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                stack.push(i);
            }
            else if(str.charAt(i)==')'){
                points.add(new Point(stack.pop(),i));//괄호끼리 짝 될시 point list에 추가
            }
            else{continue;}
        }
        strVisted = new boolean[str.length()];//괄호를 구분하여 만들기위해 입력 받은 식의 boolean형 배열
        Arrays.fill(strVisted, true);
        dfs(0);
        StringBuilder answer=new StringBuilder();
        ArrayList<String> arrayList=new ArrayList<>();
        for(String s:hashSet){
        arrayList.add(s);//사전식 정렬을 위해 hashSet을 arraylist에 담아주기
        }
        Collections.sort(arrayList);//정렬
        for(String s: arrayList){
            answer.append(s).append("\n");
        }
        System.out.print(answer);

    }
    static void dfs(int index){
        StringBuilder sb=new StringBuilder();
        if(index==points.size()){//괄호를 담을지 말지 다 정해지면 문장 만들기
            if(isFirst){//입력받은 식이라면 HashSet에 안넣어주고 return
                isFirst=false;

            }
            else{for(int i=0;i<str.length();i++){
                if(strVisted[i]){
                    sb.append(str.charAt(i));
                }
            }
            hashSet.add(sb.toString());}
            return;
        }
        Point p= points.get(index);
        strVisted[p.x]=true;
        strVisted[p.y]=true;
        dfs(index+1);//괄호  p를 담을 식
        strVisted[p.x]=false;
        strVisted[p.y]=false;
        dfs(index+1);//괄호 p를 안 담을 식





    }
}
