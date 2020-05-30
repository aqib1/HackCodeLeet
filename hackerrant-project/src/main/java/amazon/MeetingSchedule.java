package amazon;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingSchedule {
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH mm");

	public List<String> getSlots(int minutes, List<List<LocalTime>> slots) {
		List<String> availableSlot = new ArrayList<>();
		Collections.sort(slots, (a, b) -> a.get(0).compareTo(b.get(0)));

		// handle 00:00 slot
		addValidSlots(availableSlot, LocalTime.of(0, 0), slots.get(0).get(0), minutes);
		for (int x = 0; x < slots.size() - 1; x++) {
			LocalTime firstEnd = slots.get(x).get(1);
			LocalTime secondStart = slots.get(x + 1).get(0);
			addValidSlots(availableSlot, firstEnd, secondStart, minutes);

		}

		// handle 23:59 slot
		addValidSlots(availableSlot, slots.get(slots.size() - 1).get(1), LocalTime.of(23, 59), minutes);
		return availableSlot;
	}

	private void addValidSlots(List<String> availableSlot, LocalTime from, LocalTime to, int minutes) {
		long minutesDiff = Duration.between(from, to).getSeconds() / 60;
		if (minutesDiff >= minutes) {
			if (to.getHour() == 23 && to.getMinute() == 59)
				availableSlot.add(from.format(dtf) + " " + LocalTime.of(0, 0).format(dtf));
			else
				availableSlot.add(from.format(dtf) + " " + to.format(dtf));
		}
	}
}
