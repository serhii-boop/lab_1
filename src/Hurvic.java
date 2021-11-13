import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Hurvic {
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


        float kof = 0.8f;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int current;
        int strategyNumber = -1;
        float result = Integer.MIN_VALUE;
        float currentResult;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                current = arr[i][j];
                if(current > max) {
                    max = current;
                }
                if (current < min) {
                    min = current;
                }
            }
            currentResult = kof*min+(1-kof)*max;
            System.out.println("Стратегія " + (i+1) + " - " + currentResult);
            if(currentResult > result) {
                strategyNumber = i;
                result = currentResult;
            }
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
        }
        System.out.println("Критерій Гурвіца: "+(int)result);
        System.out.println("Оптимальна стратегія: "+(strategyNumber+1));


    }
}
