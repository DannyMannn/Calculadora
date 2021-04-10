import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Stack;

public class ArbolExpresion {
    Nodo raiz;
    String expressionString;
    String enOrdenString;
    String posOrdenString;
    String preOrdenString;

    ArrayList<String> arreglo;
    Stack<Float> pilaInt;

    public ArbolExpresion(String expressionString)
    {
        enOrdenString = "";
        posOrdenString = "";
        preOrdenString = "";
        this.raiz = null;
        this.expressionString = expressionString;
        arreglo=new ArrayList<String>();
        pilaInt=new Stack<Float>();
    }

    public ArbolExpresion()
    {
        enOrdenString = "";
        posOrdenString = "";
        preOrdenString = "";
        this.raiz = null;
        this.expressionString = "";
        arreglo=new ArrayList<String>();
        pilaInt=new Stack<Float>();
    }

    public void setExpressionString(String expressionString) {
        this.expressionString = expressionString;
    }

    public void crearArbol()
    {
        expressionString = removeClosingParenthesis(expressionString);
        System.out.println(expressionString.length());
        int i = 0;
        Nodo nodoActual;
        Stack<Nodo> pilaNodo = new Stack<>();
        String aux = "" + expressionString.charAt(i);
        Nodo nodo = new Nodo(aux);
        pilaNodo.push(nodo);
        nodoActual = raiz = nodo;
        recorrer(expressionString, pilaNodo, nodoActual, i + 1);
    }

    private void recorrer(String expresionString, Stack<Nodo> pilaNodo, Nodo nodoActual, int i)
    {
        if (i >= expresionString.length())
            return;
        Character token = expressionString.charAt(i);
        String auxString = "";

        if(!isOperador(token))
        {

            //para números con más de un digito: los concata
            if(Character.isDigit(token) || token == '.')
            {
                Character tokenAux;

                while(true)
                {
                    if(i >= expresionString.length())
                        break;
                    tokenAux = expresionString.charAt(i);

                    if(!Character.isDigit(tokenAux) && (tokenAux != '.'))
                    {
                        i--;
                        break;
                    }
                    else
                    {
                        auxString += tokenAux;
                        i++;
                    }
                }
            }
            else
            {
                auxString += token;
            }

            Nodo nodo = new Nodo(auxString);

            if(nodoActual.izquierdo == null)
                nodoActual.izquierdo = nodo;
            else
                nodoActual.derecho = nodo;

            if(isOpeningParenthesis(token))
            {
                nodoActual = nodo;
                pilaNodo.push(nodoActual);
            }
        }
        else if(isOperador(token))
        {
            auxString += token;
            nodoActual = pilaNodo.pop();
            nodoActual.setDato(auxString);
        }

        recorrer(expressionString,pilaNodo,nodoActual,i+1);
    }

    public boolean isOpeningParenthesis(Character c){
        if(c == '{' || c == '[' || c == '(')
            return true;
        return false;
    }

    public boolean isClosingParenthesis(Character c){
        if(c == '}' || c == ']' || c == ')')
            return true;
        return false;
    }

    public boolean isOperador(Character c)
    {
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
            return true;
        return false;
    }

    public void enOrden(Nodo n)
    {
        if (n!=null)
        {
            enOrden(n.izquierdo);
            String aux = "  -->   "+(n.dato);
            System.out.print(aux);
            enOrdenString += aux;
            enOrden(n.derecho);
        }
    }

    public void preOrden(Nodo n)
    {
        if (n!=null)
        {
            String aux = "  -->  "+(n.dato);
            System.out.print(aux);
            preOrdenString += aux;
            preOrden(n.izquierdo);
            preOrden(n.derecho);
        }
    }

    public void posOrden(Nodo n)
    {
        if (n!=null)
        {
            posOrden(n.izquierdo);
            posOrden(n.derecho);
            String aux = "  -->   "+(n.dato);
            System.out.print(aux);
            arreglo.add(n.dato);
        }
    }

    public String removeClosingParenthesis(String expression)
    {
        String aux = "";
        for(int i = 0; i < expression.length(); i++)
        {
            if(!isClosingParenthesis(expression.charAt(i)) && !(expression.charAt(i) == ' '))
                aux += expression.charAt(i);
        }
        return aux;
    }

    public float evaluaExp()
    {
        float aux = 0;
        //System.out.print(arreglo);
        for(int i=0;i<arreglo.size();i++)
        {
            String stringNum = arreglo.get(i);
            if (Character.isDigit(stringNum.charAt(0)))
            {
                pilaInt.push(Float.parseFloat(stringNum));
            }
            else{
                float n1=pilaInt.pop();
                float n2=pilaInt.pop();
                switch(arreglo.get(i))
                {
                    case "*": aux=n1*n2;
                        break;
                    case "-": aux=n2-n1;
                        break;
                    case "+": aux=n1+n2;
                        break;
                    case "/": aux=n2/n1;
                        break;
                }
                pilaInt.push(aux);

            }
        }
        aux = pilaInt.pop();
        System.out.println("\n"+aux);
        return aux;
    }

    public static void main(String args[])
    {
        String expression = "((((8/2)^2)+(10-(3+221)))*20)";
        String expression2 = "(1+(0))";//este formato seria aceptable?
        String expression3 = "{(1+2) - (1 + 5)}";
        String expression4 = "{1+2 - 1 + 5}";//seria aceptable este formato?
        String exp="((4+5)*((8.21/2.021)-2009.22))";
        System.out.println("Original Expression Length: "+expression.length());
        ArbolExpresion arbol = new ArbolExpresion(exp);
        arbol.crearArbol();
        //arbol.posOrden(arbol.raiz);
        System.out.println();
        //arbol.evaluaExp();
        arbol.preOrden(arbol.raiz);
        //System.out.println(20.121);
    }
}