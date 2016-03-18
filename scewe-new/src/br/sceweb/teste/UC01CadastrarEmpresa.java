package br.sceweb.teste;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa {

	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		
		empresa.setNomeDaEmpresa("empresa X");
		empresa.setCnpj("19735273947263");
		empresa.setNomeFantasia("empresa X");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("77661274");
	}

	
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		assertEquals(1, empresaDAO.adiciona(empresa));
	}
	
	@Test
	public void CT01UC02FBExcluir_com_sucesso() {
		assertEquals(1, empresaDAO.exclui(empresa));
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
