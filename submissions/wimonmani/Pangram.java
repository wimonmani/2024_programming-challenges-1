import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pangram {

    // ฟังก์ชันตรวจสอบว่าเป็น pangram ไหม
    public static boolean isPangram(String str) {
        Set<Character> letters = new HashSet<>();
        str = str.toLowerCase();

        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                letters.add(c);
            }
        }

        return letters.size() == 26;
    }

    // ฟังก์ชันค้นหาคำที่ยาวที่สุด
    public static String findLongestWord(String str) {
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(str);
        String longestWord = "";

        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับค่าจากผู้ใช้
        System.out.print("Enter a words : ");
        String input = scanner.nextLine();

        // ตรวจสอบว่าเป็น pangram ไหม
        if (isPangram(input)) {
            // หาและแสดงคำที่ยาวที่สุดในกรณีที่เป็น pangram
            String longestWord = findLongestWord(input);
            System.out.println("The string is a pangram.");
            System.out.println("The longest word in the string is: " + longestWord);
        } else {
            System.out.println("The string is not a pangram.");
        }

        scanner.close();
    }
}
