package io.algoexpert.easy.classphoto;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        int trend = 0;
        for(int pointerA = 0; pointerA < redShirtHeights.size(); pointerA++){
            int eleConsequence = redShirtHeights.get(pointerA) - blueShirtHeights.get(pointerA);
            int absEleConsequence = Math.abs(eleConsequence);

            if(eleConsequence == 0)
                return false;

            int currentTrend = eleConsequence / absEleConsequence;

            if(trend != 0 && trend != currentTrend)
                return false;
            else if(trend == 0) {
                trend = currentTrend;
            }
        }
        return true;
    }
}
