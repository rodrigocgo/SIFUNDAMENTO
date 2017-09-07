package business;
import persistence.Cliente;

public class Bar
{
  private Cliente oCliente;
	private GerenciadorListaCliente oGerenciadorListaCliente; 
	
	public Bar()
	{
	  oGerenciadorListaCliente = new GerenciadorListaCliente();
	}
	public void AdicionaCliente(String sNome,String sCpf,char cGenero,int iIdade,boolean bSocio,String sNumeroSocio)
	{
	  oGerenciadorListaCliente.AdicionaCliente(oCliente,sNome,sCpf,cGenero,iIdade,bSocio,sNumeroSocio);
	}
	
	public boolean ClienteNoBarCPF(String sCpf)
	{
	   return oGerenciadorListaCliente.RetornaPessoaCPF(sCpf);
	}
	
	public int RetornaTotalPessoasCadastradas()
	{
		return oGerenciadorListaCliente.RetornaPessoasTotal(false);
	}
	public int RetornaTotalPessoasNoBar()
	{
	  return oGerenciadorListaCliente.RetornaPessoasTotal(true);
	}
	public double GetPercentualCliente(String sParametro)
	{ 
	   int iRetorno = 0; 
	   double iTamanhoTotal = oGerenciadorListaCliente.RetornaPessoasTotal(true);
	  
	   switch(sParametro)		
	   {
	      case "SOCIO"     : iRetorno = oGerenciadorListaCliente.RetornaQuantidaDefinida(1,' '); break;
	      case "M"         : iRetorno = oGerenciadorListaCliente.RetornaQuantidaDefinida(2,'M'); break;
	      case "F"         : iRetorno = oGerenciadorListaCliente.RetornaQuantidaDefinida(2,'F'); break;
	      default          : break;
	   }
	   return (iRetorno/iTamanhoTotal)*100;
	}
	
	public void RegistraSaidaCliente(String sCpf)
	{
		oGerenciadorListaCliente.RegistraSaidaCliente(sCpf);
	}
}
