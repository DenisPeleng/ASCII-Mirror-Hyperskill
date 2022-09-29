package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> fileList = readFile();
        int longestDistance = getLongestLength(fileList);
        insertSpacesInStrings(fileList, longestDistance);

        for (String str : fileList
        ) {
            String reversedStr = swapCharElementsMirror(str);
            System.out.println(str + " | " + reversedStr);
        }
    }

    public static List<String> readFile() {
        System.out.println("Input the file path:");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        File file = new File(filePath);
        List<String> fileList = new ArrayList<>();
        try (Scanner scannerFile = new Scanner(file)) {
            while (scannerFile.hasNext()) {
                fileList.add(scannerFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return fileList;
    }

    public static int getLongestLength(List<String> fileList) {
        int longestDistance = 0;
        for (String str : fileList
        ) {
            if (str.length() > longestDistance) {
                longestDistance = str.length();
            }
        }
        return longestDistance;
    }

    public static void insertSpacesInStrings(List<String> fileList, int longestDistance) {
        for (int i = 0; i < fileList.size(); i++) {
            String currentStr = fileList.get(i);
            if (currentStr.length() < longestDistance) {
                currentStr += " ".repeat(longestDistance - currentStr.length());

                fileList.set(i, currentStr);
            }
        }
    }

    public static String swapCharElementsMirror(String str) {
        char[] charsToReplace = new char[]{'<', '>', '[', ']', '{', '}', '(', ')', '/', '\\'};
        char[] charsChanged = new char[]{'>', '<', ']', '[', '}', '{', ')', '(', '\\', '/'};
        StringBuilder sb = new StringBuilder();
        char[] charStr = str.toCharArray();
        for (char charTemp : charStr
        ) {
            for (int i = 0; i < charsToReplace.length; i++) {
                if (charTemp == charsToReplace[i]) {
                    charTemp = charsChanged[i];
                    break;
                }
            }
            sb.append(charTemp);
        }
        return sb.reverse().toString();
    }

}