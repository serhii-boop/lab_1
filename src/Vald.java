import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Vald {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\serhi\\OneDrive\\Робочий стіл\\Теорія прийняття рішень\\1_labs\\src\\matrix.txt")));
        int rows = 3;
        int columns = 3;
        int [][] arr = new int[rows][columns];
        while(sc.hasNextLine()) {
            for (int i=0; i<arr.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j=0; j<line.length; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int maxMin = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int current = 0;
        int strategyNumber = -1;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                current = arr[i][j];
                if (current < min) {
                    min = current;
                }
            }
            System.out.println("Стратегія " + (i+1) + " - " + min);
            if(min > maxMin) {
                strategyNumber = i;
                maxMin = min;
            }
            min = Integer.MAX_VALUE;
        }
        System.out.println("Критерій вальда: " + maxMin);
        System.out.println("Оптимальна стратегія: "+(strategyNumber+1));
    }
}
