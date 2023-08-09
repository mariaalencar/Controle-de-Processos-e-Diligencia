
package Principal;



public class NumerosNegativosExcepition extends RuntimeException{
   
    public NumerosNegativosExcepition(String string) {
        super("erro numero negativo informado!!! \n Por favor digite novamente");
    }
    
}
