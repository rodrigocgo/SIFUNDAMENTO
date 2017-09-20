package persistence;
import java.util.ArrayList;

public class GerenciadorListaCliente 
{
	private ArrayList<Cliente> listaClienteTotal;
	private ArrayList<Cliente> listaClienteNoBar;
	
	public GerenciadorListaCliente()
	{
	  listaClienteTotal = new ArrayList<Cliente>();	
	  listaClienteNoBar = new ArrayList<Cliente>();  
	}

	private void VerificaCPFeNumeroSocio(String sCPF, String sNumeroSocio, boolean bSocio)
	{
		for(int i = 0;  i < listaClienteTotal.size(); i++)
		{
		   if (listaClienteTotal.get(i).getCPF().equals(sCPF)) 
		     throw new IllegalArgumentException("CPF JA CADASTRADO");
		  
		   if (listaClienteTotal.get(i).getNumeroSocio().equals(sNumeroSocio)  && listaClienteTotal.get(i).getNumeroSocio().length() > 0)
		     throw new IllegalArgumentException("NUMERO SOCIO JA CADASTRADO");
		   
			if (bSocio == true && sNumeroSocio.length() == 0) 
				  throw new IllegalArgumentException("NUMERO DO SOCIO OBRIGATORIO");
		}
	}
	
	public void AdicionaCliente(Cliente oCliente,String sNome,String sCPF,char cGenero,int iIdade, boolean bSocio,String sNumeroSocio)
	{  	
		VerificaCPFeNumeroSocio(sCPF,sNumeroSocio, bSocio);
		
		oCliente = new Cliente(sNome,sCPF,cGenero,iIdade, bSocio,sNumeroSocio);
		
		listaClienteTotal.add(oCliente);
		listaClienteNoBar.add(oCliente);
	}
	
	public boolean ClienteNoBarCPF(String sCPF)
	{
		boolean bAux = false;
		
		for(int i = 0;  i < listaClienteNoBar.size(); i++)
		{
		   if (listaClienteNoBar.get(i).getCPF().equals(sCPF)) 
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
	   return listaClienteTotal.size();	
	}
	public int RetornaQuantidaDefinidaNoBar(int iParametroDeEscolha,char cGenero)
	{
	  switch(iParametroDeEscolha)
	  {
	    case 1 :  return RetornaTotalSocioNoBar();
	    case 2 :  return RetornaTotalGeneroNoBar(cGenero);
	    default:  return 0;
	  }
	}
	private int RetornaTotalPessoasNoBar()
	{
	  return listaClienteNoBar.size();
	}
	
	public int RetornaQuantidaDefinidaTotal(int iParametroDeEscolha,char cGenero)
  {
    switch(iParametroDeEscolha)
    {
      case 1 :  return RetornaTotalSocio();
      case 2 :  return RetornaTotalGenero(cGenero);
      default:  return 0;
    }
  }	
	
	private int RetornaTotalGeneroNoBar(char cString)
	{
    int iContador = 0; 
	  
    for(int i = 0;  i < listaClienteNoBar.size(); i++)
	  {
		  if (listaClienteNoBar.get(i).getGenero() == cString) 
			  iContador++;
	  }
	   
    return iContador; 
	}
	
	private int RetornaTotalGenero(char cString)
  {
    int iContador = 0; 
    
    for(int i = 0;  i < listaClienteTotal.size(); i++)
    {
      if (listaClienteTotal.get(i).getGenero() == cString) 
        iContador++;
    }
     
    return iContador; 
  }
	
	public boolean RetornaPessoaCadastrada(String sCpf)
	{
	  for (int  i = 0; i < listaClienteTotal.size(); i++)
	  {
	    if (listaClienteTotal.get(i).getCPF().equals(sCpf) == true)
	      return true;
	  }
	   return false;
	}
	
	private int RetornaTotalSocioNoBar()
	{
		int iContador = 0; 
		   
	  for(int i = 0;  i < listaClienteNoBar.size() ; i++)
		{
	    if (listaClienteNoBar.get(i).getSocio() == true) 
		    iContador++;
		}  
	  return iContador; 
	}
	
	private int RetornaTotalSocio()
  {
     int iContador = 0; 
       
     for(int i = 0;  i < listaClienteTotal.size() ; i++)
     {
        if (listaClienteTotal.get(i).getSocio() == true) 
          iContador++;
     }  
     return iContador; 
  }
	
	public int RegistraSaidaEntradaCliente(String sCpf, boolean bSaiu)
	{
		if (bSaiu == true)
		{
		  for(int i = 0; i < listaClienteNoBar.size(); i++) 
		  {
		    if (listaClienteNoBar.get(i).getCPF().equals(sCpf) == true)
		    {
		      listaClienteNoBar.remove(i);
		      return 0;
		    }
		  }
		 }
		  else
		  {
		    for(int i = 0; i < listaClienteTotal.size(); i++)
		    {
		      if (listaClienteTotal.get(i).getCPF().equals(sCpf) == true)
		      {
		        boolean bAchou = false;
		        for (int j = 0; j < listaClienteNoBar.size(); j++)
		        {
		            if (listaClienteNoBar.get(j).getCPF().equals(sCpf) == true)
		            bAchou = true;
		        }
		        if (!bAchou)
		        {
		          listaClienteNoBar.add(listaClienteTotal.get(i));
		          return 0;
		        }
		        
		      }
		    }
		  }
		return 1;
	}
	
	public String GeraRelatorio()
	{
		String sRetorno = "";
	  
	  for (int i = 0; i < listaClienteTotal.size(); i++)
	    sRetorno += listaClienteTotal.get(i).toString() + "\n";
	  
	  return sRetorno;
	}
	
	public String GeraRelatorioPresenteNoBar()
	{
	    String sRetorno ="";
	  
	    for (int i = 0; i < listaClienteNoBar.size();i++)
	        sRetorno += listaClienteNoBar.get(i).toString() + "\n";
	  
	    return sRetorno;
	}
}
