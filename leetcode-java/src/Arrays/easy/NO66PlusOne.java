package Arrays.easy;

public class NO66PlusOne {

	//beats 68.51%
	public int[] plusOne(int[] digits) {
		int len = digits.length;
		int tmp = 1;
		int[] res = new int[len + 1];
		for (int i = len - 1; i >= 0; i--) {
			tmp += digits[i];
			digits[i] = tmp % 10;
			tmp = tmp / 10;
		}
		if (tmp == 0)
			return digits;
		if (tmp == 1) {
			res[0] = 1;
			for (int i = 0; i < len; i++) {
				res[i + 1] = digits[i];
			}
		}
		return res;
	}
}
