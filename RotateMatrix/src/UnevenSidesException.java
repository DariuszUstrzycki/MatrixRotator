
public class UnevenSidesException extends ArrayIndexOutOfBoundsException {
		
	public UnevenSidesException(String message) {
		super("\nThe length of the 2d array must be equal to the length of each of its rows.\n" + message);		
	}
	
	

}
