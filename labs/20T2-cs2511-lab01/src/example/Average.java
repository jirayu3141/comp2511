//package example;

public class Average {

        /**
         * Returns the average of an array of numbers
         * @param the array of integer numbers
         * @return the average of the numbers
         */
        public float average(int[] nums) {
            float result = 0;
            // Add your code
            for (int i = 0; i < nums.length; i++) {
                result += nums[i];
            }
            //check for 0
            if (nums.length != 0) {
                result = result/nums.length;
            }

            return result;
        }

        public static void main(String[] args) {
            int[] intArray = new int[]{ 1,2,3};     // create new array
            Average ave_instance = new Average();   // create new instance of the class
            System.out.println("The average is "+ ave_instance.average(intArray));  // compute the average and print out
        }
}
