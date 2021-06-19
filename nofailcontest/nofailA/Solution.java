package nofailcontest.nofailA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Solution {

    private static void solve(String input) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date inputDate = formatter.parse(input);
        Date wantDate = new Date();
        wantDate.setMonth(Calendar.FEBRUARY);
        wantDate.setDate(29);

        // Find the latest year that has 29-02 base on Input
        int tempYear = inputDate.getYear();
        while(!Year.isLeap(tempYear))
            tempYear++;

        wantDate.setYear(tempYear);

        if(inputDate.getTime() > wantDate.getTime()){
            tempYear++;
            while (!Year.isLeap(tempYear)) tempYear++;
            wantDate.setYear(tempYear);
        }

        long diffInTimeLong = wantDate.getTime() - inputDate.getTime();
        long diffIntDay = TimeUnit.DAYS.convert(diffInTimeLong, TimeUnit.MILLISECONDS);

        System.out.println(diffIntDay);
    }

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        solve(input);
    }
}
