package projetoGradle;

import bancolib.SqlUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {
        SelectBanco();
    }
    
    private static void InsertBanco() {
        
    }

    private static void SelectBanco() {
        
        
        try {
            SqlUtil sqlUtil
                    = new SqlUtil("localhost", "5432", "Teste",
                            "postgres", "12345");

            Statement stm = sqlUtil.getConn().createStatement();
            StringBuilder comando = new StringBuilder();

            comando.append("\nSELECT * from produtos");
            ResultSet resultSet = stm.executeQuery(comando.toString());

            while (resultSet.next()) {
                int id_nf = resultSet.getInt("id_nf");
                int id_item = resultSet.getInt("id_item");
                int cod_prod = resultSet.getInt("cod_prod");
                double valor_unit = resultSet.getDouble("valor_unit");
                double quantidade = resultSet.getDouble("quantidade");
                double desconto = resultSet.getDouble("desconto");

                comando.append("\nTabela Produtos: ").append("\nid_nf: ").append(id_nf).append("\nid_item: ").append(id_item).append("\ncod_prod: ").append(cod_prod).append("\nvalor_unit: ")
                        .append(valor_unit)
                        .append("\nquantidade: ").append(quantidade).append("\ndesconto: ").append(desconto);

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
