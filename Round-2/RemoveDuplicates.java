import java.util.*;

public class RemoveDuplicates {
    
    public static String removeDuplicates(String input) {
        // Track normalized characters (lowercase for letters, exact for digits)
        Set<String> seenNormalized = new HashSet<>();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i); 
            
            // Normalize: lowercase for letters, keep as-is for digits/others
            String normalized = Character.isLetter(ch) ? 
                String.valueOf(Character.toLowerCase(ch)) : String.valueOf(ch);
            
            if (!seenNormalized.contains(normalized)) {
                // First occurrence - keep it
                result.append(ch);
                seenNormalized.add(normalized);
            } else {
                // Duplicate found - find replacement
                char replacement = findReplacement(ch, seenNormalized);
                result.append(replacement);
                
                // Add replacement to seen set
                String replacementNormalized = Character.isLetter(replacement) ? 
                    String.valueOf(Character.toLowerCase(replacement)) : 
                    String.valueOf(replacement);
                seenNormalized.add(replacementNormalized);
            }
        }
        
        return result.toString();
    }
    
    private static char findReplacement(char original, Set<String> seen) {
        if (Character.isLetter(original)) {
            return findLetterReplacement(original, seen);
        } else if (Character.isDigit(original)) {
            return findDigitReplacement(original, seen);
        }
        return original;
    }
    
    private static char findLetterReplacement(char original, Set<String> seen) {
        boolean isUpper = Character.isUpperCase(original);
        char start = isUpper ? 'A' : 'a';
        char end = isUpper ? 'Z' : 'z';
        
        // Start from next character
        char replacement = (char) (original + 1);
        
        // Find next available letter
        while (replacement <= end) {
            if (!seen.contains(String.valueOf(Character.toLowerCase(replacement)))) {
                return replacement;
            }
            replacement++;
        }
        
        // Wrap around if needed
        replacement = start;
        while (replacement <= end) {
            if (!seen.contains(String.valueOf(Character.toLowerCase(replacement)))) {
                return replacement;
            }
            replacement++;
        }
        
        return original; // Fallback
    }
    
    private static char findDigitReplacement(char original, Set<String> seen) {
        int digit = Character.getNumericValue(original);
        
        // Try next digits in sequence, wrapping around
        for (int i = 1; i <= 10; i++) {
            int nextDigit = (digit + i) % 10;
            String nextStr = String.valueOf(nextDigit);
            if (!seen.contains(nextStr)) {
                return (char) ('0' + nextDigit);
            }
        }
        
        return original; // Fallback
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {"Java1234", "Python1223", "aBuzZ9900"};
        String[] expectedOutputs = {"Javb1234", "Python1234", "aBuzC9012"};
        
        System.out.println("Remove Duplicates with Cascading Replacement");
        System.out.println("=" .repeat(60));
        
        for (int i = 0; i < testInputs.length; i++) {
            String input = testInputs[i];
            String output = removeDuplicates(input);
            String expected = expectedOutputs[i];
            
            System.out.println("\nTestcase " + (i + 1) + ":");
            System.out.println("Input:    " + input);
            System.out.println("Output:   " + output);
            System.out.println("Expected: " + expected);
            System.out.println("Status:   " + (output.equals(expected) ? "PASS ✓" : "FAIL ✗"));
        }
    }
}
