public class ArrayAlgorithms {

   // DO NOT CHANGE THE VARIABLE NAME
   private int[] intArray;

   /*
   * ASSUMPTIONS FOR THIS ASSIGNMENT:
   * 1) arraySize will always be >= 1
   * 2) Random numbers should be in the range 0 - 99 (inclusive)
   */
   
   public void p() {
      for (int n : intArray) System.out.print(n + " ");
      System.out.println("");
   }

   public ArrayAlgorithms(int arraySize) {
      // REQUIRED: initialize intArray to be of size arraySize
      intArray = new int[arraySize];
   }

   public void populateArrayWithRandom() {
      // REQUIRED: populate intArray with random integers from 0 - 99
      for (int i=0; i<intArray.length; i++) {
         intArray[i] = (int)(Math.random()*100.0);
      }
   }

   public void populateArrayWithSequential(int startNum) {
      // REQUIRED: populate intArray with sequential integers starting at startNum
      for (int i = 0; i < intArray.length; i++) {
         intArray[i] = startNum + i;
      }
   }

   public int findMax() {
      // REQUIRED: return the largest integer in intArray
      int record = -1;
      for (int n : intArray) {
         if (n > record) record = n;
      }
      return record;
   }

   public boolean hasDuplicates() {
      // REQUIRED: return true if there are duplicate values in the array
      // HINT: use a nested for loop
      for (int i = 0; i < intArray.length-1; i++) {
         for (int j = i+1; j < intArray.length; j++) {
            if (intArray[j] == intArray[i]) return true;
         }
      }
      return false;
   }

   public boolean isInArray(int intToFind) {
      // REQUIRED: return true if intToFind is in intArray.
      // NOTE: Use an enhanced for loop for this method
      for (int n : intArray) {
         if (n == intToFind) return true;
      }
      return false;
   }

   // ===== UWHS ALGORITHMS =====

   public int longestContiguousSubarray() {
      // UWHS ONLY:
      // Return the length of the longest strictly increasing contiguous segment
      int recordStreak = 1;
      int currentStreak = 1;
      for (int i = 1; i < intArray.length; i++) {
         if (intArray[i] > intArray[i-1]) {
            currentStreak++;
            if (currentStreak > recordStreak) recordStreak++;
         } else {
            currentStreak = 1;
         }
      }
      return recordStreak;
   }

   public int[] moveZeroesToEnd() {
      // UWHS ONLY:
      // Move all zeros to the end of while preserving order of non-zero elements. 
      // HINT: use a new array instead of changing intArray
      // Return the changed array
      int[] newArray = new int[intArray.length];
      int counter = 0;
      for (int n : intArray) {
         if (n != 0) {
            newArray[counter] = n;
            counter++;
         }
      }
      return newArray;
   }

   public static void main(String[] args) {
      // REQUIRED:
      // 1) Create an ArrayAlgorithms object
      ArrayAlgorithms aa = new ArrayAlgorithms(5);
      // 2) Populate the array with random numbers
      aa.populateArrayWithRandom();
      aa.p();
      // 3) Call and print the result of EACH REQUIRED method
      aa.populateArrayWithSequential(3);
      aa.p();
      System.out.println(aa.findMax());
      System.out.println(aa.hasDuplicates());
      System.out.println(aa.isInArray(4));
      // 4) If you are UWHS, also test the UWHS methods
      aa = new ArrayAlgorithms(20);
      aa.populateArrayWithRandom();
      System.out.println(aa.longestContiguousSubarray());
      int[] testing = aa.moveZeroesToEnd();
      for (int n : testing) System.out.print(n + " ");
   }
}
