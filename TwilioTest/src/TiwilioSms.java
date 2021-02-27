import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class TiwilioSms {
	private static final String GSM_7_REGEX = "[A-Za-z0-9 .,]+";

	public static double calculateTotalMessageCosts(List<String> messages) {
		if (Objects.isNull(messages) || messages.isEmpty())
			return 0.0;

		double cost = 0.0;
		TiwilioOperators operator = null;
		for (String message : messages) {
			if (matchGSM7(message)) {
				operator = TiwilioOperators.GSM7;
			} else {
				operator = TiwilioOperators.UCS2;
			}

			for (int x = 0; x < message.length();) {
				cost += operator.getCharges();
				x += operator.getLimit();
			}
		}
		return Double.parseDouble(new DecimalFormat("#.###").format(cost));
	}

	private static boolean matchGSM7(String message) {
		return Pattern.matches(GSM_7_REGEX, message);
	}

	public static void main(String[] args) {
		System.out.println(calculateTotalMessageCosts(Arrays.asList(
				//UC2
				"Call me Ishmael. Some years ago- never mind how long precisely- having little or no money in my purse, and nothing particular to interest me on shore, I thought I would sail about a little and see the watery part of the world.",
				//GSM7
				"It is a way I have of driving off the spleen and regulating the circulation.",
				//GSM7
				"Whenever I find myself growing grim about the mouth.",
				//UC2
				"Whenever it is a damp, drizzly November in my soul; whenever I find myself involuntarily pausing before coffin warehouses, and bringing up the rear of every funeral I meet; and especially whenever my hypos get such an upper hand of me, that it requires a strong moral principle to prevent me from deliberately stepping into the street, and methodically knocking people's hats off- then, I account it high time to get to sea as soon as I can.",
				//GSM7
				"This is my substitute for pistol and ball.",
				//UC2
				"With a philosophical flourish Cato throws himself upon his sword; I quietly take to the ship. There is nothing surprising in this. If they but knew it, almost all men in their degree, some time or other, cherish very nearly the same feelings towards the ocean with me."
				
				
				)));
	}

}
