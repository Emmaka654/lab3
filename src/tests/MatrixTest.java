package tests;

import main.Matrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void findMinElem1() {
        Matrix matrix = new Matrix();
        Double [][] matrix1 = {
                {1.0, 5.3, 5.2},
                {7.4, 7.1, 2.4},
                {12.5, 4.0, 5.4}
        };
        assertEquals (1.0, matrix.findMinElem(3, matrix1));
    }

    @Test
    void findMinElem2() {
        Matrix matrix = new Matrix();
        Double [][] matrix1 = {
                {13.0, 5.3, 5.2},
                {7.4, 7.1, 2.4},
                {12.5, 4.0, 5.4}
        };
        assertEquals (2.4, matrix.findMinElem(3, matrix1));
    }
}