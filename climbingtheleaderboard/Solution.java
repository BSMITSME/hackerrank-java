package climbingtheleaderboard;

import static java.util.stream.Collectors.toList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import javax.management.openmbean.ArrayType;
import javax.print.DocFlavor.INPUT_STREAM;

class Result {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        // 1차
    //     Map<Integer, Integer> rankMap = new HashMap<>();
    //     List<Integer> arr = new ArrayList<>();
    
    //     int counter = 1;
    //     for (int i = 0; i<player.size(); i++ ){
            
    //         ranked.add(player.get(i));
    //         Collections.sort(ranked, Collections.reverseOrder());
    //         for (int a = 0; a<ranked.size(); a++){
    //             if (!rankMap.containsKey(ranked.get(a))){
    //                 rankMap.put(ranked.get(a), counter++);
    //             }
    //         }
            
    //         System.out.println("rankMap"+rankMap);
    //         arr.add(rankMap.get(player.get(i)));

    //     }

    //     return arr;
    // }
    // 2차 답변 (카피)
    HashSet<Integer> set=new HashSet<>(ranked);
        ranked=new ArrayList<>(set);
        Collections.sort(ranked, Collections.reverseOrder());


        List<Integer> answer=new ArrayList<>();
        for(int score: ranked){
            System.out.println(score);
        }

        for(int p:player){

            int left=0; //1
            int right=ranked.size()-1; //last
            int mid=0;

            int rank=0;
            while(left<=right){
                mid=(left+right)/2;
                if(p>ranked.get(mid)){
                    right=mid-1;
                }else{
                    left=mid+1;
                }

                if(p==ranked.get(mid)) break;
            }

            if(p<ranked.get(mid)){
                rank=mid+1;
            }else{
                rank=mid;
            }
            answer.add(rank+1);
        }


        for(int ans:answer){
            System.out.println(ans);
        }
        return answer;
    }
출처: https://red-mimmu.tistory.com/97 [개발자 밈무:티스토리]
}
public class Solution{
    
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());
        
        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
        
        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);
        
        System.out.println(result);

        bufferedReader.close();
        bufferedWriter.close();
    }
}