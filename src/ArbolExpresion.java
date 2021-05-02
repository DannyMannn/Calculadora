import java.util.ArrayList;
import java.util.Stack;
//import java.util.Math*;
public class ArbolExpresion {
    Nodo raiz;
    String expressionString;
    String enOrdenString;
    String posOrdenString;
    String preOrdenString;

    ArrayList<String> arregloNumeros;
    Stack<Float> pilaNumeros;

    public ArbolExpresion(String expressionString){
        enOrdenString = "";
        posOrdenString = "";
        preOrdenString = "";
        this.raiz = null;
        this.expressionString = expressionString;
        arregloNumeros =new ArrayList<String>();
        pilaNumeros =new Stack<Float>();
    }

    public ArbolExpresion(){
        enOrdenString = "";
        posOrdenString = "";
        preOrdenString = "";
        this.raiz = null;
        this.expressionString = "";
        arregloNumeros =new ArrayList<String>();
        pilaNumeros =new Stack<Float>();
    }

    public void setExpressionString(String expressionString) {
        this.expressionString = expressionString;
    }

    public void crearArbol(){
        //quita parentesis de cerradura para que sea mas facil trabajar la expresion
        expressionString = removeClosingParenthesis(expressionString);
        //System.out.println(expressionString.length());
        int i = 0;
        Nodo nodoActual;
        Stack<Nodo> pilaNodo = new Stack<>();
        //lo siguiente establece la raiz del arbol
        String aux = "" + expressionString.charAt(i);
        Nodo nodo = new Nodo(aux);
        pilaNodo.push(nodo);
        nodoActual = raiz = nodo;
        recorrer(expressionString, pilaNodo, nodoActual, i + 1);
    }

    private void recorrer(String expresionString, Stack<Nodo> pilaNodo, Nodo nodoActual, int i){
        //Condicion de paro donde el índice es mayor a la longitud de la expresión
        if (i >= expresionString.length())
            return;
        //Caracter que sera analizado como el token a trabajar
        Character token = expressionString.charAt(i);
        //String que almacena el número p/e -7.01
        String auxString = "";

        //Esta condicion es para todos los caracteres que son números y sus componenetes (. , -)
        //y también para los paréntesis de apertura
        if(!isOperador(token)){

            //Una implementacion que intenta incluir los parentesis unarios
            if(Character.isDigit(token))
                auxString += menosUnario(expresionString.charAt(i-1),i-1,expressionString);

            //para números con más de un digito: los concata
            if(Character.isDigit(token) || token == '.'){
                //caracter auxiliar para concatenar el numero completo
                //como -6.021
                Character tokenAux;

                //ciclo que concata el "." y los digitos que le siguen
                while(true){
                    //por si la expresion llega a mas de la longitud de
                    //la expresion y para que no cause un null error
                    //en la asignacion de tokenAux
                    if(i >= expresionString.length())
                        break;
                    tokenAux = expresionString.charAt(i);

                    //significa que el caracter actual analizado no es un punto decimal
                    //y tampoco es un digito por lo que se debe regresar al indice anterior
                    //para que no se pierda el token en esta posicion
                    //es decir, ya termino de concatener los componentes del numero
                    if(!Character.isDigit(tokenAux) && (tokenAux != '.')){
                        i--;
                        break;
                    }
                    //Aqui concata el "." o un digito y se incrementa el indice para ya no
                    //tener que analizar este token en las siguientes iteraciones
                    else{
                        auxString += tokenAux;
                        i++;
                    }
                }
            }
            //caso de parentesis de apertura
            else{
                auxString += token;
            }

            //Lo que se debe hacer cuando es número
            //o un paréntesis de apertura
            Nodo nodo = new Nodo(auxString);

            if(nodoActual.izquierdo == null)
                nodoActual.izquierdo = nodo;
            else
                nodoActual.derecho = nodo;

            if(isOpeningParenthesis(token)){
                nodoActual = nodo;
                pilaNodo.push(nodoActual);
            }
        }
        //Lo que se debe hacer cuando el caracter es un operador(* / + - ^)
        //Lo que está comentado es para que el programa
        //no se confunda con un menos unario
        else if(isOperador(token) && !isOpeningParenthesis(expresionString.charAt(i-1)) &&
                !isOperador(expresionString.charAt(i-1))){
            //System.out.println(i + " " + token);
            auxString += token;//aqui concata el operador a ""
            nodoActual = pilaNodo.pop();
            //System.out.println(i + " " + auxString);
            nodoActual.setDato(auxString);//reemplaza el parentesis con el operador
        }

        recorrer(expressionString,pilaNodo,nodoActual,i+1);
    }

    private String menosUnario(Character token, int index, String expressionString){
        /*
        *Aqui se supone que solo es menor unario cuando cumple alguna de las siguientes condiciones:
        * 1. Hay un signo menos que esta antes de parentesis de apertura o
        * 2. Hay un signo menos que esta antes de un operador
        * */
        String menosUnario = "";
        if(token == '-'){
            Character auxToken = expressionString.charAt(index-1);
            //System.out.println(auxToken);
            if (isOperador(auxToken) || isOpeningParenthesis(auxToken)){
                menosUnario = "-";
            }
        }
        return menosUnario;
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

    public boolean isOperador(Character c){
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
            return true;
        return false;
    }

    public void enOrden(Nodo n){
        if (n!=null){
            enOrden(n.izquierdo);
            String aux = "  -->   "+(n.dato);
            System.out.print(aux);
            enOrdenString += aux;
            enOrden(n.derecho);
        }
    }

    public void preOrden(Nodo n){
        if (n!=null){
            String aux = "  -->  "+(n.dato);
            System.out.print(aux);
            preOrdenString += aux;
            preOrden(n.izquierdo);
            preOrden(n.derecho);
        }
    }

    public void posOrden(Nodo n){
        if (n!=null){
            posOrden(n.izquierdo);
            posOrden(n.derecho);
            String aux = "  -->   "+(n.dato);
            System.out.print(aux);
            arregloNumeros.add(n.dato);
        }
    }

    public String removeClosingParenthesis(String expression){
        String aux = "";
        for(int i = 0; i < expression.length(); i++){
            if(!isClosingParenthesis(expression.charAt(i)) && !(expression.charAt(i) == ' '))
                aux += expression.charAt(i);
        }
        return aux;
    }

    public float evaluaExp(){
        float aux = 0;
        System.out.print("\nEl arregloNumeros: " + arregloNumeros);
        for(int i = 0; i< arregloNumeros.size(); i++){
            String stringNum = arregloNumeros.get(i);
            //Condicion para numeros
            //la primera posicion del numbero siempre debe ser un digito
            //o bien, debe ser un (-) seguido por dígitos, por lo que
            //el string (p/e -4.2) siempre debe ser mayor a 1.
            if((stringNum.charAt(0) == '-' && stringNum.length() > 1)
                    || Character.isDigit(stringNum.charAt(0))){
                pilaNumeros.push(Float.parseFloat(stringNum));
            }
            else{
                float n1= pilaNumeros.pop();
                float n2= pilaNumeros.pop();
                switch(arregloNumeros.get(i))
                {
                    case "*": aux=n1*n2;
                        break;
                    case "-": aux=n2-n1;
                        break;
                    case "+": aux=n1+n2;
                        break;
                    case "/": aux=n2/n1;
                        break;
                    case "^": aux = (float)(Math.pow(n2,n1));
                        break;
                }
                pilaNumeros.push(aux);
                //( ((4-1)*(-1.321+4.32)) /2.22 )
            }
        }
        aux = pilaNumeros.pop();
        System.out.println("\n"+aux);
        return aux;
    }

}