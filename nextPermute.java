import java.util.*;

public class nextPermute {
    public void nextPermutation(int[] num) {
        // Start from the end, find the first pair with num[i] < num[i + 1]
	int i, j;
	for (i = num.length - 2; i >= 0; i--) {
	    if (num[i] < num[i + 1]) {
		break;
	    }
	}
	// The sequence decreases monotonically --> Reverse the sequence
	if (i < 0) {
	    for (j = 0; j < num.length / 2; j++) {
		int tmp = num[j];
		num[j] = num[num.length - j - 1];
		num[num.length - j - 1] = tmp;
	    }
	    return;
	}
	// Start from (i + 1), find the first position j s.t. num[j + 1] < num[i]
	for (j = i + 1; j < num.length; j++) {
	    if ((j == num.length - 1) || (num[j + 1] <= num[i])) {
		break;
	    }
	}
	// Swap num[i] and num[j]
        int tmp = num[i];
        num[i] = num[j];
	num[j] = tmp;
	// Sort num[(i+1)..(num.length-1)]
	Arrays.sort(num, i + 1, num.length);
    }
    public static void main(String[] args) {
	nextPermute solution = new nextPermute();
	int[] num = {1, 5, 1, 1};
	solution.nextPermutation(num);
	for (int i = 0; i < num.length; i++) {
	    System.out.print(num[i] + " ");
	}
	System.out.println();
    }
}