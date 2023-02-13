
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.util.List;

class Main {
    static int logn;
    static long[] node;
    static int[] arr;
    static int size;
    static ArrayList<Person> personArrayList=new ArrayList<Person>();
    public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    size=Integer.parseInt(br.readLine());
    logn=0;
    for(int i=1;i<size ;i*=2){
        logn++;
    }
    arr=new int[size+1];
    node=new long[(int)Math.pow(2,logn+1)];
    int firstindex=(int)Math.pow(2,logn);

    StringBuilder sb=new StringBuilder();
    for(int i=0;i<size;i++){
        personArrayList.add(new Person(i,Integer.parseInt(br.readLine())));
    }
    Collections.sort(personArrayList);
    for(int i=0;i<size;i++){
        personArrayList.get(i).skill=i+1;
    }
    Collections.sort(personArrayList,(a,b)->a.id-b.id);
    for(int i=0;i<size;i++){
        Person p=personArrayList.get(i);
        makehap(firstindex+p.skill-1,1);
        int start=firstindex;
        int end=firstindex+p.skill-1;
        int sum=0;
        while(start<=end){
            if(start%2==1){sum+=node[start++];}
            if(end%2==0){sum+=node[end--];}
            start/=2;
            end/=2;
            if(sum==i+1){break;}
        }
        sb.append(i-sum+2).append("\n");


    }
        System.out.println(sb);
    }

    static void makehap(int index,int sum){
        int temp=index;
        while(temp!=0){
            node[temp]+=sum;
            temp/=2;
        }
    }



    }
class Person implements Comparable<Person>{
    int id;
    int skill;
    Person(int id,int skill){
        this.id=id;
        this.skill=skill;
    }
    @Override
    public int compareTo(Person p){
        return Integer.compare(this.skill,p.skill);
    }
}





