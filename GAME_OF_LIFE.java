import java.util.Random;
import java.util.Scanner;
public class GAME_OF_LIFE {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("WELCOME TO THE GAME OF LIFE!");
            System.out.print("How big would you like your matrix? ");
            int length = scanner.nextInt();
            scanner.nextLine();
            int[][] gameOfLife = createMatrix(length);
            System.out.println("Heres your matrix:");
            printMatrix(gameOfLife);
            while (true) { 
                gameOfLife = updateMatrix(gameOfLife);
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                printMatrix(gameOfLife);
            }
        }
    }

    static int[][] createMatrix(int length){
        int[][] mat = new int[length][length];
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++){
                mat[i][j] = rnd.nextInt(2);
            }
        }
        return mat;
    }
    
    static void printMatrix(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            // Print top border of each row
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print("+---");
            }
            System.out.println("+");
            // Print cell values
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print("| " + mat[i][j] + " ");
            }
            System.out.println("|");
        }
        // Print bottom border of the last row
        for (int j = 0; j < mat[0].length; j++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }
    
    static byte getNeighbors(int[][] mat, int i, int j){
        byte neighbors = 0;
        if (i>0 && i < mat.length-1){       //we are not in the first or last row
            if (j>0 && j < mat[i].length-1){   // we are not in the first or last collum
                neighbors += mat[i-1][j-1];
                neighbors += mat[i-1][j];
                neighbors += mat[i-1][j+1];
                neighbors += mat[i][j-1];
                neighbors += mat[i][j+1];
                neighbors += mat[i+1][j-1];
                neighbors += mat[i+1][j];
                neighbors += mat[i+1][j+1];
            }
            else if(j == 0){                //we are in the first collum
                neighbors += mat[i-1][j];
                neighbors += mat[i-1][j+1];
                neighbors += mat[i][j+1];
                neighbors += mat[i+1][j];
                neighbors += mat[i+1][j+1];
            }
            else{                           //we are in the last collum
                neighbors += mat[i-1][j-1];
                neighbors += mat[i-1][j];
                neighbors += mat[i][j-1];
                neighbors += mat[i+1][j-1];
                neighbors += mat[i+1][j];
            }
        }else if (i == 0){                  //we are in the first line
            if (j > 0 && j < mat[i].length-1){// we are not in the first or last collum
                neighbors += mat[i][j-1];
                neighbors += mat[i+1][j-1];
                neighbors += mat[i+1][j];
                neighbors += mat[i+1][j+1];
                neighbors += mat[i][j+1];
            }else if(j == 0){                //we are in the first collum
                neighbors += mat[i][j+1];
                neighbors += mat[i+1][j+1];
                neighbors += mat[i+1][j];
            }else{                          //we are in the last collum
                neighbors += mat[i][j-1];
                neighbors += mat[i+1][j-1];
                neighbors += mat[i+1][j];
            }
            
        }else{                              //we are in the last line
            if (j > 0 && j < mat[i].length-1){// we are not in the first or last collum
                neighbors += mat[i][j-1];
                neighbors += mat[i-1][j-1];
                neighbors += mat[i-1][j];
                neighbors += mat[i-1][j+1];
                neighbors += mat[i][j+1];
            }else if(j == 0){                //we are in the first collum
                neighbors += mat[i][j+1];
                neighbors += mat[i-1][j+1];
                neighbors += mat[i-1][j];
            }else{                          //we are in the last collum
                neighbors += mat[i][j-1];
                neighbors += mat[i-1][j-1];
                neighbors += mat[i-1][j];
            }
        }
        return neighbors;
    }
    
    static int[][] updateMatrix(int[][] matrix) {
        int[][] tempMatrix = new int[matrix.length][matrix[0].length];
        // Calculate the new state
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int neighbors = getNeighbors(matrix, i, j);
                if (matrix[i][j] == 1 && (neighbors <= 1 || neighbors >= 4)) {
                    tempMatrix[i][j] = 0;  // Cell dies
                } else if (matrix[i][j] == 0 && neighbors == 3) {
                    tempMatrix[i][j] = 1;  // Cell becomes alive
                } else {
                    tempMatrix[i][j] = matrix[i][j];  // Retain current state
                }
            }
        }
        // Return the updated matrix
        return tempMatrix;
    }    
    
}