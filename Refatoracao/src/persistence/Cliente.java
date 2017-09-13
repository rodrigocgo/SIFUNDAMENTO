package persistence;

public class Cliente
{
	private String sNome, sCPF;
	private char cGenero;
	private boolean bSocio;
	private int iIdade;
	private String sNumeroSocio; 
	
	public Cliente(String sNome,String sCPF,char cGenero,int iIdade, boolean bSocio,String sNumeroSocio)
	{
	  this.sNome = sNome;
	  this.sCPF = sCPF;
	  this.cGenero = cGenero;
	  this.iIdade = iIdade;
	  this.bSocio = bSocio;
	  this.sNumeroSocio = sNumeroSocio;
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
	
	public String toString()
	{
	  return "Nome [" + sNome +"]" + " Cpf [" + sCPF  + "]" + " Genero [" + String.format("%s",cGenero) +"]" + " Idade [" + String.format("%d",iIdade) +"] Numero Socio ["+ sNumeroSocio+"]";
	}
}
