package amazon;

import java.lang.reflect.Method;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MettingScheduleTest {
	private MeetingSchedule meetingSchedule;

	@Before
	public void init() {
		meetingSchedule = new MeetingSchedule();
	}

	@Test
	public void testGetSlots() {
		int k = 120;
		List<List<LocalTime>> slots = new ArrayList<>();
		List<LocalTime> date = new ArrayList<>();
		date.add(LocalTime.of(16, 0));
		date.add(LocalTime.of(17, 0));
		slots.add(date);
		date = new ArrayList<>();
		date.add(LocalTime.of(10, 30));
		date.add(LocalTime.of(14, 30));
		slots.add(date);
		date = new ArrayList<>();
		date.add(LocalTime.of(20, 45));
		date.add(LocalTime.of(22, 15));
		slots.add(date);
		date = new ArrayList<>();
		date.add(LocalTime.of(10, 0));
		date.add(LocalTime.of(13, 15));
		slots.add(date);
		date = new ArrayList<>();
		date.add(LocalTime.of(9, 0));
		date.add(LocalTime.of(11, 0));
		slots.add(date);

		List<String> result = meetingSchedule.getSlots(k, slots);
		Assert.assertTrue(result.size() == 2);
		Assert.assertEquals(result.get(0), "00 00 09 00");
		Assert.assertEquals(result.get(1), "17 00 20 45");
	}

	@Test
	public void getSlotsMethodTest() throws NoSuchMethodException, SecurityException {
		String methodName = "getSlots";
		Class<?> c = MeetingSchedule.class;
		Method method = c.getDeclaredMethod(methodName, int.class, List.class);
		Assert.assertNotNull(method);
	}
}
