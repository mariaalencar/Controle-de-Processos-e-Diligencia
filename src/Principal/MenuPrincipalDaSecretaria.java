package Principal;

import DAOConexao.Teclado;
import DAOControleDeProcessosEDiligência.DAOSecrataria;
import Model.bean.Secretaria;

/**
 *
 * @author adavilson
 */
public class MenuPrincipalDaSecretaria {

    DAOSecrataria daoSecretaria = new DAOSecrataria();

    public void menu() {

        boolean continua = true;

        do {
            try {
                System.out.println("<<IFMT BANCO DADOS>>");
                System.out.println("<<Cadastro de Professores.>>");
                int opcaoCadastro = Teclado.lerInt("Digite (1)Para Cadastrar  (2) Para Alterar (3)Para Deletar (4)Para consulta (5) Para sair");
                if (opcaoCadastro < 0) {
                    throw new NumerosNegativosExcepition("Erro numero negativo informado");
                }
                switch (opcaoCadastro) {
                    case 1:
                        cadastrar();
                        break;
                    case 2:
                        alterar();
                        break;
                    case 3:
                        Deletar();
                        break;
                    case 4:
                        consultar();
                        break;
                    case 5:
                        System.out.println("<<<Bye Bye >>>");
                        System.exit(0);
                        break;

                }

            } catch (java.util.InputMismatchException erro1) {
//                System.out.println("Não é per\n"
//                        + "                String dtNascimento = Teclado.lerString(\"Digite a data de nascimento:\");\n"
//                        + "\n"
//                        + "                LocalDate data = LocalDatemitido inserir letras, informe apenas números inteiros!");
            } catch (NumerosNegativosExcepition erro2) {
                System.out.println(erro2.getMessage());
            }

        } while (continua);
    }

    public void cadastrar() {
        boolean cadastroSecretaria = true;
        
        do {
            try {
               
                String nome_secretaria = Teclado.lerString("Digite o nome da Secretaria:"); 
                
                boolean sohLetrasEEspacos = nome_secretaria.matches("[a-zA-Z/s]+");

                String cpf = Teclado.lerString("Digite o Cpf");

                String login_secretaria = Teclado.lerString("Digite o Login");

                int senha = Teclado.lerInt("Digite a senha");
                if (senha < 0) {
                    throw new NumerosNegativosExcepition(" ");

                }

                Secretaria secretaria = new Secretaria(nome_secretaria, cpf, login_secretaria, senha);
                daoSecretaria.inserir(secretaria);
                System.out.println("Cadastrado");
                menu();
                cadastroSecretaria = false;
            } catch (java.util.InputMismatchException erro1) {
                System.out.println("Não é permitido inserir letras, informe apenas números inteiros e Positivos!!");
            } catch (NumerosNegativosExcepition | LetraNaoNumerosExcepition erro2) {
                System.out.println(erro2.getMessage());
            } catch (ArithmeticException erro4) {
                System.out.println("O numero informado não pode ser negativo!!!");
                System.out.println("Por favor digite novamente ");
            }
        } while (cadastroSecretaria);

    }

    public void alterar() {

        
        String nome_secretaria = Teclado.lerString("Digite o nome do(a) secretaria:");
        String cpf = Teclado.lerString("Digite o Cpf:");
        String login_secretaria = Teclado.lerString("Digite o Login");
        int senha = Teclado.lerLong("Digite a Senha");

        Secretaria secretaria = new Secretaria(nome_secretaria, cpf, login_secretaria, senha);
        daoSecretaria.alterar(secretaria);
        System.out.println("Alterado");
        menu();
    }

    public void Deletar() {

        int id_secretaria = Teclado.lerInt("Digite a Matricula da Secretaria");
        daoSecretaria.Deletar(id_secretaria);
        System.out.println("Deletado com sucesso");
        menu();
    }

    public void consultar() {

        daoSecretaria.consultar();
        menu();
    }

    public static void main(String[] args) {
        MenuPrincipalDaSecretaria principal = new MenuPrincipalDaSecretaria();
        principal.menu();
    }

}
