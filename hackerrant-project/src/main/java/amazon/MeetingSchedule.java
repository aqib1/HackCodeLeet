package amazon;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingSchedule {

	public static List<List<LocalTime>> getSlots(int minutes, List<List<LocalTime>> slots) {
		List<List<LocalTime>> availableSlot = new ArrayList<>();
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

	private static void addValidSlots(List<List<LocalTime>> availableSlot, LocalTime from, LocalTime to, int minutes) {
		long minutesDiff = Duration.between(from, to).getSeconds() / 60;
		if (minutesDiff >= minutes) {
			if (to.getHour() == 23 && to.getMinute() == 59)
				availableSlot.add(Arrays.asList(from, LocalTime.of(0, 0)));
			else
				availableSlot.add(Arrays.asList(from, to));
		}
	}

	public static void main(String[] args) {
		int k = 10;
		List<List<LocalTime>> slots = new ArrayList<>();
		List<LocalTime> date = new ArrayList<>();
		date.add(LocalTime.of(07, 45));
		date.add(LocalTime.of(07, 47));
		slots.add(date);
		date = new ArrayList<>();
		date.add(LocalTime.of(3, 28));
		date.add(LocalTime.of(3, 30));
		slots.add(date);
		date = new ArrayList<>();
		date.add(LocalTime.of(9, 50));
		date.add(LocalTime.of(9, 51));
		slots.add(date);
		date = new ArrayList<>();
		date.add(LocalTime.of(15, 44));
		date.add(LocalTime.of(15, 45));
		slots.add(date);
		date = new ArrayList<>();
		date.add(LocalTime.of(22, 8));
		date.add(LocalTime.of(22, 9));
		slots.add(date);
		date = new ArrayList<>();
		date.add(LocalTime.of(20, 42));
		date.add(LocalTime.of(20, 43));
		slots.add(date);
		date = new ArrayList<>();
		date.add(LocalTime.of(18, 20));
		date.add(LocalTime.of(18, 21));
		slots.add(date);
		date = new ArrayList<>();
		date.add(LocalTime.of(7, 34));
		date.add(LocalTime.of(7, 35));
		slots.add(date);
		date = new ArrayList<>();
		date.add(LocalTime.of(8, 36));
		date.add(LocalTime.of(8, 37));
		slots.add(date);
		date = new ArrayList<>();
		date.add(LocalTime.of(9, 43));
		date.add(LocalTime.of(9, 45));
		slots.add(date);
		List<List<LocalTime>> result = getSlots(k, slots);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH mm");
		for (List<LocalTime> r : result) {
			System.out.print(r.get(0).format(dtf) + " " + r.get(1).format(dtf));
			System.out.println();
		}
//		try (Scanner in = new Scanner(System.in)) {
//			int M = in.nextInt();
//			int k = in.nextInt();
//			List<List<LocalTime>> slots = new ArrayList<>();
//			for (int x = 0; x < M; x++) {
//				List<LocalTime> date = new ArrayList<>();
//				int startHH = in.nextInt();
//				int startMM = in.nextInt();
//				int endHH = in.nextInt();
//				int endMM = in.nextInt();
//				date.add(LocalTime.of(startHH, startMM));
//				date.add(LocalTime.of(endHH, endMM));
//				slots.add(date);
//			}
//			List<List<LocalTime>> result = getSlots(k, slots);
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH mm");
//			for (List<LocalTime> r : result) {
//				System.out.print(r.get(0).format(dtf) + " " + r.get(1).format(dtf));
//				System.out.println();
//			}
//		}

	}
}
