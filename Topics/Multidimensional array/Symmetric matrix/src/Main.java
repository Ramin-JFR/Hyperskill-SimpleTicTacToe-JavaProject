import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] rowInt = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowInt [i] [j] = scan.nextInt();
            }
        }

        boolean isSymmetric = true;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if (rowInt[i][j] != rowInt[j][i]){
                    isSymmetric = false;
                    break;
                }
            }

            if (!isSymmetric) {
                break;
            }

        }
        if (isSymmetric){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

        scan.close();
    }
}