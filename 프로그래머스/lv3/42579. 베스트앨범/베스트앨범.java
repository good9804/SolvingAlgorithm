import java.lang.*;
import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String,Integer> playsum=new HashMap<>();
        HashMap<String,Queue<Song>> map=new HashMap<>();
        //장르별로 가장많이 재생된 노래 2개씩모아 베스트앨범목적 노래는 id로 구분
        //기준 1. 속한노래가 많이 재생된 장르먼저 수록,
        //2.장르내에서 많이재생된노래 수록
        //3.장르내에서 재생횟수가같으면 고유번호가 낮은놈먼저수록
        //4노래의 장르를 나타내는 genres,노래별 재생횟수 나타내는 정수 play,베스트앨범에들어갈 노래           의          고유번호를 순서대로 리턴
        /*genres[i]는 고유번호가 i인 노래의 장르입니다.
        plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
        genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
        장르 종류는 100개 미만입니다.
        장르에 속한 곡이 하나라면, 하나의 곡만 출력 */
        for(int i=0;i<genres.length;i++){
            String genre=genres[i];
            playsum.put(genre,playsum.getOrDefault(genre,0)+plays[i]);
            if(map.containsKey(genre)){
                if(map.get(genre).size()==1){
                    if(map.get(genre).peek().play>plays[i]){
                        map.get(genre).add(new Song(plays[i],i));}
                    else{
                        Song song=map.get(genre).poll();
                        if(song.play==plays[i]){
                            map.get(genre).add(song);
                            map.get(genre).add(new Song(plays[i],i));
                        }
                        else{
                            map.get(genre).add(new Song(plays[i],i));
                            map.get(genre).add(song);}
                    }
                }
                else{

                    Song[] arr=new Song[3];

                    Song a1=map.get(genre).poll();
                    Song a2=map.get(genre).poll();
                    arr[0]=a1;
                    arr[1]=a2;
                    arr[2]=new Song(plays[i],i);

                    Arrays.sort(arr, new Comparator<Song>() {
                        @Override
                        public int compare(Song c1, Song c2) {
                            if(c1.play==c2.play){
                                return Integer.compare(c1.num, c2.num);
                            }
                            else return Integer.compare(c2.play,c1.play);
                        }
                    });
                    map.get(genre).add(arr[0]);
                    map.get(genre).add(arr[1]);
                }

            }
            else{
                Queue<Song> a=new LinkedList<>();
                a.add(new Song(plays[i],i));
                map.put(genre,a);
            }

        }
        List<String> keySet = new ArrayList<>(playsum.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return playsum.get(o2).compareTo(playsum.get(o1));
            }
        });

        ArrayList<Integer> answers=new ArrayList<>();
        for(String s:keySet){
            while(!map.get(s).isEmpty()){
                answers.add(map.get(s).poll().num);
            }
        }
        int[] array=new int[answers.size()];
        int k=0;
        for(int i=0;i<array.length;i++){
            array[i]=answers.get(i);
        }


        return array;
    }


}
class Song{
    int play;
    int num;
    public Song(int play,int num){
        this.play=play;
        this.num=num;
    }
}
