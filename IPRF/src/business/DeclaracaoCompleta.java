package business;

public class DeclaracaoCompleta extends Declaracao
{
	private int iIdade;
	private int iNumeroDependetes;
	
	public DeclaracaoCompleta(int iIdade, int iNumeroDependetes, double dTotalRendimento,double dContruibuicaoPrevidenciaria) 
	{
		super(dTotalRendimento,dContruibuicaoPrevidenciaria);
		this.iIdade = iIdade;
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
	public int getNumeroDependetes() 
	{
		return iNumeroDependetes;
	}
	public void setNumeroDependetes(int iNumeroDependetes) 
	{
		this.iNumeroDependetes = iNumeroDependetes;
	}
	
	private double CalculaBaseMaior65()
	{
		int iNumeroDependentes = getNumeroDependetes();
		double dTotalRendimento = getContruibuicaoPrevidenciaria()-getTotalRendimento();
		
		if (iNumeroDependentes < 2)
		{
			return CalculaDesconto(2.0, dTotalRendimento);
		}
		else if (iNumeroDependentes < 5)
		{
			return CalculaDesconto(3.5, dTotalRendimento);
		}
		else 
		{
			return CalculaDesconto(5, dTotalRendimento);
		}
	}
	private double CalculaBaseMenor65()
	{
		int iNumeroDependentes = getNumeroDependetes();
		double dTotalRendimento =getContruibuicaoPrevidenciaria()-getTotalRendimento();
		
		if (iNumeroDependentes < 2)
		{
			return CalculaDesconto(3.0, dTotalRendimento);
		}
		else if (iNumeroDependentes < 5)
		{
			return CalculaDesconto(4.5, dTotalRendimento);
		}
		else 
		{
			return CalculaDesconto(6, dTotalRendimento);
		}
	}
	
	private void CalculaBase()
	{
		int iIdade = getIdade();
		
		if (iIdade < 65) 
		{
			setBaseCalculo(CalculaBaseMenor65()); 
		}
		else
		{
			setBaseCalculo(CalculaBaseMaior65());
		}
	}
	
	public  double CalculaImposto()
	{
		CalculaBase();
		return CalculaImpostaPagar();
	}
			
}
