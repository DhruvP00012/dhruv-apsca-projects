package piglatin;

import java.util.Scanner;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();
        
        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.
        
        return translatedBook;

    }

    public static String translateWord(String input) {
    if (input == null || input.isEmpty()) {
        return "";
    }

    String originalInput = input;
    // String punctuation = "";
    // while (input.length() > 0 && !Character.isLetter(input.charAt(input.length() - 1))) {
    //     punctuation = input.charAt(input.length() - 1) + punctuation;
    //     input = input.substring(0, input.length() - 1);
    // }
    

    boolean wasCapitalized = Character.isUpperCase(originalInput.charAt(0));
    // String lowerCaseInput = input.toLowerCase();
    String vowels = "aeiouy" + "AEIOUY";

    int firstVowelIndex = -1;
    for (int i = 0; i < originalInput.length(); i++) {
        char currentChar = originalInput.charAt(i);
        if (vowels.indexOf(currentChar) != -1 || (currentChar == 'y' && i > 0)) {
            firstVowelIndex = i;
            break;
        }
    }

    String translatedWord;
    if (firstVowelIndex == 0) {
        translatedWord = originalInput + "ay";
    } else if (firstVowelIndex != -1) {
        String consonants = originalInput.substring(0, 1).toLowerCase() + originalInput.substring(1, firstVowelIndex);
        String restOfWord = originalInput.substring(firstVowelIndex);
        translatedWord = restOfWord + consonants + "ay";
    } else {
        translatedWord = originalInput + "ay";
    }
    
    if (wasCapitalized) {
        translatedWord = Character.toUpperCase(translatedWord.charAt(0)) + translatedWord.substring(1);
    }

    return translatedWord;
}



    public static String translate(String input) {
        input += " ";
        String result = "";
        int prevIndex = -1;

        // Start here first!
        // This is the first place to work.
        //result = input; // delete this line
       

        for (int i = 0; i < input.length(); i++) {
            if (!(Character.isLetter(input.charAt(i)) || input.substring(i, i+1).equals("-")))
            {
                result += translateWord(input.substring(prevIndex + 1, i)) + input.substring(i, i+1);
                prevIndex = i;
            }
        }

        return result.substring(0, result.length()-1);
    }

}
    
    //Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

