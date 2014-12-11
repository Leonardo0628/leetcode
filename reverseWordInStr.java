public class reverseWordInStr {
    public String reverseWords(String s) {
	String[] words = s.trim().split("\\s+");
	String reverse =  words[words.length - 1];
	for (int i = words.length - 2; i >= 0; i--) {
	    reverse = reverse + " " + words[i];
	}
	return reverse;
    }
    public static void main(String[] args) {
	reverseWordInStr solution = new reverseWordInStr();
	System.out.println(solution.reverseWords("  the  sky  is blue   "));
    }
}