public class FrequencySort {
    
    public static int[] sortByFrequency(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        
        int n = arr.length;
        
        // Step 1: Count frequencies manually
        int[] elements = new int[n];
        int[] frequencies = new int[n];
        int uniqueCount = 0;
        
        for (int i = 0; i < n; i++) {
            boolean found = false;
            
            // Check if element already exists in our tracking arrays
            for (int j = 0; j < uniqueCount; j++) {
                if (elements[j] == arr[i]) {
                    frequencies[j]++;
                    found = true;
                    break;
                }
            }
            
            // If not found, add as new unique element
            if (!found) {
                elements[uniqueCount] = arr[i];
                frequencies[uniqueCount] = 1;
                uniqueCount++;
            }
        }
        
        // Step 2: Sort elements based on frequency (descending)
        // If frequencies are equal, maintain original order of first occurrence
        for (int i = 0; i < uniqueCount - 1; i++) {
            for (int j = i + 1; j < uniqueCount; j++) {
                // Swap if frequency is less (we want descending order)
                if (frequencies[i] < frequencies[j]) {
                    // Swap frequencies
                    int tempFreq = frequencies[i];
                    frequencies[i] = frequencies[j];
                    frequencies[j] = tempFreq;
                    
                    // Swap elements
                    int tempElem = elements[i];
                    elements[i] = elements[j];
                    elements[j] = tempElem;
                }
            }
        }
        
        // Step 3: Build result array based on sorted frequencies
        int[] result = new int[n];
        int index = 0;
        
        for (int i = 0; i < uniqueCount; i++) {
            for (int j = 0; j < frequencies[i]; j++) {
                result[index++] = elements[i];
            }
        }
        
        return result;
    }
    
    // Helper method to print array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] arr1 = {6, 4, 7, 13, 4, 6, 4, 4, 13, 4, 6};
        System.out.print("Input:  ");
        printArray(arr1);
        int[] result1 = sortByFrequency(arr1);
        System.out.print("Output: ");
        printArray(result1);
        System.out.println();
        
        // Test Case 2
        System.out.println("Test Case 2:");
        int[] arr2 = {1, 2, 2, 3, 3, 3};
        System.out.print("Input:  ");
        printArray(arr2);
        int[] result2 = sortByFrequency(arr2);
        System.out.print("Output: ");
        printArray(result2);
        System.out.println();
        
        // Test Case 3
        System.out.println("Test Case 3:");
        int[] arr3 = {5, 5, 5, 5};
        System.out.print("Input:  ");
        printArray(arr3);
        int[] result3 = sortByFrequency(arr3);
        System.out.print("Output: ");
        printArray(result3);
    }
}
