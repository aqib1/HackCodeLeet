import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ThrottlingGatewayProblem {

    public static void main(String[] args) {
        System.out.println(droppedRequests(Arrays.asList(
                1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11
        )));
    }

    public static int droppedRequests(List<Integer> requestTime) {
        if(Objects.isNull(requestTime) || requestTime.isEmpty()) {
            return 0;
        }
        int dropped = 0;
        int [] requestTimeArr = requestTime.stream().mapToInt(i -> i).toArray();
        for(int noOfRequests = 0; noOfRequests < requestTimeArr.length; noOfRequests++) {
            // case 1- when we have to limit only 3 request in first second
            if(noOfRequests > 2 && requestTimeArr[noOfRequests] == requestTimeArr[noOfRequests - 3]) {
                ++dropped;
            } else if (noOfRequests > 19 && (requestTimeArr[noOfRequests] - requestTimeArr[noOfRequests - 20]) < 10) {
                ++dropped;
            } else if (noOfRequests > 59 && (requestTimeArr[noOfRequests] - requestTimeArr[noOfRequests - 60]) < 60) {
                ++dropped;
            }
        }
        return dropped;
    }
}
