package piglatin;

import java.lang.reflect.Method;
import java.util.Scanner;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();
        private Method getContents;
        private Method setContents;
        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        String[] originalContent = input.getContents();
        String[] translatedContent = new String[originalContent.length];
        
        for (int i = 0; i < originalContent.length; i++) {
            translatedContent[i] = translate(originalContent[i]);
        }
        
        translatedBook.setContents(translatedContent);
        
        return translatedBook;
    }

    public static String translate(String input) {
        
        input = input.toLowerCase();
        
        char firstChar = input.charAt(0);
        String vowels = "aeiouy" + "AEIOUY";
        
        if (vowels.indexOf(firstChar) != -1) {
            return input + "way";
        } else {
            int firstVowelIndex = -1;
            for (int i = 0; i < input.length(); i++) {
                if (vowels.indexOf(input.charAt(i)) != -1) {
                    firstVowelIndex = i;
                    break;
                }
            }

            if (firstVowelIndex != -1) {
                String consonants = input.substring(0, firstVowelIndex);
                String restOfWord = input.substring(firstVowelIndex);
                return restOfWord + consonants + "ay";
            } else {
                return input + "ay";
            }
        }
    }



    public static String translateWord(String input) {

        System.out.println("  -> translateWord('" + input + "')");

        String result = "";

        // Start here first!
        // This is the first place to work.
        //result = input; // delete this line

        return result;
    }
    
    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)
}
