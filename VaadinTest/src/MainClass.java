import java.util.stream.IntStream;;

/**
 * 
 * a console application take all argument and will out highest number
 * 
 */
public class MainClass {

	//
//	public static int maxInteger(List<Integer> data) {
//		return data.stream().distinct().max(Integer::compareTo).orElseGet(() -> {
//			throw new EmptyStackException();
//		});
//	}

	// 1,2,3,4,5 -> 5,1,2,3,4
	// -> []
//	public static int[] rotateArr(int[] arr) {
//		int[] rotate = new int[arr.length];
//		rotate[0] = arr[arr.length - 1];
//		for (int x = 0; x < arr.length - 1; x++)
//			rotate[x + 1] = arr[x];
//
//		return rotate;
//	}

	// In the Fibonacci sequence of numbers, each number is the sum of the

	// previous two numbers, starting with 1 and 1. This sequence begins:

	

	// Your task is to create a method fibonacciAverage(int COUNT) that

	// returns the average of COUNT first Fibonacci numbers.

	// Let’s do this in the Java 8 way, and create an IntStream that emits

	// Fibonacci numbers. Then we can solve the problem simply by calling

	// IntStream.average(). You can use Google
	
	public static int sumFab(int count) {
		if(count == 0)
			return 0;
		if(count == 1 || count == 2)
			return 1;
		return sumFab(count-1) + sumFab(count-2);
	}
	
	// 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	public static double getAverageOfFib(int COUNT) {
		if(COUNT == 0)
			return 0;
		if(COUNT <= 2) {
			return COUNT / COUNT;
		}
		int [] arr = new int[COUNT];
		arr[0] = 1;
		arr[1] = 1;
		IntStream.range(2, COUNT).forEach(val -> {
			arr[val] = arr[val-1] + arr[val-2];
		});
		return IntStream.of(arr).average().getAsDouble();
	}
	
	public static void main(String[] args) {
		
		System.out.println(getAverageOfFib(5));
		
//		if(Objects.isNull(args) || args.length == 0) {
//			throw new RuntimeException("Arguments should be provided to run");
//		}
//		System.out.println(Arrays.toString(rotateArr(new int[] {4, 5, 1, 2, 3})));
//		
//		PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>((a, b) -> b.compareTo(a));
//		
//		for(int x=0; x<args.length;x++) {
//			try {
//				max_heap.offer(Integer.parseInt(args[x]));
//			} catch(NumberFormatException e) {
////				// skip it
//			}
//		}
//		
//		System.out.println(max_heap.poll());

//		ofNullable(args).ifPresentOrElse(x -> {
//			List<Integer> numericData = new ArrayList<>();
//			Arrays.stream(x).forEach(val -> {
//				try {
//					numericData.add(Integer.parseInt(val));
//				} catch(NumberFormatException e) {
//					// skip it
//				}
//			});
//			System.out.println(maxInteger(numericData));
//		}, () -> {
//			throw new RuntimeException(String.format("Arguments should be provided to run"));
//		});
	}
}
