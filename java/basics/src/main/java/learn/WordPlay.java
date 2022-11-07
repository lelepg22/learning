package learn;

public class WordPlay {

    //class method

    /**
     * verify if a word is palindrome
     * @param word
     * @return if a word is palindrome returns true
     */

    public static boolean isPalindromeWord(String word){
        if(word.length() < 2){
            return false;
        }

        String palindromeTest = "";

       for(int i = word.length() - 1; i >= 0; i = i - 1){
           palindromeTest += word.charAt(i);

       }
        System.out.println();
        if(word.equals(palindromeTest)){
            System.out.println(word + " the length is "+ word.length() + " is the same as "
                    + palindromeTest + " the length is "+  palindromeTest.length());
            return true;
        }
        else{
            System.out.println(word + " the length is " + word.length()  +  " is different then " + palindromeTest + " the length is "+  palindromeTest.length());
            return false;
        }

    }

    /**
     *
     * @param word1
     * @param word2
     * @return if a phrase is palindrome returns true
     */
    public static boolean isAnagram(String word1, String word2){

        if(word1.length() < 2 || word2.length() < 2){
            return false;
        }

        if(word1.length() == word2.length()) {

            for (int i = 0; i < word1.length(); i++) {

                if(word2.indexOf(word1.charAt(i)) < 0) {
                    return false;
                }

                else{

                    // new StringBuilder(word2) allows .deleteCharAt
                    // word2.indexOf(word.charAt(i)) gives the index of the Char at word1 that is the params of .deleteCharAt on word2
                    // .toString() convert it back to String for the word2 variable type.

                   word2 = new StringBuilder(word2).deleteCharAt(word2.indexOf(word1.charAt(i))).toString();
                    System.out.println(word2);

                }

            }
            return true;
        }
        else{
            return false;
        }

    }
}
