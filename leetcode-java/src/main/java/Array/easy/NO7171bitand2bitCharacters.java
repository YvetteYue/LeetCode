package Array.easy;

//We have two special characters. The first character can be represented by one bit 0. 
//The second character can be represented by two bits (10 or 11).
//Now given a string represented by several bits. 
//Return whether the last character must be a one-bit character or not. 
//The given string will always end with a zero.
public class NO7171bitand2bitCharacters {

	public static void main(String[] args) {
		int bits[]={0,1,1,0};
		System.out.println(isOneBitCharacter(bits));
	}

	/**
	 * 
	 *2018年4月22日 下午10:23:56
	 * beats:95.92%
	 * 复杂度：
	 */
	public static boolean isOneBitCharacter(int[] bits) {
		int i = 0;
		int len = bits.length;
		boolean bool=false;
		while (i < len) {
			if (bits[i] == 0) {
				while (i<len&&bits[i] == 0) {
					i++;
				}
				bool=true;
			} else{
				i += 2;
				bool=false;
			}
		}
		return bool;
	}
}
