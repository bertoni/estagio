package br.sceweb.modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;

import br.sceweb.servico.FabricaDeConexoes;

public class EmpresaDAO {

	Logger logger = Logger.getLogger(EmpresaDAO.class);
	
	public int adiciona(Empresa empresa)
	{
		PreparedStatement ps;
		int codigoRetorno = 0;
		
		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps = conn.prepareStatement(
				"INSERT INTO empresa (cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone) values (?,?,?,?,?)");
			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getNomeDaEmpresa());
			ps.setString(3, empresa.getNomeFantasia());
			ps.setString(4, empresa.getEndereco());
			ps.setString(5, empresa.getTelefone());
			codigoRetorno = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		logger.info("chamou o m�todo adiciona");
		return codigoRetorno;
	}

	public int exclui(Empresa empresa)
	{
		PreparedStatement ps;
		int codigoRetorno = 0;
		
		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps = conn.prepareStatement("DELETE FROM empresa WHERE cnpj = ?");
			ps.setString(1, empresa.getCnpj());
			codigoRetorno = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		logger.info("chamou o m�todo remove");
		return codigoRetorno;
	}
	
}
