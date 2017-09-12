package business;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	   return oGerenciadorListaCliente.ClienteNoBarCPF(sCpf);
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
	      case "SOCIO"  : iRetorno = oGerenciadorListaCliente.RetornaQuantidaDefinidaNoBar(1,' '); break;
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
	
	public String RelatorioCompleto()
	{
		String sRelatorioCompleto;
		String sData = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		
		sRelatorioCompleto ="["+sData + "]\n\n"+"Total Cadastrado =["+RetornaTotalPessoasCadastradas()+"]\nTotal no Bar =["+RetornaTotalPessoasNoBar()+"]\n\n[PERCENTUAIS]\nPercentual Socio no Bar =["+String.format("%.2f",retornaPercentualClienteNoBar("SOCIO"))+"%]\nPercentual Homem no Bar=["+String.format("%.2f",retornaPercentualClienteNoBar("M"))+"%]\nPercentual Mulher no Bar=["+String.format("%.2f",retornaPercentualClienteNoBar("F"))+"%]\nPercentual Socio Cadastrado =["+String.format("%.2f",retornaPercentualClienteTotal("SOCIO"))+"%]\nRetorna Percentual Homens Cadastrado =["+String.format("%.2f",retornaPercentualClienteTotal("M"))+"%]\nPercentual Mulher Cadastrado =["+String.format("%.2f",retornaPercentualClienteTotal("F"))+"%]\n\n[Clientes Cadastrados]\n"+GeraRelatorio()+"\n\n[Clientes no Bar]\n"+GeraRelatorioPresenteNoBar()+"\n";	
		return sRelatorioCompleto; 
	}
        
}
