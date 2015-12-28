import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class RotateMatrixTester {
	
	String[][] unevenArrayOfStrings;
	Integer[][] unevenArrayOfInts;
	String[][] oneElementArray;
	Double[][] fourElementArray;
	Object[][] largeArrayOfStrings; 
	Object[][] largeIntArray; 

	@Before
	public void setUp() throws Exception {
		
		unevenArrayOfStrings =  new String[][]{{"a"}, 
				   							   {"b"}};
		unevenArrayOfInts = new Integer[][]{{1,2,3},
			           					{4,5,6},
			            				{7,8}	};	
			            				
	    oneElementArray = new String[][]{{"z"}};
	    
	    fourElementArray = new Double[][]{{2.0,2.5},{3.1, 3.2}};
	    
	    String[] stringArray = new String[]
				{"a", "b", "c", "d", "e", 
				"f", "g", "h", "i", "j", 
				"k", "l", "m", "n", "o", 
				"p", "q", "r", "s", "t", 
				"u", "v", "x", "y", "z"};
		largeArrayOfStrings =  create2Darray(stringArray);
		
		Integer[] arrayOfInts =
			{10, 11, 12, 13,
			 20, 21, 22, 23,
			 30, 31, 32, 33,
			 40, 41, 42, 43,};
		largeIntArray =  create2Darray(arrayOfInts);
	}

	@Test
	public void testRotate2dArray() {		
		
		////////////////test a non-square 2D array, rotate2dArray should throw an exception		
		try {
			MatrixRotator.rotate2dArray(unevenArrayOfStrings);
			fail("Check out of bounds");
		} catch (UnevenSidesException e) {}
		
		////////////////test a non-square 2D array, rotate2dArray should throw an exception		
		try {
			MatrixRotator.rotate2dArray(unevenArrayOfInts);
			fail("Check out of bounds");
		} catch (UnevenSidesException e) {}
		
		////////////////test standard use
		MatrixRotator.rotate2dArray(oneElementArray);
		assertEquals("Check rotation of a 1-element array", "[[z]]", Arrays.deepToString(oneElementArray));
		
		////////////////test standard use
		MatrixRotator.rotate2dArray(fourElementArray);
		assertEquals("Check rotation of a 4-element array", "[[3.1, 2.0], [3.2, 2.5]]", Arrays.deepToString(fourElementArray));
		
		////////////////test standard use
		MatrixRotator.rotate2dArray(largeArrayOfStrings);
		assertEquals("Check rotation of a large String array", "[[u, p, k, f, a], [v, q, l, g, b], [x, r, m, h, c], [y, s, n, i, d], [z, t, o, j, e]]", 
							Arrays.deepToString(largeArrayOfStrings));
		
		////////////////test standard use
		MatrixRotator.rotate2dArray(largeIntArray);
		assertEquals("Check rotation of a large Integer array", "[[40, 30, 20, 10], [41, 31, 21, 11], [42, 32, 22, 12], [43, 33, 23, 13]]", 
					Arrays.deepToString(largeIntArray));
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
