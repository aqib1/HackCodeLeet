package bookmarket;

import java.util.stream.Stream;

public class ProperNounCorrection {

	String properNounCorrection(String noun) {
		StringBuilder sb = new StringBuilder(noun.length());

		Stream.of(noun).forEach(x -> {
			if (x.length() > 1) {
				sb.append(x.substring(0, 1).toUpperCase()).append(x.substring(1).toLowerCase());
				;
			} else {
				sb.append(x.toUpperCase());
			}
		});

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println();

	}

}
