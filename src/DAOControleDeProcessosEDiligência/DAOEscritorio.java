package DAOControleDeProcessosEDiligência;

import DAOConexao.DAOBase;
import Model.bean.Escritorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOEscritorio extends DAOBase {

    public void inserir(Escritorio escritorio) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "insert into escritorio (id_escritorio, nome_advocacia, telefone,  endereco, id_secretaria) values (?,?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setInt(1, escritorio.getId_escritorio());
            ps.setString(2, escritorio.getNome_advocacia());
            ps.setString(3, escritorio.getTelefone());
            ps.setString(4, escritorio.getEndereco());
            ps.setInt(5, (int) escritorio.getId_secretaria());

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

    public void Deletar(int id_escritorio) {
        Connection con = getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {

            String sql = "delete from escritorio where id_escritorio=" + id_escritorio;
            System.out.println(sql);
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

    public void alterar(Escritorio escritorio) {
        Connection con = getConnection();
        Statement st = null;
        PreparedStatement ps = null;
        try {
            String sql = "update escritorio set nome_advocacia = ?,telefone=?,endereco=?, id_secretaria=? where id_escritorio = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1, escritorio.getNome_advocacia());
            ps.setString(2, escritorio.getTelefone());
            ps.setString(3, escritorio.getEndereco());
            ps.setInt(4, (int) escritorio.getId_secretaria());
            ps.setInt(5, escritorio.getId_escritorio());
            
            
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
            String sqlSelect = "select * from escritorio";
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);

            while (rs.next()) {
                int id_escritorio = rs.getInt("id_escritorio");
                String nome_advocacia = rs.getString("nome_advocacia");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("endereco");
                long id_secretaria = rs.getInt("id_secretaria");
                System.out.println(id_escritorio + " - " + nome_advocacia + " - " + telefone + " - " + endereco + " - " + id_secretaria);

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
