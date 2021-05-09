package Models;

import Exceptions.FormatException;
import Models.ArbolExpresion;
import Models.EquilibrioCorchetes;

import java.util.regex.Pattern;
public class CalculadoraModelo {
    public ArbolExpresion arbolExpresion;
    public EquilibrioCorchetes equilibrioCorchetes;
    public String expressionString;

    //crear método en Models.EquilibrioCorchetes para comprobar que esté bien
    //la expresion y usarla dentro de esta clase para poder generar
    //excepciones
    public CalculadoraModelo()
    {
        arbolExpresion = new ArbolExpresion();
        equilibrioCorchetes = new EquilibrioCorchetes();
    }

    public CalculadoraModelo(String expressionString)
    {
        this.expressionString = expressionString;
        arbolExpresion = new ArbolExpresion(this.expressionString);
        equilibrioCorchetes = new EquilibrioCorchetes();
    }

    public void setExpressionString(String expressionString) {
        this.expressionString = expressionString;
        arbolExpresion.setExpressionString(expressionString);
        arbolExpresion.crearArbol();
    }
    public void resetArregloNumeros(){
        arbolExpresion.arregloNumeros.clear();
    }
    public String getExpressionString(){
        return expressionString;
    }

    public float calcularOperacion()
    {
        arbolExpresion.posOrden(arbolExpresion.raiz);
        return arbolExpresion.evaluaExp();
    }

    public String enOrden()
    {
        arbolExpresion.enOrdenString="";//reseteando
        arbolExpresion.enOrden(arbolExpresion.raiz);
        return arbolExpresion.enOrdenString;
    }

    public String preOrden()
    {
        arbolExpresion.preOrdenString="";
        arbolExpresion.preOrden(arbolExpresion.raiz);
        return arbolExpresion.preOrdenString;
    }

    public String posOrden()
    {
        arbolExpresion.posOrdenString="";
        arbolExpresion.posOrden(arbolExpresion.raiz);
        return arbolExpresion.posOrdenString;
    }
    public void comprobarFormato(String expressionString)throws FormatException {

        boolean formatNum = Pattern.matches("^[0-9[ (){}./*+^\\-\\[\\] ]]+$", expressionString);//union
        if(!formatNum){
            throw new FormatException();
        }
    }

}
