import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ThrottlingGatewayProblem2 {

    public static void main(String[] args) {
        // test case 1: for null or empty return 0
        System.out.println(droppedRequests(Collections.emptyList()) == 0);
        System.out.println(droppedRequests(null) == 0);
        // test case 2: only 3 request allowed in 1 second
        System.out.println(droppedRequests(Arrays.asList(1,1,1,1)) == 1);
        System.out.println(droppedRequests(Arrays.asList(1,1,1,1,1)) == 2);
        System.out.println(droppedRequests(Arrays.asList(1,1,1,1,1,1,1,1,1)) == 6);
        // test case 3: only 20 requests allowed in 10 seconds
        System.out.println(droppedRequests(Arrays.asList(1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7)) == 4);
        // test case 4 only 59 request allowed in 1 minute
    }
    public static int droppedRequests(List<Integer> requestTime) {
        if(Objects.isNull(requestTime) || requestTime.isEmpty())
            return 0;
        int dropped = 0;
        for(int noOfRequests = 0; noOfRequests < requestTime.size(); noOfRequests++) {
            if(noOfRequests > 2 && requestTime.get(noOfRequests).equals(requestTime.get(noOfRequests - 3))) {
                dropped++;
            } else if(noOfRequests > 19 && (requestTime.get(noOfRequests) - requestTime.get(noOfRequests - 20)) < 10) {
                dropped++;
            } else if(noOfRequests > 59 && (requestTime.get(noOfRequests) - requestTime.get(noOfRequests - 60)) < 60) {
                dropped++;
            }
        }
        return dropped;
    }
}
