package programmers;

import java.util.*;

public class FileSort17686 {

    public static class TestFile {
        private String originFileName;
        private String head;
        private Integer number;

        public TestFile(String originFileName, String head, Integer number) {
            this.originFileName = originFileName;
            this.head = head;
            this.number = number;
        }
    }

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        List<TestFile> testFiles = makeFileList(files);

        Collections.sort(testFiles, new Comparator<TestFile>() {
            @Override
            public int compare(TestFile file1, TestFile file2) {
                if (file1.head.equals(file2.head)) {
                    return file1.number - file2.number;
                } else {
                    return file1.head.compareTo(file2.head);
                }
            }
        });


        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = testFiles.get(i).originFileName;
        }
    }



    private static List<TestFile> makeFileList(String[] files) {
        List<TestFile> fileList = new ArrayList<>();
        for (String file : files) {
            fileList.add(makeFile(file));
        }
        return fileList;
    }

    private static TestFile makeFile(String file) {
        String head = "";
        String number = "";
        int idx = 0;

        for (int i = 0; i < file.length(); i++) {
            char c = file.charAt(i);
            if (Character.isDigit(c)) {
                if (idx == 0) {
                    idx++;
                }
                number += c;
                continue;
            }
            if (idx != 0) {
                break;
            }
            head += c;
        }
        return new TestFile(file, head.toLowerCase(), Integer.parseInt(number));
    }
}
