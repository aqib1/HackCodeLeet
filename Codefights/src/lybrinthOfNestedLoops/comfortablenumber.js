function comfortabelNumber(l, r) {
	count = 0;
	for (x = l; x <= r; ++x) {
		for (y = x + 1; y <= r; ++y) {
			sumx = digitsum(x);
			sumy = digitsum(y);
			if (x >= y - sumy && x <= y + sumy && y >= x - sumx && y <= x + sumx)
				count++;
		}
	}
	return count;
}

function digitsum(n) {
	stringval = n.toString();
	sum = 0;
	for (i = 0; i < stringval.length; i++) {
		sum += parseInt(stringval.substring(i, i + 1));
	}
	return sum;
}