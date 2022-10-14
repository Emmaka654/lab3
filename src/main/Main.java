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
        generateMatrix(n, matrix);
        showMatrix(matrix);
        Double minElem = findMinElem(n, matrix);
        System.out.println("Min element in maxrix: " + new DecimalFormat("\t#.###\t").format(minElem));
        Double[][] newMatrix = createNewMatrix(n, matrix, minElem);
        showMatrix(newMatrix);
        System.out.print("Enter range of sorting mas (from): ");
        int sortRangeFrom = scanner.nextInt();
        System.out.print("Enter range of sorting mas (to): ");
        int sortRangeTo = scanner.nextInt();
        Arrays.sort(newMatrix[0], sortRangeFrom - 1, sortRangeTo, new MyComparator());
        System.out.println("Sorted first line");
        showMatrix(newMatrix);
        System.out.print("Enter range of coping mas (from): ");
        int copyrangeFrom = scanner.nextInt();
        System.out.print("Enter range of coping mas (to): ");
        int copyRangeTo = scanner.nextInt();
        Double[] mas = Arrays.copyOfRange(newMatrix[0], copyrangeFrom - 1, copyRangeTo);
        System.out.print("Part of mas: ");
        showMas(mas);
        System.out.println();
        System.out.println("Matrix with %: ");
        showMatrixWithFormater(newMatrix);
    }

    private static void showMas(Double[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(new DecimalFormat("\t#.###\t").format(mas[i]) + " ");
        }
    }

    private static Double[][] createNewMatrix(int n, Double[][] matrix, Double minElem) {
        int row = 0;
        int column = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minElem) {
                    row = i;
                    column = j;
                }
            }
        }
        Double[][] newMatrix = new Double[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j < column && i < row) {
                    newMatrix[i][j] = matrix[i][j];
                } else if (i == row || j == column) {
                    newMatrix[i][j] = minElem;
                } else {
                    if (i < row) {
                        newMatrix[i][j] = matrix[i][j - 1];
                    } else if (j < column) {
                        newMatrix[i][j] = matrix[i - 1][j];
                    } else {
                        newMatrix[i][j] = matrix[i - 1][j - 1];
                    }
                }
            }
        }
        return newMatrix;
    }

    private static Double findMinElem(int n, Double[][] matrix) {
        Double minElem = matrix[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < minElem) {
                    minElem = matrix[i][j];
                }
            }
        }
        return minElem;
    }

    private static void showMatrix(Double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(new DecimalFormat("\t#.###\t").format(matrix[i][j]));
            }
            System.out.println();
        }
    }

    private static void showMatrixWithFormater(Double[][] matrix) {
        NumberFormat format1 = NumberFormat.getPercentInstance(Locale.CANADA);
        NumberFormat format2 = NumberFormat.getCurrencyInstance(Locale.CANADA);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == 1) {
                    System.out.print("\t" + format1.format(matrix[i][j]) + "\t");
                } else if (i == 2) {
                    System.out.print("\t" + format2.format(matrix[i][j]) + "\t");
                } else {
                    System.out.print(new DecimalFormat("\t#.###\t").format(matrix[i][j]));
                }
            }
            System.out.println();
        }
    }

    private static void generateMatrix(int n, Double[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.random() * 100;
            }
        }
    }

}