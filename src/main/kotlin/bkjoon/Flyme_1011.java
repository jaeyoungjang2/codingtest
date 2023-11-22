package bkjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Flyme_1011 {
    public static void main(String[] args) {

        int targetDistance = 4;

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 0));
        int answer = 0;

        List<Integer> moveLength = Arrays.asList(-1, 0, 1);
        1의 자리 n/h+1
        100의 자리 n%h

        boolean isMove = true;
        while (isMove) {

            Position position = queue.poll();
            System.out.println("HI");
            for (Integer currentMove : moveLength) {
                int currentDistance = position.getDistance() + currentMove;
                if (currentDistance < 0) {
                    continue;
                }
                int currentCount = position.getCount() + 1;
                System.out.println(String.format("%s %s %s", currentDistance, currentMove, currentCount));
                if (currentDistance == targetDistance) {
                    isMove = false;
                    answer = position.getCount() + 1;
                    break;
                }
                queue.add(new Position(currentDistance, currentMove, currentCount));
            }

            if (!isMove) {
                break;
            }

        }

        System.out.println("answer = " + answer);
    }
}

class Position {
    // 이동 거리
    private final int distance;
    // 이동한 거리
    private final int move;
    private final int count;

    public Position(int distance, int move, int count) {
        this.distance = distance;
        this.move = move;
        this.count = count;
    }

    public int getDistance() {
        return distance;
    }

    public int getMove() {
        return move;
    }

    public int getCount() {
        return count;
    }
}