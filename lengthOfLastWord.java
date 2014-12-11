public class lengthOfLastWord {
    public int lengthOfLastWord(String s) {
	String[] word = s.split("\\s+");
	if (word.length == 0) {
	    return 0;
	} else {
	    return word[word.length - 1].length();
	}
    }
    public static void main(String[] args) {
	lengthOfLastWord solution = new lengthOfLastWord();
	System.out.println(solution.lengthOfLastWord("Hello World"));
	System.out.println(solution.lengthOfLastWord(" "));
    }
}