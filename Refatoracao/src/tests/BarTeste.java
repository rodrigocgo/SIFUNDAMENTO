package tests;
import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

import business.Bar;


public class BarTeste {
	Bar oBar;
	
	@Before 
	public void inicializaVariaveis()
	{
		 oBar = new Bar();
		
		 oBar.AdicionaCliente("Fulano", "384.490.360-70", 'M', 22, false, "");
	   oBar.AdicionaCliente("Teste", "934.828.380-46", 'F', 22, false, "");
	   oBar.AdicionaCliente("Nome", "477.119.570-68", 'M', 22, true, "11");
	    
	}
	@Test
	public void testaPercentualMasculinoNoBar() 
	{				
		assertEquals(66.66,oBar.retornaPercentualClienteNoBar("M"),1);
	}
	
	@Test
	public void testaPercentualFeminino() 
	{
		assertEquals(33.33,oBar.retornaPercentualClienteNoBar("F"),1);
	}
	
	@Test	
	public void testaClienteNoBarCPF() 
	{		
		assertEquals(true,oBar.ClienteNoBarCPF("477.119.570-68"));
	}
	
	@Test
	public void testeRetornaPercentualSocio()
	{		
		assertEquals(33.33,oBar.retornaPercentualClienteNoBar("SOCIO"),1);	
	}
	
	@Test
	public void testaRetornaTotalPessoasCadastradas()
	{	
		assertEquals(3,oBar.RetornaTotalPessoasCadastradas());
	}
	
	@Test
  public void testaRetornaTotalPessoasNoBar()
  { 
    assertEquals(3,oBar.RetornaTotalPessoasNoBar());
  }
	
	@Test(expected = IllegalArgumentException.class)
	public void testaExcecaoCPF()
	{
		oBar.AdicionaCliente("Fulano", "477.119.570-68", 'M', 22, false, "");
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
	
	@Test 
	public void testaSaidaCliente()
	{
		assertEquals(3,oBar.RetornaTotalPessoasNoBar());
		oBar.RegistraSaidaEntradaCliente("477.119.570-68",true);
		assertEquals(2,oBar.RetornaTotalPessoasNoBar());
	}
}
