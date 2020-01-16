import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	    String brackets1 = "[()()]";
        String brackets2 = "[(]()]";
        String brackets3 = "[{()}]";
        String brackets4 = "][";
        String brackets5 = "()[]{}()[]{}";

	    System.out.printf("%-12s : %2d\n", brackets1, solution(brackets1));
        System.out.printf("%-12s : %2d\n", brackets2, solution(brackets2));
        System.out.printf("%-12s : %2d\n", brackets3, solution(brackets3));
        System.out.printf("%-12s : %2d\n", brackets4, solution(brackets4));
        System.out.printf("%-12s : %2d\n", brackets5, solution(brackets5));
    }

    public static int solution(String brackets){
        int result = 0;

        Stack<Character> stack = new Stack<>();
        for(char character : brackets.toCharArray()){

            if(isLeftBracket(character))
                stack.push(character);
            else{
                if(stack.isEmpty())
                    return result;

                if(!isEquivalentBrackets(stack.pop(), character))
                    return result;
            }
        }

        if(stack.isEmpty())
            result = 1;

        return result;
    }

    public static boolean isLeftBracket(Character character){
        if(character.equals('{') || character.equals('[') ||character.equals('('))
            return true;
        else
            return false;
    }

    public static boolean isEquivalentBrackets(Character peekCharacter, Character newCharacter){
        if(peekCharacter.equals('{') && newCharacter.equals('}'))
            return true;

        if(peekCharacter.equals('[') && newCharacter.equals(']'))
            return true;

        if(peekCharacter.equals('(') && newCharacter.equals(')'))
            return true;

        return false;
    }
}
