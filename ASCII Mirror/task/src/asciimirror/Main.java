package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input the file path:");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        File file = new File(filePath);
        try (Scanner scannerFile = new Scanner(file)) {
            while (scannerFile.hasNext()) {
                System.out.println(scannerFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }


    }
}