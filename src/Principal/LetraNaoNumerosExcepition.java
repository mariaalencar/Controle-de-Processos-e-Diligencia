
package Principal;

public class LetraNaoNumerosExcepition extends RuntimeException{
   
    public LetraNaoNumerosExcepition(String string) {
        super("erro numero infomado ao invez de letra.!!! \n Por favor digite novamente");
    }
    
}
