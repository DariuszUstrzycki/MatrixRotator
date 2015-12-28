
/**
 * the class rotates a 2d array of equal width and length
 * and throws a custom exception is sides are not equal
 * @author Dariusz Ustrzycki
 */

 public final class MatrixRotator {

	private MatrixRotator() {}
	
	public static <T> void rotate2dArray(T[][] matrix){
		
		int colStart = 0;
		int colEnd = matrix.length - 1;
		
		// on each loop send the subsequent row for rotation with modified start and end indexes
		for(int row = 0; row < (matrix.length / 2); ){
			
			rotateRow(colStart, colEnd, row, matrix);
			
			colStart++;
			colEnd--;
			row++;
		}
	}
	
	private static <T> void rotateRow(int start, int end, int row, T[][] matrix){
		
		int size = matrix.length - 1;
		
		/*if (matrix[row].length != matrix.length)
			throw new UnevenSidesException("The length of row " + row +	" is " + matrix[row].length + 
									 ". The length of the 2D array is " + matrix.length);*/
		
		try {
			
			while(start < end){
					// rotate top to right
				T temp1 = matrix[start][end]; // keep the removed element for insertion
				matrix[start][end] = matrix[row][start];
					// rotate right to bottom
				T temp2 = matrix[size-row][end - (start-row)]; // keep another removed element for insertion
				matrix[size-row][end - (start-row)] = temp1;
					// rotate bottom to left
				temp1 = matrix[end - (start-row)][row];
				matrix[end - (start-row)][row] = temp2;			
					// rotate left to top
				matrix[row][start] = temp1;
				
				start++; // move to the next element in this row
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {

			throw new UnevenSidesException("Make sure the length of each row is " + matrix.length); 
		}
	}
}
 
 
