import java.util.Objects;

public class Task1 {
	public static String justified(String text, int columnWitdth) {
		if (Objects.isNull(text) || text.isEmpty()) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		int indexOfSpace = text.lastIndexOf(' ', columnWitdth);
		sb.append(text.substring(0, indexOfSpace + 1)).append("\n");
		indexOfSpace += columnWitdth;
		for (int x = indexOfSpace; x < text.length(); x += columnWitdth) {
			indexOfSpace = text.lastIndexOf(' ', x);
			if (x + columnWitdth < text.length())
				sb.append(text.substring(x, x + columnWitdth)).append("\n");
		}

		return sb.toString();
	}

	private static String justify(String result, int len, int columnWitdth) {
		int diff = len - columnWitdth;
		String[] spaceSplit = result.split(" ");
		int mod = diff % spaceSplit.length;
		int distribution = 0;
		String justify = "";
		if (mod == 0) {
			distribution = spaceSplit.length / diff;
			for (int x = 0; x < spaceSplit.length; x++) {
				justify += spaceSplit[x] + getSpaces(distribution);
			}
		}

		return justify;
	}

	private static String getSpaces(int distribution) {
		String space = "";
		for (int x = 0; x < distribution; x++) {
			space += " ";
		}
		return space;
	}

	/**
	 * 
	 * Aenean volutpat aliquam lectus // ac laoreet. Sed nibh purus, // eleifend sit
	 * amet arcu // molestie, molestie maximus // enim.
	 */
	public static void main(String[] args) {
//		System.out.println(5/5);

		System.out.println(justified(
				"Aenean volutpat aliquam lectus ac laoreet. Sed nibh purus, eleifend sit amet arcu molestie, molestie maximus enim",
				30));
	}
}
