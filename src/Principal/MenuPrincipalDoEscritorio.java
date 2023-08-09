package Principal;

import DAOConexao.Teclado;
import DAOControleDeProcessosEDiligência.DAOEscritorio;
import Model.bean.Escritorio;

//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
public class MenuPrincipalDoEscritorio {

    DAOEscritorio daoescritorio = new DAOEscritorio();

    public void menu() {

        boolean continua = true;

        do {
            try {
                System.out.println("<<IFMT BANCO DADOS>>");
                System.out.println("<<Cadastro de Escritorio.>>");
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
                System.out.println("Não é per\n"
                        + "                String dtNascimento = Teclado.lerString(\"Digite a data de nascimento:\");\n"
                        + "\n"
                        + "                LocalDate data = LocalDatemitido inserir letras, informe apenas números inteiros!");
            } catch (NumerosNegativosExcepition erro2) {
                System.out.println(erro2.getMessage());
            }

        } while (continua);
    }

    public void cadastrar() {
        boolean cadastroEscritotio = true;
        int id_escritorio;
        int cpf;
        do {
            try {
                id_escritorio = Teclado.lerInt("Digite o numero do Escritorio:");
                if (id_escritorio < 0) {
                    throw new NumerosNegativosExcepition(" ");
                }

                String nome_advocacia = Teclado.lerString("Digite o nome do Escritorio:");
                boolean sohLetrasEEspacos = nome_advocacia.matches("[a-zA-Z/s]+");

                if (sohLetrasEEspacos == false) {
                    throw new LetraNaoNumerosExcepition(" ");
                }

                String telefone = Teclado.lerString("Digite o Telefone");

                String endereco = Teclado.lerString("Digite o Endereco");

                long id_secretaria;

                id_secretaria = Teclado.lerInt("informe o numero da secretaria:");
                if (id_secretaria < 0) {
                    throw new NumerosNegativosExcepition(" ");

                }

                Escritorio escritorio = new Escritorio(id_escritorio, nome_advocacia, telefone, endereco, id_secretaria);
                daoescritorio.inserir(escritorio);
                System.out.println("Cadastrado");
                menu();
                cadastroEscritotio = false;
            } catch (java.util.InputMismatchException erro1) {
                System.out.println("Não é permitido inserir letras, informe apenas números inteiros e Positivos!!");
            } catch (NumerosNegativosExcepition | LetraNaoNumerosExcepition erro2) {
                System.out.println(erro2.getMessage());
            } catch (ArithmeticException erro4) {
                System.out.println("O numero informado não pode ser negativo!!!");
                System.out.println("Por favor digite novamente ");
            }
        } while (cadastroEscritotio);

    }

    public void alterar() {

        int id_escritorio = Teclado.lerInt("Digite o numero do Escritorio a ser alterado:");
        String nome_advocacia = Teclado.lerString("Digite o nome do Escritorio:");
        String telefone = Teclado.lerString("Digite o Telefone:");
        String endereco = Teclado.lerString("Digite o Endereco");
        long id_secretaria = Teclado.lerLong("Digite o Matricula da Secretaria");

         Escritorio escritorio = new Escritorio(id_escritorio, nome_advocacia, telefone, endereco, id_secretaria);
                daoescritorio.alterar(escritorio);
        System.out.println("Alterado");
        menu();
    }

    public void Deletar() {

        int id_escritorio = Teclado.lerInt("Digite o cpf");
        daoescritorio.Deletar(id_escritorio);
        System.out.println("Deletado com sucesso");
        menu();
    }

    public void consultar() {
        
        daoescritorio.consultar();
        menu();
    }
    public static void main(String[] args) {
        MenuPrincipalDoEscritorio principal = new MenuPrincipalDoEscritorio();
        principal.menu();
    }
}
