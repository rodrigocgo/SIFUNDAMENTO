import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

public class BarTeste {
	Bar oBar;
	
	@Before 
	public void inicializaVariaveis()
	{
		 oBar = new Bar();
		
		 oBar.AdicionaCliente("Fulano", "123", 'M', 22, false, "");
	     oBar.AdicionaCliente("Teste", "1232", 'F', 22, false, "");
	     oBar.AdicionaCliente("Nome", "1234", 'M', 22, true, "11");	     
	}
	@Test
	public void testaPercentualMasculino() 
	{				
		assertEquals(66.66,oBar.GetPercentualCliente("M"),1);
	}
	
	@Test
	public void testaPercentualFeminino() 
	{
		assertEquals(33.33,oBar.GetPercentualCliente("F"),1);
	}
	
	@Test	
	public void testaClienteNoBarCPF() 
	{		
		assertEquals(true,oBar.ClienteNoBarCPF("123"));
	}
	
	@Test
	public void testeRetornaPercentualSocio()
	{		
		assertEquals(33.33,oBar.GetPercentualCliente("SOCIO"),1);	
	}
	
	@Test
	public void testaRetornaTotalPessoas()
	{	
		assertEquals(3,oBar.RetornaTotalPessoas());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testaExcecaoCPF()
	{
		oBar.AdicionaCliente("Fulano", "123", 'M', 22, false, "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testaExcecaNumeroSocio()
	{
		oBar.AdicionaCliente("Fulano", "1234", 'M', 22, true, "11");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testaExcecaObrigatoriedadeNumeroSocio()
	{
		oBar.AdicionaCliente("Fulano", "1234", 'M', 22, true, "");
	}
}
