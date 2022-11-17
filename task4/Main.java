import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// Пример запуска: java .\Main.java ./file4.txt
public class Main {
    public static void main(String[] args) {
        String path = args[0];

        Integer[] datas = getFileData(path);
        int result = 0;
        Arrays.sort(datas);
        int median;
        int middle = datas.length / 2;
        if (datas.length % 2 == 0) {
            int middleLeft = datas[middle - 1];
            int middleRight = datas[middle];
            median = (middleLeft + middleRight) / 2;
        } else {
            median = datas[middle];
        }
        for (int data : datas) {
            result += Math.abs(data - median);
        }
        System.out.println(result);
    }

    private static Integer[] getFileData(String path) {
        ArrayList<Integer> points = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                points.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Invalid file");
        }
        Integer []dsf = new Integer[points.size()];
        return points.toArray(dsf);
    }

}
