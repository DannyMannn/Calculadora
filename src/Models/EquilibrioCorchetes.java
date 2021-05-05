package Models;

import Exceptions.CerraduraNoAperturaExc;
import Exceptions.NoCoincidenExc;
import Exceptions.PilaNoVaciaExc;

import java.util.Stack;

public class EquilibrioCorchetes {

    public void isBalanced(String expresion) throws NoCoincidenExc, CerraduraNoAperturaExc, PilaNoVaciaExc {
        Stack<Character> pila = new Stack<Character>();
        for(int i=0; i<expresion.length(); i++) {
            if(isOpeningParenthesisSymbol(expresion.charAt(i))) {
                pila.push(expresion.charAt(i));
            }
            else{
                if(isClosingParenthesisSymbol(expresion.charAt(i))){
                    if(pila.isEmpty()){         //Hay cerradura, pero no apertura
                        throw new CerraduraNoAperturaExc("No introdujo ningun simbolo de apertura");
                    }
                    if(!isPair(pila.peek(),expresion.charAt(i))){           //No coinciden?
                        throw new NoCoincidenExc(pila.peek() + " no coincide con " + expresion.charAt(i));
                    }else {
                        pila.pop();
                    }
                }
            }
        }
        if(!pila.empty()) {
            throw new PilaNoVaciaExc("Falto cerrar " + pila.peek());     //Pila no vacia
        }
    }

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

    public boolean isPair(char c,char x){		//Aqui crear el throw para lanzar la excepcion
        if(c == '{' && x == '}')			//el catch debes de buscarlo en el codigo donde se utiliza
            return true;				    //el isPair
        else if(c == '[' && x == ']')
            return true;
        else if(c == '(' && x == ')')
            return true;
        return false;
    }

    /*public static void main(String[] args) {

    }*/
}