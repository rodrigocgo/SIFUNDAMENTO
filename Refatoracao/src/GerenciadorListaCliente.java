import java.util.ArrayList;

public class GerenciadorListaCliente 
{
	private ArrayList<Cliente> listaCliente;
	
	public GerenciadorListaCliente()
	{
	  listaCliente = new ArrayList<Cliente>();	
	}
	
	void AdicionaCliente(Cliente oCliente,String sNome,String sCPF,char cGenero,int iIdade, boolean bSocio,String sNumeroSocio)
	{  
		for(int i = 0;  i < listaCliente.size(); i++)
		{
		   if (listaCliente.get(i).getCPF() == sCPF) 
		     throw new IllegalArgumentException("CPF JA CADASTRADO");
		  
		   if (listaCliente.get(i).getNumeroSocio() == sNumeroSocio && listaCliente.get(i).getNumeroSocio().length() > 0)
		     throw new IllegalArgumentException("NUMERO SOCIO JA CADASTRADO");
		}
		
		if (bSocio == true && sNumeroSocio.length() == 0) 
		  throw new IllegalArgumentException("NUMERO DO SOCIO OBRIGATORIO");
		
		oCliente = new Cliente(sNome,sCPF,cGenero,iIdade, bSocio,sNumeroSocio);
		
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
	
	int RetornaTotalPessoas()
	{
	  return listaCliente.size();	
	}
	
	boolean RetornaPessoaCPF(String sString)
	{
       boolean bEsta = false;
      
        for(int i = 0;  i < listaCliente.size(); i++)
	      if (listaCliente.get(i).getCPF() == sString) 
		    bEsta = true;		
	  
        return bEsta;
	}
	
	int RetornaTotalGenero(char cString)
	{
       int iContador = 0; 
	   
       for(int i = 0;  i < listaCliente.size(); i++)
	   {
		  if (listaCliente.get(i).getGenero() == cString) 
			  iContador++;
	   }
	   
       return iContador; 
	}
	
	int RetornaTotalSocio()
	{
		int iContador = 0; 
		   
	    for(int i = 0;  i < listaCliente.size() ; i++)
		{
	       if (listaCliente.get(i).getSocio() == true) 
		      iContador++;
		}
		   
	    return iContador; 
	}
	
	void RegistraSaidaCliente(String sCpf)
	{
		for(int i = 0;  i < listaCliente.size(); i++)
		{
	       if (listaCliente.get(i).getCPF() == sCpf) 
	         listaCliente.remove(i);
		}
	}
}
