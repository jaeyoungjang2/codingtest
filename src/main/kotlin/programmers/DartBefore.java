//package programmers;
//
//class Solution {
//    public int solution(String dartResult) {
//        int answer = 0;
//        List<Character> bonustList = new ArrayList<>(Arrays.asList('S', 'D', 'T'));
//        List<Character> optionlist = new ArrayList<>(Arrays.asList('*', '#'));
//        List<Integer> result = new ArrayList<>();
//        int index = -1;
//        String integerTemp = "";
//        for (int i = 0; i < dartResult.length(); i++) {
//            char dart = dartResult.charAt(i);
//
//            if (bonustList.contains(dart)) {
//                result.add(Integer.parseInt(integerTemp));
//                index++;
//                integerTemp = "";
//
//                if (dart == 'S') {
//                    continue;
//                }
//                if (dart == 'D') {
//                    result.set(index, (int) Math.pow(result.get(index), 2));
//                    continue;
//                }
//                if (dart == 'T') {
//                    result.set(index, (int) Math.pow(result.get(index), 3));
//                    continue;
//                }
//
//            }
//            if (optionlist.contains(dart)) {
//                if (dart == '*') {
//                    if (index == 0) {
//                        result.set(index, result.get(index) * 2);
//                        continue;
//                    }
//                    result.set(index, result.get(index) * 2);
//                    result.set(index - 1, result.get(index - 1) * 2);
//                    continue;
//                }
//                if (dart == '#') {
//                    result.set(index, - result.get(index));
//                    continue;
//                }
//            }
//            integerTemp += dart;
//        }
//
//        for (int i = 0; i < result.size(); i++) {
//            answer += result.get(i);
//        }
//
//        return answer;
//    }
//}