package business;

abstract public class Pessoa 
{
	private String sNome;
	private String sCpf;
	
	public Pessoa(String sNome, String sCPF)
	{
		this.sNome = sNome;
		this.sCpf = sCPF;
    }
	
	public String getNome() 
	{
		return sNome;
	}
	public void setNome(String sNome) 
	{
		this.sNome = sNome;
	}
	public String getCpf() 
	{
		return sCpf;
	}
	public void setCpf(String sCpf) 
	{
		this.sCpf = sCpf;
	}
	
}
