import java.util.*;
public class Main {

    public static List<String> decorText(List<String> dictionary, String s) {
        Map<String, List<String>> myMap = new HashMap<>();
        return helper(s,dictionary,myMap);
    }
    public static List<String> helper(String s,List<String> dict, Map<String, List<String>> myMap ) {
        if (s.equals("")) {
            return new ArrayList<>();
        }
        if (myMap.containsKey(s)) {
            return myMap.get(s);
        }
        List<String> kq = new ArrayList<>();
        for (int i = 0; i < dict.size();i++)
        {

            if(s.startsWith(dict.get(i)))
            {
                String subText = s.substring(dict.get(i).length());
                List<String> currentDict = helper(subText,dict,myMap);
                if(currentDict != null)
                {
                    kq.add(dict.get(i));
                    kq.addAll(currentDict);
                    break;
                }
            }

        }
        myMap.put(s,kq.isEmpty() ? null : kq);
        return myMap.get(s);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> dict = new ArrayList<>();
        System.out.print("Input your length of dictionary: ");
        int lengthDic = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < lengthDic; i++) {
            System.out.print("Enter value :" + (i + 1) + ": ");
            String text = scanner.nextLine();
            dict.add(text);
        }
        String s1 = "bedbathandwin";
        System.out.println(decorText(dict,s1));
    }
}