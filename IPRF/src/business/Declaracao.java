package business;

public abstract class Declaracao 
{
	private double dTotalRendimento;
	private double dBaseCalculo;
	private double dContruibuicaoPrevidenciaria;

	public Declaracao(double dTotalRendimento, double dContruibuicaoPrevidenciaria)
   {
	   this.dTotalRendimento = dTotalRendimento;
	   this.dContruibuicaoPrevidenciaria = dContruibuicaoPrevidenciaria;
   }
	
	public double getTotalRendimento() 
	{
		return dTotalRendimento;
	}
	public void setlTotaRendimento(double dTotalRendimento) 
	{
		this.dTotalRendimento = dTotalRendimento;
	}
	
	public double CalculaPercentual(double dPercentual, double dValor)
	{
		return dValor*(dPercentual/100);
	}
	
	public double CalculaDesconto(double dPercentual, double dValorExcedido)
	{
		double dDesconto = dValorExcedido;
		dDesconto = dDesconto - (dDesconto*(dPercentual/100));
        return dDesconto;
	}
	
	public double RetornaImposto(double dBase)
	{
		return 0;
	}
	
	public double getBaseCalculo() 
	{
		return dBaseCalculo;
	}
	public void setBaseCalculo(double dBaseCalculo) 
	{
		this.dBaseCalculo = dBaseCalculo;
	}
	
	private double CalculaFaixaDozeMil(double dBaseCalculada)
	{
		double dExceco = this.getBaseCalculo();
		dExceco =  dExceco - 12000;
		return CalculaPercentual(15,dExceco);
	}
	
	public double CalculaImpostaPagar()
	{   
		double dBaseCalculada = getBaseCalculo();
		
		if (dBaseCalculada < 12000)
	     {
		     return 0;
	     }
	     else if(dBaseCalculada <  24000)
	     {
	    	 return CalculaFaixaDozeMil(dBaseCalculada);
	     }
	     else
	     {
	    	 double lImpostoFaixaAnterior;
	    	 lImpostoFaixaAnterior = CalculaFaixaDozeMil(dBaseCalculada);
	    	 return CalculaPercentual(27.5, lImpostoFaixaAnterior);
	     }     
	}
	
	public double getContruibuicaoPrevidenciaria() 
	{
		return dContruibuicaoPrevidenciaria;
	}

	public void setContruibuicaoPrevidenciaria(double dContruibuicaoPrevidenciaria)
	{
		this.dContruibuicaoPrevidenciaria = dContruibuicaoPrevidenciaria;
	}
}
