package array2;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[7];
        numbers[0] = 1;
        numbers[1] = 1;
        numbers[2] = 5;
        numbers[3] = 5;
        numbers[4] = 10;
        numbers[5] = 8;
        numbers[6] = 7;
        System.out.println(centeredAverage(numbers));
    }

    //Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.
    //countEvens([2, 1, 2, 3, 4]) → 3
    //countEvens([2, 2, 0]) → 3
    //countEvens([1, 3, 5]) → 0
    public static int countEvens(int[] nums) {
        int counter = 0;
        for (int num : nums) {
            if (num % 2 == 0) counter++;
        }
        return counter;
    }

    //Return the sum of the numbers in the array, returning 0 for an empty array.
    //Except the number 13 is very unlucky,
    //so it does not count and numbers that come immediately after a 13 also do not count.
    //sum13([1, 2, 2, 1]) → 6
    //sum13([1, 1]) → 2
    //sum13([1, 2, 2, 1, 13]) → 6
    public static int sum13(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 13) {
                i++;
                continue;
            }
            sum += nums[i];
        }
        return sum;
    }

    //Given an array of ints, return true if the array contains no 1's and no 3's.
    //lucky13([0, 2, 4]) → true
    //lucky13([1, 2, 3]) → false
    //lucky13([1, 2, 4]) → false
    public static boolean lucky13(int[] nums) {
        for (int num : nums) {
            if (num == 1 || num == 3) return false;
        }
        return true;
    }

    //Given a number n, create and return a new int array of length n, containing the numbers 0, 1, 2, ... n-1.
    //The given n may be 0, in which case just return a length 0 array.
    //You do not need a separate if-statement for the length-0 case;
    //the for-loop should naturally execute 0 times in that case, so it just works.
    //The syntax to make a new int array is: new int[desired_length]   (See also: FizzBuzz Code)
    //fizzArray(4) → [0, 1, 2, 3]
    //fizzArray(1) → [0]
    //fizzArray(10) → [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    public static int[] fizzArray(int n) {
        int[] modArray = new int[n];
        for (int i = 0; i < modArray.length; i++) {
            modArray[i] = i;
        }
        return modArray;
    }

    //Given an array of ints, return true if it contains no 1's or it contains no 4's.
    //no14([1, 2, 3]) → true
    //no14([1, 2, 3, 4]) → false
    //no14([2, 3, 4]) → true
    public static boolean no14(int[] nums) {
        boolean is4 = false;
        boolean is1 = false;
        for (int num : nums) {
            if (num == 4) {
                is4 = true;
                break;
            }
        }
        for (int num : nums) {
            if (num == 1) {
                is1 = true;
                break;
            }
        }
        return (!(is1 && is4));
    }

    //Given arrays nums1 and nums2 of the same length, for every element in nums1,
    //consider the corresponding element in nums2 (at the same index).
    //Return the count of the number of times that the two elements differ by 2 or less, but are not equal.
    //matchUp([1, 2, 3], [2, 3, 10]) → 2
    //matchUp([1, 2, 3], [2, 3, 5]) → 3
    //matchUp([1, 2, 3], [2, 3, 3]) → 2
    public static int matchUp(int[] nums1, int[] nums2) {
        int counter = 0;
        for (int i = 0; i < nums1.length; i++) {
            if ((Math.abs(nums1[i] - nums2[i]) <= 2) && (nums1[i] != nums2[i])) counter++;
        }
        return counter;
    }

    //Given an array of ints, return true if the array contains either 3 even or 3 odd values all next to each other.
    //modThree([2, 1, 3, 5]) → true
    //modThree([2, 1, 2, 5]) → false
    //modThree([2, 4, 2, 5]) → true
    public static boolean modThree(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if ((nums[i] % 2 == 0 && nums[i + 1] % 2 == 0 && nums[i + 2] % 2 == 0) || (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0 && nums[i + 2] % 2 != 0))
                return true;
        }
        return false;
    }

    //Return true if the group of N numbers at the start and end of the array are the same.
    //For example, with {5, 6, 45, 99, 13, 5, 6},
    //the ends are the same for n=0 and n=2, and false for n=1 and n=3.
    //You may assume that n is in the range 0..nums.length inclusive.
    //sameEnds([5, 6, 45, 99, 13, 5, 6], 1) → false
    //sameEnds([5, 6, 45, 99, 13, 5, 6], 2) → true
    //sameEnds([5, 6, 45, 99, 13, 5, 6], 3) → false
    public static boolean sameEnds(int[] nums, int len) {
        int i = 0;
        while (i < len) {
            if (nums[i] != nums[(nums.length - len) + i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    //Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}.
    //You may modify and return the given array, or return a new array.
    //shiftLeft([6, 2, 5, 3]) → [2, 5, 3, 6]
    //shiftLeft([1, 2]) → [2, 1]
    //shiftLeft([1]) → [1]
    public static int[] shiftLeft(int[] nums) {
        int[] modNums = new int[nums.length];
        if (modNums.length == 0) return modNums;
        for (int i = 0; i < nums.length - 1; i++) {
            modNums[i] = nums[i + 1];
        }
        modNums[nums.length - 1] = nums[0];

        return modNums;
    }

    //Given a non-empty array of ints,
    //return a new array containing the elements from the original array that come after the last 4 in the original array.
    //The original array will contain at least one 4. Note that it is valid in java to create an array of length 0.
    //post4([2, 4, 1, 2]) → [1, 2]
    //post4([4, 1, 4, 2]) → [2]
    //post4([4, 4, 1, 2, 3]) → [1, 2, 3]
    public static int[] post4(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) index = i;
        }
        int[] numsMod = new int[nums.length - (index + 1)];
        for (int i = 0; i < numsMod.length; i++) {
            numsMod[i] = nums[index + 1];
            index++;
        }
        return numsMod;
    }

    //Return a version of the given array where all the 10's have been removed.
    //The remaining elements should shift left towards the start of the array as needed,
    //and the empty spaces a the end of the array should be 0. So {1, 10, 10, 2} yields {1, 2, 0, 0}.
    //You may modify and return the given array or make a new array.
    //withoutTen([1, 10, 10, 2]) → [1, 2, 0, 0]
    //withoutTen([10, 2, 10]) → [2, 0, 0]
    //withoutTen([1, 99, 10]) → [1, 99, 0]
    public static int[] withoutTen(int[] nums) {
        int[] numsMod = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 10) continue;
            else numsMod[j] = nums[i];
            j++;
        }
        return numsMod;
    }

    //This is slightly more difficult version of the famous FizzBuzz problem
    //which is sometimes given as a first problem for job interviews.
    //(See also: FizzBuzz Code.) Consider the series of numbers beginning at start and running up to
    //but not including end, so for example start=1 and end=5 gives the series 1, 2, 3, 4.
    //Return a new String[] array containing the string form of these numbers,
    //except for multiples of 3, use "Fizz" instead of the number,
    //for multiples of 5 use "Buzz", and for multiples of both 3 and 5 use "FizzBuzz".
    //In Java, String.valueOf(xxx) will make the String form of an int or other type.
    //This version is a little more complicated than the usual version
    //since you have to allocate and index into an array instead of just printing,
    //and we vary the start/end instead of just always doing 1..100.
    public static String[] fizzBuzz(int start, int end) {
        int capacity = end - start;
        int j = 0;
        String[] fizzBuzzArr = new String[capacity];
        for (int i = start; i < end; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzArr[j] = "FizzBuzz";
            } else if (i % 3 == 0) {
                fizzBuzzArr[j] = "Fizz";
            } else if (i % 5 == 0) {
                fizzBuzzArr[j] = "Buzz";
            } else {
                fizzBuzzArr[j] = String.valueOf(i);
            }
            j++;
        }
        return fizzBuzzArr;
    }

    //Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array.
    //Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.
    //bigDiff([10, 3, 5, 6]) → 7
    //bigDiff([7, 2, 10, 9]) → 8
    //bigDiff([2, 10, 7, 2]) → 8
    public static int bigDiff(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max - min;
    }

    //Return the sum of the numbers in the array,
    //except ignore sections of numbers starting with a 6 and extending to the next 7
    //(every 6 will be followed by at least one 7). Return 0 for no numbers.
    //sum67([1, 2, 2]) → 5
    //sum67([1, 2, 2, 6, 99, 99, 7]) → 5
    //sum67([1, 1, 6, 7, 2]) → 4
    public static int sum67(int[] nums) {
        int sum = 0;
        boolean stop = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 6) stop = true;
            if (!stop) sum += nums[i];
            if (nums[i] == 7 && stop) {
                stop = false;
            }
        }
        return sum;
    }

    //Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
    //sum28([2, 3, 2, 2, 4, 2]) → true
    //sum28([2, 3, 2, 2, 4, 2, 2]) → false
    //sum28([1, 2, 3, 4]) → false
    public static boolean sum28(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (num == 2) sum += 2;
        }
        return sum == 8;
    }

    //Given an array of ints, return true if every element is a 1 or a 4.
    //only14([1, 4, 1, 4]) → true
    //only14([1, 4, 2, 4]) → false
    //only14([1, 1]) → true
    public static boolean only14(int[] nums) {
        for (int num : nums) {
            if (num != 1 && num != 4) return false;
        }
        return true;
    }

    //We'll say that a value is "everywhere" in an array if for every pair of adjacent elements in the array,
    //at least one of the pair is that value. Return true if the given value is everywhere in the array.
    //isEverywhere([1, 2, 1, 3], 1) → true
    //isEverywhere([1, 2, 1, 3], 2) → false
    //isEverywhere([1, 2, 1, 3, 4], 1) → false
    public static boolean isEverywhere(int[] nums, int val) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (!(nums[i] == val || nums[i + 1] == val)) return false;
        }
        return true;
    }

    //Given an array of ints, return true if the array contains two 7's next to each other,
    //or there are two 7's separated by one element, such as with {7, 1, 7}.
    //has77([1, 7, 7]) → true
    //has77([1, 7, 1, 7]) → true
    //has77([1, 7, 1, 1, 7]) → false
    public static boolean has77(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 7 && nums[i + 1] == 7) return true;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 7 && nums[i + 2] == 7) return true;
        }
        return false;
    }

    //Given an array of ints, return true if the value 3 appears in the array exactly 3 times, and no 3's are next to each other.
    //haveThree([3, 1, 3, 1, 3]) → true
    //haveThree([3, 1, 3, 3]) → false
    //haveThree([3, 4, 3, 3, 4]) → false
    public static boolean haveThree(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                counter++;
            }
            if (i + 1 < nums.length) {
                if (nums[i] == 3 && nums[i + 1] == 3) return false;
            }
        }
        return (counter == 3);
    }

    //Return true if the array contains, somewhere, three increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25.
    //tripleUp([1, 4, 5, 6, 2]) → true
    //tripleUp([1, 2, 3]) → true
    //tripleUp([1, 2, 4]) → false
    public static boolean tripleUp(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if ((nums[i + 1] - nums[i]) == 1 && (nums[i + 2] - nums[i + 1]) == 1) return true;
        }
        return false;
    }

    //For each multiple of 10 in the given array, change all the values following it to be that multiple of 10,
    //until encountering another multiple of 10. So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
    //tenRun([2, 10, 3, 4, 20, 5]) → [2, 10, 10, 10, 20, 20]
    //tenRun([10, 1, 20, 2]) → [10, 10, 20, 20]
    //tenRun([10, 1, 9, 20]) → [10, 10, 10, 20]
    public static int[] tenRun(int[] nums) {
        int[] numsMod = new int[nums.length];
        boolean keep = false;
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!keep && (nums[i] % 10 != 0)) {
                numsMod[i] = nums[i];
            }
            if (!keep && nums[i] % 10 == 0) {
                x = nums[i];
                numsMod[i] = x;
                keep = true;
            }
            if (keep && nums[i] != 10) {
                numsMod[i] = x;
            }
            if (keep && nums[i] % 10 == 0) {
                numsMod[i] = nums[i];
                x = nums[i];
            }
        }
        return numsMod;
    }

    //We'll say that an element in an array is "alone" if there are values before and after it,
    //and those values are different from it.
    //Return a version of the given array
    //where every instance of the given value which is alone is replaced by whichever value to its left or right is larger.
    //notAlone([1, 2, 3], 2) → [1, 3, 3]
    //notAlone([1, 2, 3, 2, 5, 2], 2) → [1, 3, 3, 5, 5, 2]
    //notAlone([3, 4], 3) → [3, 4]
    public static int[] notAlone(int[] nums, int val) {
        if (nums.length < 3) return nums;
        int[] numsMod = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsMod[i] = nums[i];
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i + 1] != nums[i] && nums[i + 2] != nums[i + 1] && val == nums[i + 1]) {
                numsMod[i] = nums[i];
                numsMod[i + 1] = Math.max(nums[i], nums[i + 2]);
            } else {
                numsMod[i + 1] = nums[i + 1];
            }
        }
        return numsMod;
    }

    //Return a version of the given array where each zero value in the array
    //is replaced by the largest odd value to the right of the zero in the array.
    //If there is no odd value to the right of the zero, leave the zero as a zero.
    //zeroMax([0, 5, 0, 3]) → [5, 5, 3, 3]
    //zeroMax([0, 4, 0, 3]) → [3, 4, 3, 3]
    //zeroMax([0, 1, 0]) → [1, 1, 0]
    public static int[] zeroMax(int[] nums) {
        if (nums.length < 2) return nums;
        boolean is0 = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int max = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0 && nums[j] % 2 != 0 && nums[j] > max) {
                        max = nums[j];
                    }
                    if (nums[j] == 0) {
                        break;
                    }
                }
                nums[i] = max;
            }
        }
        return nums;
    }

    /*
    Return the "centered" average of an array of ints, which we'll say is the mean average of the values,
    except ignoring the largest and smallest values in the array. If there are multiple copies of the smallest value,
    ignore just one copy, and likewise for the largest value.
    Use int division to produce the final average. You may assume that the array is length 3 or more.
    centeredAverage([1, 2, 3, 4, 100]) → 3
    centeredAverage([1, 1, 5, 5, 10, 8, 7]) → 5
    centeredAverage([-10, -4, -2, -4, -2, 0]) → -3
    */
    public static int centeredAverage(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // find min and max
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        // min and max counter
        int minCounter = 0;
        int maxCounter = 0;
        for (int num : nums) {
            if (num == min) minCounter++;
            if (num == max) maxCounter++;
        }
        minCounter--;
        maxCounter--;
        int sum = 0;
        int numbersCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != min && nums[i] != max) {
                sum += nums[i];
                numbersCounter++;
            }
            if (nums[i] == min) {
                if (minCounter > 0) {
                    sum += nums[i];
                    numbersCounter++;
                    minCounter--;
                }
            }
            if (nums[i] == max) {
                if (maxCounter > 0) {
                    sum += nums[i];
                    numbersCounter++;
                    maxCounter++;
                }
            }
        }
        return sum / numbersCounter;
    }

}
