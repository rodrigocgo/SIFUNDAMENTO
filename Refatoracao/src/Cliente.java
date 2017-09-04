
public class Cliente
{
	String sNome, sCPF;
	char cGenero;
	boolean bSocio;
	int iIdade;
	String sNumeroSocio;
	boolean bSaiu; 
	
	public Cliente()
	{
		
	}
	public boolean getSaiu() 
	{
		return bSaiu;
	}
	public void setSaiu(boolean bSaiu) 
	{
		this.bSaiu = bSaiu;
	}
	public Cliente(String sNome,String sCPF,char cGenero,int iIdade, boolean bSocio,String sNumeroSocio)
	{
	  this.sNome = sNome;
	  this.sCPF = sCPF;
	  this.cGenero = cGenero;
	  this.iIdade = iIdade;
	  this.bSocio = bSocio;
	  this.sNumeroSocio = sNumeroSocio;
	  this.bSaiu = true;
	}
	public void setNumeroSocio(String sNumeroSocio)
	{
	  this.sNumeroSocio = sNumeroSocio;	
	}
	public String getNumeroSocio()
	{
      return sNumeroSocio;		
	}
	public boolean getSocio()
	{
      return this.bSocio;		
	}
	public void setSocio(boolean bSocio)
	{
      this.bSocio = bSocio;
	}
	public String getNome() 
	{
		return sNome;
	}
	public void setNome(String sNome) 
	{
		this.sNome = sNome;
	}
	public String getCPF() 
	{
		return sCPF;
	}
	public void setCPF(String sCPF) 
	{
		this.sCPF = sCPF;
	}
	public char getGenero() 
	{
		return cGenero;
	}
	public void setGenero(char genero) 
	{
		this.cGenero = genero;
	}
	public int getIdade() 
	{
		return iIdade;
	}
	public void setIdade(int iIdade) 
	{
		this.iIdade = iIdade;
	} 
}
