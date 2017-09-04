public class Bar
{
	
    private Cliente oCliente;
	private GerenciadorListaCliente oGerenciadorListaCliente; 
	
	public Bar()
	{
		oGerenciadorListaCliente = new GerenciadorListaCliente();
	}
	void AdicionaCliente(String sNome,String sCpf,char cGenero,int iIdade,boolean bSocio,String sNumeroSocio)
	{
		oGerenciadorListaCliente.AdicionaCliente(oCliente,sNome,sCpf,cGenero,iIdade,bSocio,sNumeroSocio);
	}
	
	boolean ClienteNoBarCPF(String sCpf)
	{
	   return oGerenciadorListaCliente.RetornaPessoaCPF(sCpf);
	}
	
	int RetornaTotalPessoas()
	{
		return oGerenciadorListaCliente.RetornaTotalPessoas();
	}
	
	double GetPercentualCliente(String sParametro)
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
}
