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
	public boolean RetornaPessoaCadastrada(String sCpf)
	{
	  return oGerenciadorListaCliente.RetornaPessoaCadastrada(sCpf);
	}
	public int RetornaTotalPessoasCadastradas()
	{
		return oGerenciadorListaCliente.RetornaPessoasTotal(false);
	}
	public int RetornaTotalPessoasNoBar()
	{
	  return oGerenciadorListaCliente.RetornaPessoasTotal(true);
	}
	public double retornaPercentualClienteNoBar(String sParametro)
	{ 
	   int iRetorno = 0; 
	   double iTamanhoTotal = oGerenciadorListaCliente.RetornaPessoasTotal(true);
	  
	   switch(sParametro)		
	   {
	      case "SOCIO"     : iRetorno = oGerenciadorListaCliente.RetornaQuantidaDefinidaNoBar(1,' '); break;
	      case "M"         : iRetorno = oGerenciadorListaCliente.RetornaQuantidaDefinidaNoBar(2,'M'); break;
	      case "F"         : iRetorno = oGerenciadorListaCliente.RetornaQuantidaDefinidaNoBar(2,'F'); break;
	      default          : break;
	   }
	   return (iRetorno/iTamanhoTotal)*100;
	}

	 public double retornaPercentualClienteTotal(String sParametro)
	  { 
	     int iRetorno = 0; 
	     double iTamanhoTotal = oGerenciadorListaCliente.RetornaPessoasTotal(false);
	    
	     switch(sParametro)   
	     {
	        case "SOCIO"     : iRetorno = oGerenciadorListaCliente.RetornaQuantidaDefinidaTotal(1,' '); break;
	        case "M"         : iRetorno = oGerenciadorListaCliente.RetornaQuantidaDefinidaTotal(2,'M'); break;
	        case "F"         : iRetorno = oGerenciadorListaCliente.RetornaQuantidaDefinidaTotal(2,'F'); break;
	        default          : break;
	     }
	     return (iRetorno/iTamanhoTotal)*100;
	  }
	 
	public void RegistraSaidaEntradaCliente(String sCpf, boolean bSaiu)
	{
		oGerenciadorListaCliente.RegistraSaidaEntradaCliente(sCpf, bSaiu);
	}
	
	public String GeraRelatorio()
	{
	   return oGerenciadorListaCliente.GeraRelatorio();
	}
	
	public String GeraRelatorioPresenteNoBar()
	{
	  return oGerenciadorListaCliente.GeraRelatorioPresenteNoBar();
	}
}
