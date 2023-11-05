package programmers;


import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/17679
public class BlockGame {

    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        String[] board = {"AA", "AA"};

        char[][] newBoard = makeNewBoard(m, n, board);

        int answer = 0;

        while (true) {
            // 제거해야 될 리스트 확인
            ArrayList<RemovePosition> removeList = checkRemoveList(m, n, newBoard);
            // 제거 목록 반영
            removeBlock(newBoard, removeList);
            // 점수 계산
            int newScore = calculateScore(m, n, newBoard);

            if (newScore == 0) {
                break;
            }

            answer += newScore;

            // 블럭 내리기
            moveBlock(m, n, newBoard);
        }

        System.out.println("answer = " + answer);
    }


    private static ArrayList<RemovePosition> checkRemoveList(int m, int n, char[][] newBoard) {
        ArrayList<RemovePosition> removeList = new ArrayList<>();
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char topLeft = newBoard[i][j];
                char topRight = newBoard[i + 1][j];
                char bottomLeft = newBoard[i][j + 1];
                char bottomRight = newBoard[i + 1][j + 1];

                if (topLeft == topRight && topLeft == bottomLeft && topLeft == bottomRight && topLeft != ' ') {
                    // 삭제해야 하는 위치 정보 저장
                    removeList.add(new RemovePosition(i, j));
                }
            }
        }
        return removeList;
    }

    private static void removeBlock(char[][] newBoard, ArrayList<RemovePosition> removeList) {
        for (RemovePosition removePosition : removeList) {
            Integer x = removePosition.getX();
            Integer y = removePosition.getY();
            newBoard[x][y] = '.';
            newBoard[x + 1][y] = '.';
            newBoard[x][y + 1] = '.';
            newBoard[x + 1][y + 1] = '.';
        }
    }

    private static void moveBlock(int m, int n, char[][] newBoard) {
        for (int i = 0; i < n; i++) {
            int height = m - 1;
            for (int j = m - 1; j >= 0; j--) {
                if (newBoard[j][i] != '.') {
                    newBoard[height][i] = newBoard[j][i];
                    height--;
                }
            }
            for (int j = height; j >= 0; j--) {
                newBoard[j][i] = ' ';
            }
        }
    }

    private static int calculateScore(int m, int n, char[][] newBoard) {
        int newScore = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (newBoard[i][j] == '.') {
                    newScore += 1;
                }
            }
        }
        return newScore;
    }

    private static char[][] makeNewBoard(int m, int n, String[] board) {
        char[][] newBoard = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = board[i].charAt(j);
            }
        }
        return newBoard;
    }

    static class RemovePosition {
        public Integer x;
        public Integer y;

        public RemovePosition(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }

        public Integer getY() {
            return y;
        }
    }
}
