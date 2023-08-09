package DAOControleDeProcessosEDiligência;

import DAOConexao.DAOBase;
import Model.bean.Secretaria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author adavilson
 */
public class DAOSecrataria extends DAOBase {

    public boolean checkLogin(String text, String senha) {
        Statement st = null;
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean check = false;
        System.out.println(text);
        System.out.println(senha);
          
        try {
            String sql = "    Select secretaria.login_secretaria,secretaria.senha From secretaria where login_secretaria= ? and senha= ? " ;
            
            ps = con.prepareStatement(sql);
            ps.setString(1, text);
            ps.setInt(2, Integer.parseInt(senha));
            
            rs = ps.executeQuery();
//            System.out.println(sql);

            if (rs.next()) {
                check = true;
            } else {
                System.out.println("Usuario e senha invalido");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return check;
    }
//
//    public boolean checkLogin(String login, int senha) {
//        Statement st = null;
//        Connection con = getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        boolean check = false;
//        System.out.println(senha);
//         System.out.println(login);
//         
//         
//        try {
//            String sql = "    Select count (secretaria.id_secretaria) From secretaria where login_secretaria="+ login +"  and senha="+ senha ;
//            ps = con.prepareStatement(sql);
//            ps.setString(1, login);
//            ps.setInt(2, senha);
//            rs = ps.executeQuery(sql);
//            System.out.println(sql);
//            
//            if (rs.next()) {
//                check = true;
//            } else {
//                System.out.println("Usuario e senha invalido");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                ps.close();
//                con.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//
//        }
//        return check;
//    }

    public void inserir(Secretaria secretaria) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "insert into secretaria (nome_secretaria, cpf,  login_secretaria, senha) values (?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setString(1, secretaria.getNome_secretaria());
            ps.setString(2, secretaria.getCpf());
            ps.setString(3, secretaria.getLogin_secretaria());
            ps.setInt(4, secretaria.getSenha());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void Deletar(int id_secretaria) {
        Connection con = getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {

            String sql = "delete from secretaria where id_secretaria=" + id_secretaria;
            st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void alterar(Secretaria secretaria) {
        Connection con = getConnection();
        Statement st = null;
        PreparedStatement ps = null;
        try {

            String sql = "update secretaria set nome_secretaria = ?,login_secretaria=?, senha=? where cpf = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1, secretaria.getNome_secretaria());
            ps.setString(2, secretaria.getLogin_secretaria());
            ps.setInt(3, secretaria.getSenha());
            ps.setString(4, secretaria.getCpf());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void consultar() {
        Connection con = getConnection();
        Statement st = null;
        ResultSet rs = null;

        try {
            String sqlSelect = "select * from secretaria";
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);

            while (rs.next()) {
                int id_secretaria = rs.getInt("id_secretaria");
                String nome_secretaria = rs.getString("nome_secretaria");
                String cpf = rs.getString("cpf");
                String login_secretaria = rs.getString("login_secretaria");
                int senha = rs.getInt("senha");
                System.out.println(id_secretaria + " - " + nome_secretaria + " - " + cpf + " - " + login_secretaria + " - " + senha);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

}
