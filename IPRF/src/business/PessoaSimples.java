package business;

public class PessoaSimples extends Pessoa 
{
	private DeclaraoSimples oDeclaracaoSimples;
	public PessoaSimples(String sNome, String sCPF,double dTotalRendimento,double dContruibuicaoPrevidenciaria) 
	{
		super(sNome, sCPF,dContruibuicaoPrevidenciaria);
		oDeclaracaoSimples = new DeclaraoSimples(dTotalRendimento,dContruibuicaoPrevidenciaria);
	}
	
	public double calculaImposto()
	{
		return oDeclaracaoSimples.CalculaImposto();
	}
}
