import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReveneueMilestone {
	public static int[] getMilestoneDays(int[] revenues, int[] milestones) {
		int[] milestonesDays = new int[milestones.length];
		Arrays.fill(milestonesDays, -1);
		Map<Integer, Integer> valueByIndex = new HashMap<>();
		for (int x = 0; x < milestones.length; x++)
			valueByIndex.put(milestones[x], x);

		Arrays.sort(milestones);
		int sum = 0;
		for (int x = 0, y = 0; x < revenues.length; x++) {
			sum +=  revenues[x];
			
			while(y < milestones.length && sum >= milestones[y]) {
				milestonesDays[valueByIndex.get(milestones[y])] =  x + 1;
				y++;
			}
			
		}

		return milestonesDays;
	}

	public static void main(String[] args) {
		int[] r = new int[] { 700, 800, 600, 400, 600, 700 };
		int[] milestones = new int[] {3100, 2200, 800, 2100, 1000};

		System.out.println(Arrays.toString(getMilestoneDays(r, milestones)));
	}
}
