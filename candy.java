public class candy {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
	for (int i = 0; i < candy.length; i++) {
	    candy[i] = 1;
	}
	for (int i = 0; i < candy.length - 1; i++) {
	    if (ratings[i] < ratings[i + 1]) {
		candy[i + 1] = Math.max(candy[i + 1], candy[i] + 1);
	    }
	}
	for (int i = candy.length - 1; i > 0; i--) {
	    if (ratings[i - 1] > ratings[i]) {
		candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
	    }
	}
	int sum = 0;
	for (int i = 0; i < candy.length; i++) {
	    sum += candy[i];
	}
	return sum;
    }
    public static void main(String[] args) {
	candy solution = new candy();
	int[] ratings = {4, 2, 3, 4, 1};
	System.out.println(solution.candy(ratings));
    }
}