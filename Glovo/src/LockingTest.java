import java.util.concurrent.locks.StampedLock;

public class LockingTest {

	//private static Lock lock = new ReentrantLock(true);
	private static StampedLock lock = new StampedLock();
	public static void test1() throws InterruptedException {
		//synchronized(LockingTest.class) {
		long st = lock.readLock();
		System.out.println("test1 -> " + Thread.currentThread().getName());
		test2(st);
		Thread.sleep(1000);
//		lock.unlock(st);
		//}
	}

	public static void test2(Long st) {
		synchronized(st) {
//		long st = lock.readLock();
		System.out.println("test2 -> " + Thread.currentThread().getName());
//		lock.unlock(st);
		
		}
	}

	public static void main(String[] args) throws InterruptedException {
//			ExecutorService service = Executors.newFixedThreadPool(2);
//			
//			IntStream.range(0, 2).forEach(x -> {
//				service.submit(() -> {test1();});
//			});
//			
//			service.shutdown();
		
		Thread t1 = new Thread(() -> {
			try {
				test1();
				test1();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		});
		
		t1.start();
	}
}
