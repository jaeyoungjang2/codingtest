package programmers;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dart {

    private static final List<String> OPERATORS = new ArrayList<>(Arrays.asList("S", "D", "T"));
    private static final List<String> ADDITIONAL_OPERATORS = new ArrayList<>(Arrays.asList("*", "#"));

    public static void main(String[] args) {
//        String dartResult = "1S2D*3T"; // 37
        String dartResult = "1D2S#10S";
        int answer;

        ArrayList<String> list = splitDartResult(dartResult);
        ArrayList<Integer> scoreList = makeScoreList(list);
        answer = scoreList.stream().mapToInt(integer -> integer).sum();
        System.out.println(answer);
    }

    @NotNull
    private static ArrayList<Integer> makeScoreList(ArrayList<String> list) {
        ArrayList<Integer> scoreList = new ArrayList<>();
        int index = 0;
        for (String s : list) {
            String temp = "";
            for (int i = 0; i < s.length(); i++) {
                String c = String.valueOf(s.charAt(i));
                if (OPERATORS.contains(c)) {
                    int pow;
                    if (c.equals("D")) {
                        pow = (int) Math.pow(Integer.parseInt(temp), 2);
                    } else if (c.equals("T")) {
                        pow = (int) Math.pow(Integer.parseInt(temp), 3);
                    } else {
                        pow = (int) Math.pow(Integer.parseInt(temp), 1);
                    }
                    scoreList.add(Integer.valueOf(pow));
                    temp = "";
                    index ++;
                    continue;
                }

                if (ADDITIONAL_OPERATORS.contains(c)) {
                    if (c.equals("*")) {
                        scoreList.set(index - 1, scoreList.get(index - 1) * 2);
                        if (index - 2 >= 0) {
                            scoreList.set(index - 2, scoreList.get(index - 2) * 2);
                        }
                        continue;
                    }
                    if (c.equals("#")) {
                        scoreList.set(index - 1, scoreList.get(index - 1) * -1);
                        continue;
                    }
                }

                temp += c;
            }
        }
        return scoreList;
    }

    private static ArrayList<String> splitDartResult(String dartResult) {
        ArrayList<String> list = new ArrayList<>();
        String temp = "";
        int index = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            String c = String.valueOf(dartResult.charAt(i));
            if (OPERATORS.contains(c)) {
                temp += c;
                list.add(temp);
                temp = "";
                index ++;
                continue;
            }

            if (ADDITIONAL_OPERATORS.contains(c)) {
                list.set(index - 1, list.get(index - 1) + c);
                continue;
            }

            temp += c;
        }
        return list;
    }
}
