package projetoGradle;

import bancolib.SqlUtil;
import java.sql.ResultSet;
import java.sql.Statement;


public class App {

    public static void main(String[] args) {
        try {
        SqlUtil sqlUtil
                = new SqlUtil("localhost", "5432", "Lista 2",
                "postgres", "12345");
        
        Statement stm = sqlUtil.getConn().createStatement();
        StringBuilder comando = new StringBuilder();
        
        comando.append("SELECT * from produtos"); 
        
        //stm.execute(sql) //Alterações no banco de dados
        //stm.executeQuery(sql) //Retorno de Dados do banco
                
        ResultSet resultSet = stm.executeQuery(comando.toString()); //Trás basicamente um array de 24 posições, aonde cada posição é uma linha
        
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
        comandoInsert.append(")");
                 
            
        } catch (Exception ex) {
            System.out.println("Algo de errado não está certo");
        }
    }
}
