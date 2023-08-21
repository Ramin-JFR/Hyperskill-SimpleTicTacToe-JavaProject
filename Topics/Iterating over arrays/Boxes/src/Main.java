import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] string1 = scan.nextLine().split(" ");
        String[] string2 = scan.nextLine().split(" ");

        int[] box1 = new int[]{Integer.parseInt(string1[0]), Integer.parseInt(string1[1]), Integer.parseInt(string1[2])};
        int[] box2 = new int[]{Integer.parseInt(string2[0]), Integer.parseInt(string2[1]), Integer.parseInt(string2[2])};

        Arrays.sort(box1);
        Arrays.sort(box2);

        if (box1[0] > box2[0] && box1[1] > box2[1] && box1[2] > box2[2]) {
            System.out.println("Box 1 > Box 2");
        } else if (box1[0] < box2[0] && box1[1] < box2[1] && box1[2] < box2[2]) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incompatible");
        }
    }
}
