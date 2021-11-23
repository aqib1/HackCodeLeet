import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ThrottlingGatewayProblem1 {

    public static void main(String[] args) {
        // test case 1 -> empty list or null return 0
        System.out.println(droppedRequests(Collections.emptyList()) == 0);
        System.out.println(droppedRequests(null) == 0);
        // test case 2 -> in first second we should only
        // have 3 requests and rest dropped
        System.out.println(droppedRequests(Arrays.asList(1,1,1,1)) == 1);
        System.out.println(droppedRequests(Arrays.asList(1,1,1,1,1,1)) == 3);
        // test case 3 -> in first 10 seconds only 20 requests allowed
        System.out.println(droppedRequests(Arrays.asList(
                1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7
        )) == 4);
        // test case 4 -> in first 1 minute only 60 requests allowed
        System.out.println(droppedRequests(Arrays.asList(
                1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11
        )) == 4);
    }
    public static int droppedRequests(List<Integer> requestTime) {
        if(Objects.isNull(requestTime) || requestTime.isEmpty()) {
            return 0;
        }

        int dropped = 0;
        for(int noOfRequests = 0; noOfRequests < requestTime.size(); noOfRequests++) {
            if(noOfRequests  > 2 && requestTime.get(noOfRequests).equals(requestTime.get(noOfRequests - 3))) {
                dropped++;
            } else if(noOfRequests > 19 && (requestTime.get(noOfRequests) - requestTime.get(noOfRequests - 20) < 10)) {
                dropped++;
            } else if(noOfRequests > 59 && (requestTime.get(noOfRequests) - requestTime.get(noOfRequests - 60) < 60)) {
                dropped++;
            }
        }

        return dropped;
    }
}
