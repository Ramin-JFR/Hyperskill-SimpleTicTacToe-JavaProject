import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (input != 0) {
            String result = (input % 2) == 0 ? "even" : "odd";
            System.out.println(result);
            input = scanner.nextInt();
        }
    }

}

