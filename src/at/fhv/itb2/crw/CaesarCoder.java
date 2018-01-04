package at.fhv.itb2.crw;

/**
 * Class to encode or decode an input based on the Caesar cipher.
 * @author ske2577
 * <p>Created on: 1.6.17</p>
 * @version 2
 *
 */
public class CaesarCoder {

	private int _shift;
	private char[] _input;
	
	public CaesarCoder(int shift, char[] input){
		_shift = shift;
		_input = input;
	}
	
	/**
	 * Method to encode a string (a-z or A-Z) input by a shift factor based on Caesar cipher.
	 * @return A char array with the encoded text.
	 */
	public char[] encode(){
		
		char[] c = _input;
		
		for (int i = 0; i < _input.length; i++) {
			char cTemp = c[i];

			if(Character.isLetter(cTemp)){
				c[i] = (char) (cTemp + (_shift % 26));
				
				if ((Character.isLowerCase(cTemp) && c[i] > 'z') || (Character.isUpperCase(cTemp) && c[i] > 'Z')){
					c[i] = (char) (cTemp - (26 - _shift % 26));
				}
			}
		}
		
		return c;
	}

	/**
	 * Method to decode a string (a-z or A-Z) input by a shift factor based on Caesar cipher.
	 * @return A char array with the decoded text.
	 */
	public char[] decode(){
		
		char[] c = _input;
		
		for (int i = 0; i < _input.length; i++) {
			char cTemp = c[i];
			
			if(Character.isLetter(cTemp)){
				c[i] = (char) (cTemp - (_shift % 26));
				
				if ((Character.isLowerCase(cTemp) && c[i] < 'a') || (Character.isUpperCase(cTemp) && c[i] < 'A')){
					c[i] = (char) (cTemp + (26 - _shift % 26));
				}
				
			}
		}
		
		return c;
	}
}
