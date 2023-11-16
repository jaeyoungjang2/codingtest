package programmers;

import java.sql.Array;
import java.util.*;

public class Traffic_17676 {
    public static void main(String[] args) {
        String[] lines = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };

        List<TrafficTime> trafficTimes = new ArrayList<>();

        for (String line : lines) {
            String[] timeInfo = line.split(" ");
            String time = timeInfo[1];
            String[] split = time.split(":");
            Integer hour = Integer.valueOf(split[0]) * 3600 * 1000;
            Integer minute = Integer.valueOf(split[1]) * 60 * 1000;

            String[] secondSplit = split[2].split("\\.");
            Integer second = Integer.valueOf(secondSplit[0]) * 1000;
            Integer milisecond = Integer.valueOf(secondSplit[1]);
            Integer endTime = hour + minute + second + milisecond;

            Integer duration = (int) (Double.parseDouble(line.substring(24, line.length() - 1)) * 1000);
            Integer starTime = endTime - duration + 1;

            trafficTimes.add(new TrafficTime(starTime, endTime));
        }

        int result = 0;
        for (int i = 0; i < trafficTimes.size(); i++) {
            int count = 0;
            for (int j = i + 1; j < trafficTimes.size(); j++) {
                if (trafficTimes.get(i).getStartTime() + 1000 > trafficTimes.get(j).getStartTime()) {
                    count++;
                }
            }
            if (count > result) {
                result = count;
            }
        }
        
    }
}

class TrafficTime {
    private final Integer startTime;
    private final Integer endTime;

    public TrafficTime(Integer startTime, Integer endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }
}
