import java.util.*;
import java.lang.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Node[] nodes=new Node[strings.length];
        for(int i=0;i<strings.length;i++){
            nodes[i]=new Node(strings[i],n,i);
        }
        Arrays.sort(nodes);
        String[] answer=new String[strings.length];
        for(int i=0;i<strings.length;i++){
            answer[i]=nodes[i].word;
        }
        return answer;
    }
}
class Node implements Comparable<Node>{
    String word;
    int n;
    int index;
    public Node(String word,int n,int index){
        this.word=word;
        this.n=n;
        this.index=index;
    }
    @Override
    public int compareTo(Node node){
        if(this.word.charAt(n)==node.word.charAt(n)){
            return this.word.compareTo(node.word);
        }else return this.word.charAt(n)-node.word.charAt(n);}
    
}