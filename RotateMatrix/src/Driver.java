
public class Driver {

	public static void main(String[] args) {
		
		/////// create a 1D array			
		String[] stringArray =
				{"a", "b", "c", "d", "e", 
				"f", "g", "h", "i", "j", 
				"k", "l", "m", "n", "o", 
				"p", "q", "r", "s", "t", 
				"u", "v", "x", "y", "z"};
		
		////// create a 2D array
		Object[][] arrayOfStrings; 
		arrayOfStrings =  create2Darray(stringArray);
		System.out.printf("Array before rotation: %n%s%n", arrayToString(arrayOfStrings));
		
		//////// rotate the array
		MatrixRotator.rotate2dArray(arrayOfStrings);		
		System.out.println();		
		System.out.printf("Array after rotation: %n%s%n", arrayToString(arrayOfStrings));
		
		/////////////// check another array
		Integer[] intArray =
			{10, 11, 12, 13,
			 20, 21, 22, 23,
			 30, 31, 32, 33,
			 40, 41, 42, 43,};
		
		////// create a 2D array
		Object[][] arrayOfInts; 
		arrayOfInts =  create2Darray(intArray);
		System.out.printf("Array before rotation: %n%s%n", arrayToString(arrayOfInts));
		
		//////// rotate the array
		MatrixRotator.rotate2dArray(arrayOfInts);		
		System.out.println();		
		System.out.printf("Array after rotation: %n%s%n", arrayToString(arrayOfInts));
		
		System.out.println();	
		System.out.printf("Expecting an exception for unevenArrayOfInts:\n");
		
		Integer[][] nonSquareArrayOfInts = new Integer[][]{	{1,2,3},
				{4,5,6},
				{7,8}	};
		try{
		MatrixRotator.rotate2dArray(nonSquareArrayOfInts);
		} catch(UnevenSidesException e){
			System.out.println("UnevenSidesException has been correctly caught in a catch block");
		}
		
		System.out.println();	
		System.out.printf("Expecting an exception for unevenArrayOfStrings:\n");
		
		String[][]unevenArrayOfStrings =  new String[][]{{"a"}, 
			   											 {"b"}};
	    try {
			MatrixRotator.rotate2dArray(unevenArrayOfStrings);
		} catch (UnevenSidesException e) {
			System.out.println("UnevenSidesException has been correctly caught in a catch block");
		}
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
	
	public static <T> String arrayToString(T[][] arr){
		
		String arrayToPrint = "";
		
		for(int i = 0; i < arr.length; i++ ){	
			for(int j = 0; j < arr[i].length; j++ ){
				arrayToPrint += arr[i][j];
			}
			
			arrayToPrint += "\n";
		}
		return arrayToPrint;
	}

}
