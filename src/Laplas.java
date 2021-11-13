import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Laplas {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\serhi\\OneDrive\\Робочий стіл\\Теорія прийняття рішень\\1_labs\\src\\matrix.txt")));
        int rows = 3;
        int columns = 3;
        double [][] arr = new double[rows][columns];
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


        double max = 0;
        int strategyNumber = -1;
        System.out.println("Сума елементів кожного рядка:");
        for (int i = 0; i < arr.length; i++) {
            double sum = 0;
            for (int j = 0, k = 0; j < arr[i].length; j++) {
                sum += arr[i][j]/columns;
            }
            if (sum > max) {
                strategyNumber = i;
                max = sum;
            }

            System.out.println("Сума елементів " + i + "-го рядка: " + sum);
        }
        System.out.println("Оцінка Лапласа: " + max);
        System.out.println("Оптимальна стратегія: "+(strategyNumber+1));
    }
}
