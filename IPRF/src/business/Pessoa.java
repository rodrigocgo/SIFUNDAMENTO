package business;

abstract public class Pessoa 
{
	private String sNome;
	private String sCpf;
	private double dContruibuicaoPrevidenciaria;
	
	public Pessoa(String sNome, String sCPF, double dContruibuicaoPrevidenciaria)
	{
		this.sNome = sNome;
		this.sCpf = sCPF;
		this.dContruibuicaoPrevidenciaria = dContruibuicaoPrevidenciaria;
    }
	
	public double getContruibuicaoPrevidenciaria() 
	{
		return dContruibuicaoPrevidenciaria;
	}

	public void setContruibuicaoPrevidenciaria(double lContruibuicaoPrevidenciaria) 
	{
		this.dContruibuicaoPrevidenciaria = lContruibuicaoPrevidenciaria;
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
