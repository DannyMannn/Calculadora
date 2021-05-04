public class FormatException extends Exception{
    public FormatException(){
        super("No puede incluir algun simbolo ajeno a la calculadora");
    }
    public FormatException(String msj){
        super(msj);
    }
}
