public class MinimumStepsToDesiredArray
{
    int stepsToDesiredArray(int[] target)
    {
	int N = target.length;
	int[] array = new int[N];

	int min = min(target);
	int max = max(target);

	if (N == 0) {
	    return -1;
	}

	int countSteps = 0;
	
	if (min > 0) {
	    for (int i = 0; i < N; i++) {
		increment(array, i);
		countSteps++;
	    }

	    while (2 * array[0] <= min) {
		doubleit(array);
		countSteps++;
	    }
	}

	for (int i = 0; i < N; i++) {
	    while (array[i] < target[i]) {
		increment(array, i);
		countSteps++;
	    }
	}

	return countSteps;
    }

    void increment(int[] array, int i)
    {
	array[i] += 1;
    }

    void doubleit(int[] array)
    {
	for (int i = 0; i < array.length; i++) {
	    array[i] *= 2;
	}
    }

    int min(int[] array)
    {
	int min = Integer.MAX_VALUE;

	for (int i = 0; i < array.length; i++) {
	    if (array[i] < min) {
		min = array[i];
	    }
	}
	
	return min;
    }

    int max(int[] array)
    {
	int max = Integer.MIN_VALUE;

	for (int i = 0; i < array.length; i++) {
	    if (array[i] > max) {
		max = array[i];
	    }
	}

	return max;
    }

    public static void main(String[] args) {
	int[] t1 = {16, 16, 16};
	MinimumStepsToDesiredArray ms = new MinimumStepsToDesiredArray();
	System.out.println(ms.stepsToDesiredArray(t1));
    }
}
