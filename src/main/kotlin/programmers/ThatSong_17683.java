package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ThatSong_17683 {
    public static void main(String[] args) throws ParseException {
        String m = "ABCDEFG";
        String[] musicinfos = 	{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String answer = "(None)";
        int maxStrLength = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            String startTime = split[0];
            String endTime = split[1];
            String songName = split[2];
            String tempStr = split[3];

            // 가사를 한글자로 변환
            tempStr = tempStr.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#", "a");
            m = m.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#", "a");

            // 재생 시간 만큼 가사를 변환

            int diff = Long.valueOf((sdf.parse(endTime).getTime() - sdf.parse(startTime).getTime()) / (1000 * 60)).intValue();

            int i = diff / tempStr.length();
            int j = diff % tempStr.length();
            String str = tempStr.repeat(i);
            str += tempStr.substring(0, j);


            // 조건과 일치하는 음악인지 확인
            if (str.contains(m) && maxStrLength < str.length()) {
                maxStrLength = str.length();
                answer = songName;
            }
        }
        System.out.println(answer);
    }
}
