import static org.junit.Assert.*;

import org.junit.Test;

public class BarTeste {

	@Test
	
	public void testaPercentualMasculino() 
	{
        Bar oBar = new Bar();
		
		oBar.AdicionaCliente("teste", "123", "M", 22, false, "");
		oBar.AdicionaCliente("teste1", "1232", "F", 22, false, "");
		oBar.AdicionaCliente("teste2", "1234", "M", 22, true, "11");
			
		assertEquals(66.66,oBar.GetPercentualCliente("M"),1);
	}
	
	@Test
	public void testaPercentualFeminino() 
	{
        Bar oBar = new Bar();
		
		oBar.AdicionaCliente("teste", "123", "M", 22, false, "");
		oBar.AdicionaCliente("teste1", "1232", "F", 22, false, "");
		oBar.AdicionaCliente("teste2", "1234", "M", 22, true, "11");
			
		assertEquals(33.33,oBar.GetPercentualCliente("F"),1);
	}
	
	@Test	
	public void testaClienteNoBarCPF() 
	{
        Bar oBar = new Bar();
		
		oBar.AdicionaCliente("teste", "123", "M", 22, false, "");
		oBar.AdicionaCliente("teste1", "1232", "F", 22, false, "");
		oBar.AdicionaCliente("teste2", "1234", "M", 22, true, "11");
			
		assertEquals(true,oBar.ClienteNoBarCPF("123"));
	}
	
	@Test
	public void testeRetornaPercentualSocio()
	{
         Bar oBar = new Bar();
		
		oBar.AdicionaCliente("teste", "123", "M", 22, false, "");
		oBar.AdicionaCliente("teste1", "1232", "F", 22, false, "");
		oBar.AdicionaCliente("teste2", "1234", "M", 22, true, "11");
			
		assertEquals(33.33,oBar.GetPercentualCliente("SOCIO"),1);	
	}
	
	@Test
	public void testaRetornaTotalPessoas()
	{
        Bar oBar = new Bar();
		
		oBar.AdicionaCliente("teste", "123", "M", 22, false, "");
		oBar.AdicionaCliente("teste1", "1232", "F", 22, false, "");
		oBar.AdicionaCliente("teste2", "1234", "M", 22, true, "11");
		oBar.AdicionaCliente("teste3", "12345", "M", 22, true, "01");
		
		assertEquals(4,oBar.RetornaTotalPessoas());
	}
}
