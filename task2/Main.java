import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

// Пример запуска: java .\Main.java ./file1.txt ./file2.txt
public class Main {
    public static void main(String[] args) {
        String path = args[0];
        String path2 = args[1];

        float r;
        float x1;
        float y1;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String x1y1 = br.readLine();
            r = Float.parseFloat(br.readLine());
            String[] number = x1y1.split(" ");
            x1 = Float.parseFloat(number[0]);
            y1 = Float.parseFloat(number[1]);
        } catch (IOException e) {
            throw new RuntimeException("Invalid file 1");
        }

        List<String> points = getFile2(path2);
        for (String point : points) {
            String[] number = point.split(" ");
            float x2 = Float.parseFloat(number[0]);
            float y2 = Float.parseFloat(number[1]);
            int counting = counting(r, x1, y1, x2, y2);
            System.out.println(counting);
        }
    }

    private static int counting(float r, float x1, float y1, float x2, float y2) {
        double sqrt = sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (sqrt == r) {
            return 0;
        } else if (sqrt < r) {
            return 1;
        } else if (sqrt > r) {
            return 2;
        }
        throw new RuntimeException("Failed to calculate");
    }

    private static List<String> getFile2(String path) {
        ArrayList<String> points = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                points.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Invalid file 2");
        }
        return points;
    }
}
