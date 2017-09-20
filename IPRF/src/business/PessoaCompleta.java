package business;

public class PessoaCompleta extends Pessoa
{
	private long lContruibuicaoPrevidenciaria;
	
	public PessoaCompleta(String sNome, String sCPF,int iIdade,long lTotalRendimento, long lContruibuicaoPrevidenciaria) 
	{
		super(sNome, sCPF,iIdade,lTotalRendimento);
	    this.lContruibuicaoPrevidenciaria = lContruibuicaoPrevidenciaria;
	}

	public long getContruibuicaoPrevidenciaria() 
	{
		return lContruibuicaoPrevidenciaria;
	}

	public void setContruibuicaoPrevidenciaria(long lContruibuicaoPrevidenciaria) 
	{
		this.lContruibuicaoPrevidenciaria = lContruibuicaoPrevidenciaria;
	}

}
