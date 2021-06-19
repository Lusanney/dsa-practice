package io.algoexpert.easy.tournamentwinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        int maxScore = 0;
        String maxPlayer = competitions.get(0).get(1);

        Map<String, Integer> scoreMap = new HashMap<>();

        for(int i=0; i < competitions.size(); i++){
            ArrayList<String> competition = competitions.get(i);
            String winner;
            if(results.get(i) == 0)
                winner = competition.get(1);
            else
                winner = competition.get(0);

            Integer winnerScore = scoreMap.get(winner);

            if(winnerScore == null)
                winnerScore = 0;

            scoreMap.put(winner, winnerScore + 3);

            if(winnerScore + 3 > maxScore){
                maxScore = winnerScore + 3;
                maxPlayer = winner;
            }

        }

        return maxPlayer;
    }

    public static void main(String[] args) {
//        System.out.println(tournamentWinner(
//                new ArrayList<>(){
//                    {
//                        add(new ArrayList<>(Arrays.asList("HTML", "C#")));
//                        add(new ArrayList<>(Arrays.asList("C#", "Python")));
//                        add(new ArrayList<>(Arrays.asList("Python", "HTML")));
//                    }
//                },
//                new ArrayList<>(Arrays.asList(0, 0, 1))
//        ));
    }
}
