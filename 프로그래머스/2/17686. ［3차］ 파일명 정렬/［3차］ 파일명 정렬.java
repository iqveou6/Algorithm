import java.util.*;

class FileInfo implements Comparable<FileInfo> {
    
    String head;
    int number;
    int index;
    String name;
    
    public FileInfo(String head, int number, int index, String name) {
        this.head = head;
        this.number = number;
        this.index = index;
        this.name = name;
    }
    
    @Override
    public int compareTo(FileInfo fileInfo) {
        if (!this.head.equals(fileInfo.head)) {
            return this.head.compareTo(fileInfo.head);
        } 
        if (this.number != fileInfo.number) {
            return Integer.compare(this.number, fileInfo.number);
        }
        return this.index - fileInfo.index;
    }
}

class Solution {
    public String[] solution(String[] files) {
        int length = files.length;
        String[] answer = new String[length];
        FileInfo[] filesInfo = new FileInfo[length];
        StringBuilder head;
        StringBuilder number;
        int index;
        for (int i = 0; i < length; i++) {
            head = new StringBuilder();
            number = new StringBuilder();
            index = 0;
            while (index < files[i].length() && !Character.isDigit(files[i].charAt(index))) {
                head.append(files[i].charAt(index));
                index++;
            }
            while (index < files[i].length() && Character.isDigit(files[i].charAt(index))) {
                number.append(files[i].charAt(index));
                index++;
            }

            filesInfo[i] = new FileInfo(head.toString().toUpperCase(), 
                                        Integer.parseInt(number.toString()), i, files[i]);
        }
        
        Arrays.sort(filesInfo);
        for (int i = 0; i < length; i++) {
            answer[i] = filesInfo[i].name;
        }
        return answer;
    }
}