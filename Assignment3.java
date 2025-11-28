import java.util.*;

public class Assignment3 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Matrix Multiplication");
            System.out.println("2. Binary Matrix 0s & 1s");
            System.out.println("3. Arrange a,b,c");
            System.out.println("4. Array Operations Menu");
            System.out.println("5. Smart Grid Optimization");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1 -> question1();
                case 2 -> question2();
                case 3 -> question3();
                case 4 -> question4();
                case 5 -> question5();
                case 6 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void question1() {
        System.out.print("Rows of A: ");
        int r1 = input.nextInt();

        System.out.print("Cols of A: ");
        int c1 = input.nextInt();

        System.out.print("Rows of B: ");
        int r2 = input.nextInt();

        System.out.print("Cols of B: ");
        int c2 = input.nextInt();

        if (c1 != r2) {
            System.out.println("Multiplication not possible");
            return;
        }

        int[][] A = new int[r1][c1];
        int[][] B = new int[r2][c2];

        System.out.println("Matrix A:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                A[i][j] = input.nextInt();
            }
        }

        System.out.println("Matrix B:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                B[i][j] = input.nextInt();
            }
        }

        int[][] C = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                int sum = 0;
                for (int k = 0; k < c1; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }

        System.out.println("Result:");
        for (int[] row : C) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    static void question2() {
        System.out.print("Size of square matrix: ");
        int n = input.nextInt();

        int[][] m = new int[n][n];
        Random rand = new Random();

        System.out.println("Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = rand.nextInt(2);
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

        boolean rowFlag = false;
        for (int i = 0; i < n; i++) {
            boolean all0 = true;
            boolean all1 = true;
            for (int j = 0; j < n; j++) {
                if (m[i][j] != 0) all0 = false;
                if (m[i][j] != 1) all1 = false;
            }
            if (all0) {
                System.out.println("All 0s row " + i);
                rowFlag = true;
            }
            if (all1) {
                System.out.println("All 1s row " + i);
                rowFlag = true;
            }
        }
        if (!rowFlag) System.out.println("No same numbers on row");

        boolean colFlag = false;
        for (int j = 0; j < n; j++) {
            boolean all0 = true;
            boolean all1 = true;
            for (int i = 0; i < n; i++) {
                if (m[i][j] != 0) all0 = false;
                if (m[i][j] != 1) all1 = false;
            }
            if (all0) {
                System.out.println("All 0s col " + j);
                colFlag = true;
            }
            if (all1) {
                System.out.println("All 1s col " + j);
                colFlag = true;
            }
        }
        if (!colFlag) System.out.println("No same numbers on col");

        boolean d0 = true, d1 = true;
        for (int i = 0; i < n; i++) {
            if (m[i][i] != 0) d0 = false;
            if (m[i][i] != 1) d1 = false;
        }
        if (d0) System.out.println("All 0s major diag");
        else if (d1) System.out.println("All 1s major diag");
        else System.out.println("No same numbers major diag");

        boolean sd0 = true, sd1 = true;
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            if (m[i][j] != 0) sd0 = false;
            if (m[i][j] != 1) sd1 = false;
        }
        if (sd0) System.out.println("All 0s sub diag");
        else if (sd1) System.out.println("All 1s sub diag");
        else System.out.println("No same numbers sub diag");
    }

    static void question3() {
        System.out.print("Size of array: ");
        int n = input.nextInt();

        char[] arr = new char[n];
        System.out.println("Enter a/b/c:");
        for (int i = 0; i < n; i++) arr[i] = input.next().charAt(0);

        int a = 0, b = 0, c = 0;
        for (char ch : arr) {
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else c++;
        }

        int idx = 0;
        while (a-- > 0) arr[idx++] = 'a';
        while (b-- > 0) arr[idx++] = 'b';
        while (c-- > 0) arr[idx++] = 'c';

        System.out.println("Arranged:");
        for (char ch : arr) System.out.print(ch + " ");
        System.out.println();
    }

    static void question4() {
        System.out.print("Size of array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = input.nextInt();

        while (true) {
            System.out.println("\n1.Count x  2.Partition  3.Duplicates  4.Circular  5.Shift  6.Print  7.Back");
            int c = input.nextInt();
            switch (c) {
                case 1 -> {
                    System.out.print("x=");
                    int x = input.nextInt();
                    int cnt = 0;
                    for (int v : arr) if (v == x) cnt++;
                    System.out.println("Count=" + cnt);
                }
                case 2 -> {
                    int pivot = arr[0];
                    int i = 1, j = arr.length - 1;
                    while (i <= j) {
                        while (i < arr.length && arr[i] <= pivot) i++;
                        while (j > 0 && arr[j] > pivot) j--;
                        if (i < j) {
                            int t = arr[i];
                            arr[i] = arr[j];
                            arr[j] = t;
                        }
                    }
                    int t = arr[0]; arr[0] = arr[j]; arr[j] = t;
                    System.out.println("Partitioned");
                }
                case 3 -> {
                    HashMap<Integer, Integer> map = new HashMap<>();
                    for (int v : arr) map.put(v, map.getOrDefault(v, 0) + 1);
                    for (var e : map.entrySet()) System.out.println(e.getKey() + " -> " + e.getValue());
                }
                case 4 -> {
                    int[] copy = arr.clone();
                    for (int k = 0; k < arr.length; k++) arr[k] = copy[(k + 1) % arr.length] + copy[(k + 2) % arr.length];
                    System.out.println("Circular sum applied");
                }
                case 5 -> {
                    int[] shifted = new int[arr.length];
                    for (int k = 0; k < arr.length; k++) shifted[k] = arr[(k + 2) % arr.length];
                    arr = shifted;
                    System.out.println("Shifted left by 2");
                }
                case 6 -> {
                    for (int v : arr) System.out.print(v + " ");
                    System.out.println();
                }
                case 7 -> { return; }
                default -> System.out.println("Invalid");
            }
        }
    }

    static void question5() {
        System.out.print("Rows: ");
        int r = input.nextInt();
        System.out.print("Cols: ");
        int c = input.nextInt();

        int[][] grid = new int[r][c];
        System.out.println("Grid:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                grid[i][j] = input.nextInt();

        System.out.print("Threshold: ");
        int th = input.nextInt();

        int[][] ng = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] > th) {
                    int s = 0, cnt = 0;
                    if (i > 0) { s += grid[i-1][j]; cnt++; }
                    if (i < r-1) { s += grid[i+1][j]; cnt++; }
                    if (j > 0) { s += grid[i][j-1]; cnt++; }
                    if (j < c-1) { s += grid[i][j+1]; cnt++; }
                    ng[i][j] = s / cnt;
                } else ng[i][j] = grid[i][j];
            }
        }

        System.out.println("Optimized Grid:");
        for (int[] row : ng) {
            for (int x : row) System.out.print(x + " ");
            System.out.println();
        }
    }
}
