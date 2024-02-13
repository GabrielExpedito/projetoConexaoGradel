package projetoGradle;

import bancolib.SqlUtil;

import javax.swing.*;
import java.nio.charset.Charset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class App {

        public static final int CADASTRAR_CLIENTE = 1;
        public static final int VERIFICAR_CLIENTES = 2;
        public static final int SAIR = 0;

    public static void main(String[] args) {
        Scanner tecladoPrincipal = new Scanner(System.in);
        int escolha = 0;

        do {
            System.out.println("---------- MENU ESTACIONAMENTO ---------");
            System.out.println("1-) Cadastrar Novo Cliente");
            System.out.println("2-) Verificar clientes cadastrados");
            System.out.println("0-) Sair do Menu");
            escolha = tecladoPrincipal.nextInt();

            switch (escolha) {
                case 1:
                    InsertBanco();
                    break;
                case 2:
                    SelectBanco();
                    break;
                case 0:
                    break;
            }
        } while (escolha != 0);
        System.out.println("Finalizando o programa");
    }

    public static void InsertBanco() {
        try {
            SqlUtil sqlUtil
                    = new SqlUtil("localhost", "5432", "Teste",
                            "postgres", "12345");
        Cliente cli = new Cliente();
        String opcao = "";

        Scanner tecladoPrincipal = new Scanner(System.in);

        System.out.println("Insira dos dados do cliente que deseja cadastrar: ");
        System.out.println("CPF: ");
        cli.setCpf(tecladoPrincipal.nextLine());
        System.out.println("Nome: ");
        cli.setNome(tecladoPrincipal.nextLine());
        System.out.println("Data de Nascimento: ");
        cli.setDtNasc(tecladoPrincipal.nextLine());

        System.out.println("Confirme os dados que quer cadastrar: ");
        System.out.println("CPF: " + cli.getCpf());
        System.out.println("Nome: " + cli.getNome());
        System.out.println("Data de Nascimento: " + cli.getDtNasc());
        System.out.println("Digite Y para sim e N para não: ");
        opcao = tecladoPrincipal.nextLine();

        if (opcao.equals("Y")) {
            System.out.println("Os dados serão inseridos no banco");


            String comandoInsert = "insert into cliente (cpf, nome, dtNasc) values (?, ?, ?)";
            PreparedStatement pst = sqlUtil.getConn().prepareStatement(comandoInsert);
            pst.setString(1, cli.getCpf());
            pst.setString(2, cli.getNome());
            pst.setString(3, cli.getDtNasc());
            pst.executeUpdate();
            System.out.println("Dados inseridos com sucesso");

        } else {
            System.out.println("Não será inserido os dados desse cliente no banco");
        }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    private static void SelectBanco() {

        try {
            SqlUtil sqlUtil
                    = new SqlUtil("localhost", "5432", "Teste",
                            "postgres", "12345");

            Statement stm = sqlUtil.getConn().createStatement();
            StringBuilder comando = new StringBuilder();

            comando.append("\nSELECT * from cliente");
            ResultSet resultSet = stm.executeQuery(comando.toString());

            while (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String dtNasc = resultSet.getString("dtNasc");

                comando.append("\nTabela Cliente: ").append("\nCPF: ").append(cpf).append("\nNome: ").append(nome).append("\nData Nasc: ").append(dtNasc);

                System.out.println(comando.toString());

            }

        } catch (Exception ex) {
            System.out.println("Algo de errado não está certo");
        }
    }
}

//stm.execute(sql) //Alterações no banco de dados
//stm.executeQuery(sql) //Retorno de Dados do banco

/*ResultSet resultSet = stm.executeQuery(comando.toString()); //Trás basicamente um array de 24 posições, aonde cada posição é uma linha
        
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("cod_prod"));
        }
        
        Produtos prod = new Produtos();
        prod.setCod_prod(1);
        
        //como inserir 
        StringBuilder comandoInsert = new StringBuilder();
        comandoInsert.append("INSERT INTO produto (id_nf, id_item, cod_prod),");
        comandoInsert.append("valor_unit, quantidade, desconto) values (");
        comandoInsert.append(prod.getId_nf()).append(",");
        comandoInsert.append(prod.getId_item()).append(",");
        
        //stm.execute(sql)
                
        //TO DO: Criar um menu de opções pra selecionar qual a ação necessária (Cadastrar carro, 
                //TO DO: Fazer no java só o exc do veículo, cadastrar um modelo, cadastrar um pátio ou estacionar um veículo
                //Dependendo da opção do sistema deverá solicitar os dados para serem salvos no banco de dados.
                //Realizar apenas os cadastros não fazer a parte do estacionamento.
                //Ex: Cadastro de clientes Solicitar os dados da tabel (CPF, nome e data nascimento), ao terminar
                // terminar de solicitar os dados, confirmar os dados para o usuário. Se correto os dados deverão ser salvos no banco de dados.
        comandoInsert.append(")");*/
