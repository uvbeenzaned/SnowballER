package co.networkery.uvbeenzaned;

public class ColorConverter {
	public static String toHex(int r, int g, int b) {
			return "0x" + toBrowserHexValue(r) + toBrowserHexValue(g)
					+ toBrowserHexValue(b);
		}
			private static String toBrowserHexValue(int number) {
			StringBuilder builder = new StringBuilder(
			Integer.toHexString(number & 0xff));
			while (builder.length() < 2) {
			builder.append("0");
		}
			return builder.toString().toUpperCase();
	}
 
}
