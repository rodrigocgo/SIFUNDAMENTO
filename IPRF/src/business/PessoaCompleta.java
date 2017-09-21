package business;

public class PessoaCompleta extends Pessoa
{
	private int iIdade;
	private double dTotalRendimento;
	private int iNumeroDependetes;
	private DeclaracaoCompleta oDeclaracaoCompleta;
	
	public PessoaCompleta(String sNome, String sCPF,int iIdade,double dTotalRendimento, double dContruibuicaoPrevidenciaria, int iNumeroDependetes) 
	{
		super(sNome, sCPF,dContruibuicaoPrevidenciaria);
		this.iIdade = iIdade;
		this.dTotalRendimento = dTotalRendimento;
		this.iNumeroDependetes = iNumeroDependetes;
		oDeclaracaoCompleta = new DeclaracaoCompleta(iIdade,iNumeroDependetes, dTotalRendimento,dContruibuicaoPrevidenciaria);
		
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
	
	public double calculaImposto()
	{
		return oDeclaracaoCompleta.CalculaImposto();
	}
}
