package business;
import java.util.ArrayList;

import persistence.Cliente;

public class GerenciadorListaCliente 
{
	private ArrayList<Cliente> listaCliente;
	
	public GerenciadorListaCliente()
	{
	   listaCliente = new ArrayList<Cliente>();	
	}

	private void VerificaCPFeNumeroSocio(String sCPF, String sNumeroSocio, boolean bSocio)
	{
		for(int i = 0;  i < listaCliente.size(); i++)
		{
		   if (listaCliente.get(i).getCPF() == sCPF) 
		     throw new IllegalArgumentException("CPF JA CADASTRADO");
		  
		   if (listaCliente.get(i).getNumeroSocio() == sNumeroSocio && listaCliente.get(i).getNumeroSocio().length() > 0)
		     throw new IllegalArgumentException("NUMERO SOCIO JA CADASTRADO");
		   
			if (bSocio == true && sNumeroSocio.length() == 0) 
				  throw new IllegalArgumentException("NUMERO DO SOCIO OBRIGATORIO");
		}
	}
	
	public void AdicionaCliente(Cliente oCliente,String sNome,String sCPF,char cGenero,int iIdade, boolean bSocio,String sNumeroSocio)
	{  	
		VerificaCPFeNumeroSocio(sCPF,sNumeroSocio, bSocio);
		
		oCliente = new Cliente(sNome,sCPF,cGenero,iIdade, bSocio,sNumeroSocio);
		
		listaCliente.add(oCliente);
	}
	
	public boolean ClienteNoBarCPF(String sCPF)
	{
		boolean bAux = false;
		
		for(int i = 0;  i < RetornaTotalPessoasNoBar(); i++)
		{
		   if (listaCliente.get(i).getCPF() == sCPF) 
			  bAux = true;
		}
		
		return bAux;
	}
	
	public int RetornaPessoasTotal(boolean bTotal)
	{
	  return (bTotal == true) ? RetornaTotalPessoasNoBar() : RetornaTotalPessoasCadastradas();
	}
	
	private int RetornaTotalPessoasCadastradas()
	{
	   return listaCliente.size();	
	}
	public int RetornaQuantidaDefinida(int iParametroDeEscolha,char cGenero)
	{
	  switch(iParametroDeEscolha)
	  {
	    case 1 :  return RetornaTotalSocio();
	    case 2 :  return RetornaTotalGenero(cGenero);
	    default:  return 0;
	  }
	}
	private int RetornaTotalPessoasNoBar()
	{
	  int iContador = 0;
	  for(int i = 0; i < listaCliente.size();i++)
	  {
	    if (listaCliente.get(i).getSaiu() == false)
	      iContador++;
	  }
	  
	  return iContador;
	}
	
	public boolean RetornaPessoaCPF(String sString)
	{
    boolean bEsta = false;
    
    for(int i = 0;  i < RetornaTotalPessoasNoBar(); i++)
	    if (listaCliente.get(i).getCPF() == sString) 
		    bEsta = true;		
	  
    return bEsta;
	}
	
	private int RetornaTotalGenero(char cString)
	{
    int iContador = 0; 
	  
    for(int i = 0;  i < RetornaTotalPessoasNoBar(); i++)
	  {
		  if (listaCliente.get(i).getGenero() == cString) 
			  iContador++;
	  }
	   
    return iContador; 
	}
	
	private int RetornaTotalSocio()
	{
		int iContador = 0; 
		   
	  for(int i = 0;  i < RetornaTotalPessoasNoBar() ; i++)
		{
	    if (listaCliente.get(i).getSocio() == true) 
		    iContador++;
		}  
	  return iContador; 
	}
	
	public void RegistraSaidaCliente(String sCpf)
	{
		for(int i = 0;  i < listaCliente.size(); i++)
		{
	    if (listaCliente.get(i).getCPF() == sCpf) 
	      listaCliente.get(i).setSaiu(true);
		}
	}
}
