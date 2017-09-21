package business;

public class PessoaCompleta extends Pessoa
{
	private int iIdade;
	private double dTotalRendimento;
	private int iNumeroDependetes;
	
	public PessoaCompleta(String sNome, String sCPF,int iIdade,double dTotalRendimento, long lContruibuicaoPrevidenciaria, int iNumeroDependetes) 
	{
		super(sNome, sCPF,lContruibuicaoPrevidenciaria);
		this.iIdade = iIdade;
		this.dTotalRendimento = dTotalRendimento;
		this.iNumeroDependetes = iNumeroDependetes;
	}

	public int getNumeroDependetes()
	{
		return iNumeroDependetes;
	}

	public void setNumeroDependetes(int iNumeroDependetes) 
	{
		this.iNumeroDependetes = iNumeroDependetes;
	}

	public int getIdade() 
	{
		return iIdade;
	}
	
	public void setIdade(int iIdade) 
	{
		this.iIdade = iIdade;
	}
	
	public double getlTotalRendimento()
	{
		return dTotalRendimento;
	}
	
	public void setlTotalRendimento(double lTotalRendimento) 
	{
		this.dTotalRendimento = lTotalRendimento;
	}
}
