// Пример запуска: java .\Main.java 4 3
public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int pointer = 0;
        String result = "";
        int[] nFormated = new int[n];

        for (int i = 0; i < n; i++) {
            nFormated[i] = i + 1;
        }

        while (true) {
            result += nFormated[pointer];
            pointer += (m - 1);
            if (pointer >= n) {
                pointer -= n;
                if (pointer == 0) break;
            }
        }
        System.out.println(result);
    }
}
