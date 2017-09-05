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
	
	public int RetornaTotalPessoas()
	{
		return oGerenciadorListaCliente.RetornaTotalPessoas();
	}
	
	public double GetPercentualCliente(String sParametro)
	{ 
	   int iRetorno = 0; 
	   double iTamanhoTotal = oGerenciadorListaCliente.RetornaTotalPessoas();
	  
	   switch(sParametro)		
	   {
	      case "SOCIO" : iRetorno = oGerenciadorListaCliente.RetornaTotalSocio();            break;
	      case "M"        : iRetorno = oGerenciadorListaCliente.RetornaTotalGenero('M');     break;
	      case "F"         : iRetorno = oGerenciadorListaCliente.RetornaTotalGenero('F');      break;
	      default          : break;
	   }
	   return (iRetorno/iTamanhoTotal)*100;
	}
	
	public void RegistraSaidaCliente(String sCpf)
	{
		oGerenciadorListaCliente.RegistraSaidaCliente(sCpf);
	}
}
