import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.Scanner;
import java.util.List;

public class DZ5 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Введите выражение, состоящее из скобок ()[]{}<>");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(word);
        

            HashMap<String, Integer> openBrackets = new HashMap<String, Integer>() {
                {
                    put("{", 0);
                    put("[", 1);
                    put("(", 2);
                    put("<", 3);
                }
            };
            HashMap<String, Integer> closeBrackets = new HashMap<String, Integer>() {
                {
                    put("}", 0);
                    put("]", 1);
                    put(")", 2);
                    put(">", 3);

                }
            };
            Stack<String> stack = new Stack<>();
            String result = "true";

            List<String> lines = new ArrayList<String>();
            lines.add(word);

            for (String inLine : lines) {
                for (int i = 0; i < inLine.length(); i++) {
                    Character character = inLine.charAt(i);
                    String symbol = character.toString();

                    if (openBrackets.containsKey(symbol)) {
                        stack.push(symbol);
                    } else if (closeBrackets.containsKey(symbol)) {
                        if (stack.empty() || !openBrackets.get(stack.pop()).equals(closeBrackets.get(symbol))) {
                            result = "folse";
                            break;
                        }
                    }
                }
            }
            System.out.println(result);
            sc.close();

        }

    }


