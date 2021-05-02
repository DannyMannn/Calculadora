public class EquilibrioCorchetes {

    public boolean isOpeningParenthesisSymbol(char c){
        if(c == '{' || c == '[' || c == '(')
            return true;
        return false;
    }

    public boolean isClosingParenthesisSymbol(char c){
        if(c == '}' || c == ']' || c == ')')
            return true;
        return false;
    }

    public boolean isPair(char c,char x){
        if(c == '{' && x == '}')
            return true;
        else if(c == '[' && x == ']')
            return true;
        else if(c == '(' && x == ')')
            return true;
        return false;
    }

    public static void main(String[] args) {

    }
}