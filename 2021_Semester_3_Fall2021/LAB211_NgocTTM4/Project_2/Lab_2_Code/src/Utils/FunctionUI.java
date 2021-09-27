package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FunctionUI {
    
    static String baseDescriptFolder = "data";

    

    public static void printREADME(String filename) {
        String path = baseDescriptFolder + "/" + filename;

        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(TextColor.create(">> File not found", Color.RED));
        }
    }

    public static void pause() {
        // pause
        Inputter.getString("", false, false);
    }
}
