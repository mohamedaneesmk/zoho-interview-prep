import java.util.*;

public class ShortestPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the matrix dimensions (m x n) : ");
        int number = sc.nextInt();
        char[][] matrix = new char[number][number];

        for(int row=0;row<number;row++){ 
            for(int col=0;col<number;col++){
                matrix[row][col]='0';
            }
        } 

        System.out.print("Enter the adventure position (row and column) : ");
        int AdventureRow = sc.nextInt();
        int AdventureCol = sc.nextInt();
        matrix[AdventureRow][AdventureCol] = 'A';   
        
        System.out.print("Enter the Destination position (row and column) : ");
        int DestinationRow = sc.nextInt();
        int DestinationCol = sc.nextInt();
        matrix[DestinationRow][DestinationCol] = 'D';
        
        System.out.println("Matrix:");
        for(int row=0;row<number;row++,System.out.println()){
            for(int col=0;col<number;col++){
                System.out.print(matrix[row][col]+" ");
            }
        }

        int shortestPath = findShortestPath(AdventureRow,AdventureCol,DestinationRow,DestinationCol);
        System.out.println("\nThe shortest distance = "+shortestPath);
        sc.close();
    }

    private static int findShortestPath(int adventureRow, int adventureCol, int destinationRow, int destinationCol) {
        return Math.max(Math.abs(destinationRow - adventureRow),Math.abs(destinationCol - adventureCol));
    }    
}
