import java.util.ArrayList;


public class Bar
{
	
	Cliente oCliente;
	ArrayList<Cliente> listaCliente;
	
	
	public Bar()
	{
		listaCliente = new ArrayList();	
	}
	
	void AdicionaCliente(String sNome,String sCPF,String sGenero,int iIdade, boolean bSocio,String sNumeroSocio)
	{  
		for(int i = 0;  i < listaCliente.size(); i++)
		{
		  if (listaCliente.get(i).getCPF() == sCPF) 
			  throw new IllegalArgumentException("CPF JA CADASTRADO");
		  
		  if (listaCliente.get(i).getNumeroSocio() == sNumeroSocio && listaCliente.get(i).getNumeroSocio().length() > 0)
			  throw new IllegalArgumentException("NUMERO SOCIO JA CADASTRADO");
		}
		
		if (bSocio == true && sNumeroSocio.length() == 0) throw new IllegalArgumentException("NUMERO DO SOCIO OBRIGATORIO");
		
		oCliente = new Cliente(sNome,sCPF,sGenero,iIdade, bSocio,sNumeroSocio);
		
		listaCliente.add(oCliente);
	}
	
	boolean ClienteNoBarCPF(String sCPF)
	{
		boolean bAux = false;
		
		for(int i = 0;  i < listaCliente.size(); i++)
		{
		  if (listaCliente.get(i).getCPF() == sCPF) 
			  bAux = true;
		}
		
		return bAux;
	}
	
	double GetPercentualCliente(String sParametro)
	{ 
	  int iRetorno = 0; 
	  double iTamanhoTotal = listaCliente.size();
	  switch(sParametro)		
	  {
	    case "SOCIO" : iRetorno = RetornaPercentualSocio();         break;
	    case "M"     : iRetorno = RetornaPercentualGenero("M");     break;
	    case "F"     : iRetorno = RetornaPercentualGenero("F");     break;
	    default      : break;
	  }
	  return (iRetorno/iTamanhoTotal)*100;
	}
	
	int RetornaTotalPessoas()
	{
	  return listaCliente.size();	
	}
	
	boolean RetornaPessoaCPF(String sString)
	{
      boolean bEsta = false;
      
      for(int i = 0;  i < listaCliente.size(); i++)
	    if (listaCliente.get(i).getGenero() == sString) 
		  bEsta = true;		
	  
      return bEsta;
	}
	
	int RetornaPercentualGenero(String sString)
	{
       int iContador = 0; 
	   
       for(int i = 0;  i < listaCliente.size(); i++)
	   {
		  if (listaCliente.get(i).getGenero() == sString) 
			  iContador++;
	   }
	   
       return iContador; 
	}
	
	int RetornaPercentualSocio()
	{
		int iContador = 0; 
		   
	    for(int i = 0;  i < listaCliente.size(); i++)
		{
	      if (listaCliente.get(i).getSocio() == true) 
		    iContador++;
		}
		   
	    return iContador; 
	}
	
	void RegistraEntradaSaidaCliente(String sCpf,boolean bSaiu)
	{
		for(int i = 0;  i < listaCliente.size(); i++)
		{
	      if (listaCliente.get(i).getCPF() == sCpf) 
	    	  listaCliente.get(i).setSaiu(bSaiu);
		}
	}
}
