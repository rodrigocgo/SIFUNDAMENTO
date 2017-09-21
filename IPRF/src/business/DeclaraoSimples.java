package business;

public class DeclaraoSimples extends Declaracao
{
	
	public DeclaraoSimples(double dTotalRendimento,double dContruibuicaoPrevidenciaria) 
	{
		super(dTotalRendimento, dContruibuicaoPrevidenciaria);
	}
	
	private void CalculaBase()
	{   
		double dBaseCalculada = CalculaDesconto(5.0,getContruibuicaoPrevidenciaria()-getTotalRendimento());
	     this.setBaseCalculo(dBaseCalculada);
	}
	
	public  double CalculaImposto()
	{
		CalculaBase();
		return CalculaImpostaPagar();
	}
	
}
