package main;

import util.MyComparator;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of matrix: ");
        int n = Integer.parseInt(scanner.next());
        Double[][] matrix = new Double[n][n];
        Matrix matrix1 = new Matrix();
        matrix1.generateMatrix(n, matrix);
        matrix1.showMatrix(matrix);
        Double minElem = matrix1.findMinElem(n, matrix);
        System.out.println("Min element in maxrix: " + new DecimalFormat("\t#.###\t").format(minElem));
        Double[][] newMatrix = matrix1.createNewMatrix(n, matrix, minElem);
        matrix1.showMatrix(newMatrix);
        System.out.print("Enter range of sorting mas (from): ");
        int sortRangeFrom = scanner.nextInt();
        System.out.print("Enter range of sorting mas (to): ");
        int sortRangeTo = scanner.nextInt();
        Arrays.sort(newMatrix[0], sortRangeFrom - 1, sortRangeTo, new MyComparator());
        System.out.println("Sorted first line");
        matrix1.showMatrix(newMatrix);
        System.out.print("Enter range of coping mas (from): ");
        int copyrangeFrom = scanner.nextInt();
        System.out.print("Enter range of coping mas (to): ");
        int copyRangeTo = scanner.nextInt();
        Double[] mas = Arrays.copyOfRange(newMatrix[0], copyrangeFrom - 1, copyRangeTo);
        System.out.print("Part of mas: ");
        matrix1.showMas(mas);
        System.out.println();
        System.out.println("Matrix with %: ");
        matrix1.showMatrixWithFormater(newMatrix);
    }

}