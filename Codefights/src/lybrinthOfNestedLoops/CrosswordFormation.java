package lybrinthOfNestedLoops;

public class CrosswordFormation {

	static int crosswordFormation(String[] words) {
		int crosses = 0;
		for (int c = 0; c < words.length; c++) {
			for (int d = 0; d < words.length; d++) {
				for (int x = 0; x < words.length; x++) {
					for (int y = 0; y < words.length; y++) {
						if (c != d && c != x && c != y && d != x && d != y && x != y) {
							crosses += getCrosses(words[c], words[d], words[x], words[y]);
						}
					}
				}
			}
		}
		return crosses;
	}

	private static int getCrosses(String a, String b, String c, String d) {
		int yTopA = 0, yBotA = 0, yTopB = 0, yBotB = 0, xTopA = 0, xTopB = 0, xBotA = 0, xBotB = 0;
		for (int x = 0; x < a.length(); x++) {
			if (!c.contains(String.valueOf(a.charAt(x))))
				continue;
			for (int y = 0; y < c.length(); y++) {
				if (a.charAt(x) == c.charAt(y)) {
					xTopA = y;
					yTopA = x;
					for (int z = 0; z < b.length(); z++) {
						if (!c.contains(String.valueOf(b.charAt(z))))
							continue;
						for (int t = y + 1; t < c.length(); t++) {
							if (b.charAt(z) == c.charAt(t)) {
								xTopB = t;
								yTopB = z;
								for (int f = z + 1; f < b.length(); f++) {
									if (!d.contains(String.valueOf(b.charAt(f))))
										continue;
									for (int g = 0; g < d.length(); g++) {
										if (b.charAt(f) == d.charAt(g)) {
											xBotB = g;
											yBotB = f;
											for (int h = x + 1; h < a.length(); h++) {
												if (!d.contains(String.valueOf(a.charAt(h))))
													continue;
												for (int o = 0; o < d.length(); o++) {
													if (d.charAt(o) == a.charAt(h)) {
														xBotA = o;
														yBotA = h;
														int ver1Diff = (yBotA - yTopA);
														int ver2Diff = (yBotB - yTopB);
														int hori1Diff = (xBotB - xBotA);
														int hori2Diff = (xTopB - xTopA);
														if (ver1Diff >= 1 && hori1Diff >= 1 && ver1Diff == ver2Diff
																&& hori1Diff == hori2Diff) {
															return 1;
														}
													}

												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		System.out.println(crosswordFormation(new String[] { "eternal", 
				 "texas", 
				 "chainsaw", 
				 "massacre" }));
	}

}
