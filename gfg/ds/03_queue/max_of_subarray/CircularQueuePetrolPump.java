public class CircularQueuePetrolPump
{
    // returns the starting index of pump from where to do a round
    static int startCircular(int[] petrol, int[] distance)
    {
        int front, back;
        front = back = 0;  // starting index in both arrays

// We will find one petrol pump if we circle the pump twice
// Note: This is at most O(2n)

        int petrolSaved = 0;

        for (int i = 0; i < 2 * petrol.length; i++) {
            int j = i % petrol.length;                      // array index, cannot go out of bound
            petrolSaved += petrol[j];
            petrolSaved -= distance[j];

            if (petrolSaved < 0) {
                petrolSaved = 0;
                front=i+1;			// Move the starting position, because current place was a failure
                back=i+1;
            } else {
                back++;
            }

// If we are able to come back to front, we made a successful round
            if (back != front && back % petrol.length == front) {
                return front;
            }
        }

// could not make a round
// return -1 as indicator of failure
        return -1;
    }

    public static void main(String[] args)
    {
         //int[] petrol = {4, 6, 7, 4};
         //int[] distance = {6, 5, 3, 5};
        int[] petrol = {6, 3, 7};
        int[] distance = {4, 6, 3};

        System.out.println("Starting index: " + startCircular(petrol, distance));
    }
}


