package leetcode.amazon;

import java.util.Objects;

/*
 * A new Amazon-developed scaling computing system checks the average utilization of the computing system every second while it monitors. It implements an autoscale policy to add or reduce instances depending on the current load as described below. Once an action of adding or reducing the number of instances is performed, the system will stop monitoring for 10 seconds. During that time, the number of instances does not change.

Average utilization < 25%: An action is instantiated to reduce the number of instances by half if the number of instances is greater than 1 (take the ceiling if the number is not an integer). If the number of instances is 1, take no action.
25% <= Average utilization <= 60%: Take no action.
Average utilization > 60%: An action is instantiated to double the number of instances if the doubled value does not exceed 2* 10^8. If the number of instances exceeds this limit upon doubling, perform no action.
Given an array of integers that represent the average utilization at each second, determine the number of instances at the end of the time frame.

Example

instances = 2
averageUtil = [25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80]

At second 1, the average utilization averageUtil[0] = 25 <= 25. Take no action.
At second 2, the average utilization averageUtil[1] = 23 < 25. Reduce the number of instances by half, 2/2 = 1.
Since an action was taken, the system will stop checking for 10 seconds, from averageUtil[2] to averageUtil[11].
At averageUtil[12] = 76, 76 > 60 so the number of instances is doubled from 1 to 2.
There are no more readings to consider and 2 is the final answer.
Function Description

Complete the function finallnstances in the editor below.

finallnstances has the following parameter(s):
   int instances: an integer that represents the original number of instances running
   int averageUtil[n]: an array of integers that represents the average utilization at each second of the time frame

Returns:
   int: an integer that represents the final number of instances running.

Contraints

1 <= instances <= 10^5
1 <= n < 10^5
0 <= averageUtil[i] <= 100

Input Format For Custom Testing

Sample Case 0

Sample Input

STDIN       Function
-------       ----------
1         ->  instances = 1 
3         ->  averageUtil[]  size n = 3
5         ->  averageUtil = [5, 10, 80]
10 
80

Sample Output

2

Explanation

At second 1. averageUtil[0] =5<25. The number of instances is 1. so take no action.
At second 2. averageUtil[1] = 10 < 25. The number of instances is 1, so take no action.
At second 3. averageUtil[2] = 80 > 60. An action is instantiated to double the number of instances from 1 to 2.
There are no more readings to consider and 2 is the final answer.

Sample Case 1

Sample Input

STDIN       Function
-------       ----------
5         ->  instances = 5
6         ->  averageUtil[]  size n = 6
30       ->  averageUtil = [30, 5, 4, 8, 19, 89]
5
4
8
19
89 

Sample Output

3

Explanation

At second 1,25 <= averageUtil[0] = 30 <= 60, so take no action.
At second 2, averageUtil[1] = 5<25, so an action is instantiated to halve the number of instances to ceil(5/2) = 3.
The system will stop checking for 10 seconds, so from averageUtil[2] through averageUtil[5] no actions will be taken.
There are no more readings to consider and 3 is the final answer.
 * 
 * */


public class AmazonUtalizationCheck_2K21 {
	
	public static int finalInstances(int instances, int[] averageUtil) {
		if(Objects.isNull(averageUtil) || averageUtil.length ==0)
			return 0;
		
		double maxDoubleNumber = 2 * Math.pow(10, 8);
		int sleep = 10;
		for(int x=0; x<averageUtil.length; x++) {
			if(sleep == 10) {
				if((25 <= averageUtil[x] && averageUtil[x] <=60) || (averageUtil[x] < 25 && instances == 1) || (averageUtil[x] > 60 && instances == maxDoubleNumber))
					continue;
				if(averageUtil[x] < 25)
					instances = (int) Math.ceil((double)instances/2);
				if(averageUtil[x] > 60)
					instances += instances;
				sleep = 0;
			} else ++sleep;
		}
		
		return instances;
	}
	
	
	public static void main(String[] args) {
		System.out.println(finalInstances(2, new int[] {25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80}));
	}
}
