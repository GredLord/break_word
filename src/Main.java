import java.util.*;
import java.util.stream.Collectors;
public class Main {

    public static List<String> decorText(List<String> dictionary, String s) {
        Map<String, List<String>> myMap = new HashMap<>();
        return helper(dictionary,s,myMap);
    }
    public static List<String> helper(List<String> dictionary, String s, Map<String, List<String>>  myMap) {
        if (s.equals("")) {
            return new ArrayList<>();
        }
        if (myMap.containsKey(s)) {
            return myMap.get(s);
        }
        List<String> kq = new ArrayList<>();
        for (String word : dictionary) {
            if (s.startsWith(word)) {
                String cuttedText = s.substring(word.length());
                List<String> currentDictionary = helper(dictionary, cuttedText, myMap);

                if (currentDictionary != null) {
                    kq.add(word);
                    kq.addAll(currentDictionary);
                    break;
                }
            }
        }

        myMap.put(s, kq.isEmpty() ? null : kq);
        return myMap.get(s);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> dictionary1 = new ArrayList<>();
        System.out.print("Input your length of dictionary: ");
        int lengthDic = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < lengthDic; i++) {
            System.out.print("Enter value :" + (i + 1) + ": ");
            String text = scanner.nextLine();
            dictionary1.add(text);
        }
        String s1 = "thequickbrownfox";
        System.out.println(decorText(dictionary1,s1));
    }
}