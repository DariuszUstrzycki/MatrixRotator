import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class RotateMatrixTesterCorrected {
	
	String[][] nonSquareArrayOfStrings;
	Integer	[][] nonSquareArrayOfInts;
	String[][] oneElementArray;
	Double[][] fourElementArray;
	Object[][] largeArrayOfStrings; 
	Object[][] largeIntArray; 
	
	@Test
	public void rotate2dArray_nonSquareInput_UnevenSidesException(){
		
		nonSquareArrayOfStrings =  new String[][]{	{"a"}, 
		   											{"b"}	};
		nonSquareArrayOfInts = new Integer[][]{	{1,2,3},
		   										{4,5,6},
		   										{7,8}	};
		   											
		try {
			MatrixRotator.rotate2dArray(nonSquareArrayOfStrings);
			fail("Check out of bounds");
		} catch (UnevenSidesException e) {}
		
		try {
			MatrixRotator.rotate2dArray(nonSquareArrayOfInts);
			fail("Check out of bounds");
		} catch (UnevenSidesException e) {}	
	}

	@Test
	public void rotate2dArray_largeIntArray_rotatedCorrectly(){
		
		Integer[] arrayOfInts =
			{10, 11, 12, 13,
			 20, 21, 22, 23,
			 30, 31, 32, 33,
			 40, 41, 42, 43,};
		largeIntArray =  create2Darray(arrayOfInts);
		
		MatrixRotator.rotate2dArray(largeIntArray);
		assertEquals("Check rotation of a large Integer array", "[[40, 30, 20, 10], [41, 31, 21, 11], [42, 32, 22, 12], [43, 33, 23, 13]]", 
					Arrays.deepToString(largeIntArray));
	}
	
	@Test
	public void rotate2dArray_largeStringAndDoubleArray_rotatedCorrectly(){
		
		String[] stringArray = new String[]
				{"a", "b", "c", "d", "e", 
				"f", "g", "h", "i", "j", 
				"k", "l", "m", "n", "o", 
				"p", "q", "r", "s", "t", 
				"u", "v", "x", "y", "z"};
		largeArrayOfStrings =  create2Darray(stringArray);
		
		MatrixRotator.rotate2dArray(largeArrayOfStrings);
		assertEquals("Check rotation of a large String array", "[[u, p, k, f, a], [v, q, l, g, b], [x, r, m, h, c], [y, s, n, i, d], [z, t, o, j, e]]", 
							Arrays.deepToString(largeArrayOfStrings));
		
		fourElementArray = new Double[][]{{2.0,2.5},{3.1, 3.2}};
		
		MatrixRotator.rotate2dArray(fourElementArray);
		assertEquals("Check rotation of a 4-element array", "[[3.1, 2.0], [3.2, 2.5]]", Arrays.deepToString(fourElementArray));
	}
	
	@Test
	public void rotate2dArray_oneElementArray_rotatedCorrectly(){
		
		oneElementArray = new String[][]{{"z"}};
		MatrixRotator.rotate2dArray(oneElementArray);
		assertEquals("Check rotation of a 1-element array", "[[z]]", Arrays.deepToString(oneElementArray));
	}
	
	private static Object[][] create2Darray(Object[] oneDarray){
		// assume the 1D array has the same height and width
		int size = (int) Math.sqrt((double)oneDarray.length) ; 				
		Object[][] array2D = new Object[size][size];			
		
		//fill the 2D array
		int lettersCounter = 0;
		for(int i = 0; i < array2D.length; i++ ){				
			for(int j = 0; j < array2D[i].length; j++ ){
				array2D[i][j] = oneDarray[lettersCounter];
				lettersCounter++;
			}
		}
		return array2D;		
	}
}
