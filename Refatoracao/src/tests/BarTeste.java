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
		
		 oBar.AdicionaCliente("Joao", "384.490.360-70", 'M', 22, false, "");
		 oBar.AdicionaCliente("Mario", "477.119.570-68", 'M', 22, true, "11");
		 oBar.AdicionaCliente("Maria", "934.828.380-46", 'F', 22, false, "");
	  
	    
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
	
	@Test
	public void TestaQuantidaHomemAposSaida()
	{   
       //Total 7 Pessoas 5H e 2M dando um percentual 71,42% de H e 28,57% de M 
       oBar.AdicionaCliente("Fulano", "384.490.360-71", 'M', 22, false, "");
       oBar.AdicionaCliente("Fulano", "384.490.360-80", 'M', 22, false, "");
       oBar.AdicionaCliente("Nome", "477.119.570-62", 'M', 22,   false, "");
       oBar.AdicionaCliente("Teste", "934.828.380-43", 'F', 22,  false, "");
     
       /*Testes para evidenciar o percentual antes do teste principal*/
       
       //Teste de Percentual de H
       assertEquals(71.41,oBar.retornaPercentualClienteNoBar("M"),1);
    
       //Teste de Percentual de M
       assertEquals(28.57,oBar.retornaPercentualClienteNoBar("F"),1);
    
       //Teste de percentualde socios
       assertEquals(14.28,oBar.retornaPercentualClienteNoBar("SOCIO"),1);
     
       //Saida de um cliente
       oBar.RegistraSaidaEntradaCliente("477.119.570-62", true);
       
       //Novamente testaremos o percentual de clientes no bar após a saida de um H
       assertEquals(66.66,oBar.retornaPercentualClienteNoBar("M"),1);
       
	}
	
	
}
