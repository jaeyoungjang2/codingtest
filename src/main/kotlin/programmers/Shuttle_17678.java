package programmers;

import java.util.PriorityQueue;

public class Shuttle_17678 {
    public static void main(String[] args) {
        int n = 1; // 횟수
        int t = 1; // 셔틀버스 간격
        int m = 5; // 탑승 가능 인원
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"}; // 크루가 도착하는 시간
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String table : timetable) {
            int time = Integer.parseInt(table.substring(0, 2)) * 60 + Integer.parseInt(table.substring(3));
            pq.add(time);
        }
        // 마지막차가 정원이 차지 않는다면 도착하는 시기에 타면 된다.
        // 마지막차가 정원이 찬다면 마지막차에 마지막 타는 사람보다 1분 빨리오면 된다.

        int start = 9 * 60;
        int answer = 0;
        int lastPerson = 0;
        for (int i = 0; i < n; i++) {
            int bus = start + t * i;

            // 탑승 인원
            for (int j = 0; j < m; j++) {
                if (pq.isEmpty()) {
                    lastPerson = bus;
                    break;
                }

                if (pq.peek() > bus) {
                    lastPerson = bus;
                    break;
                }
                lastPerson = pq.poll() - 1;
            }
        }


        String hour = String.format("%02d", lastPerson / 60);
        String minute = String.format("%02d", lastPerson % 60);
        System.out.println(hour + ":" + minute);;
    }
}
