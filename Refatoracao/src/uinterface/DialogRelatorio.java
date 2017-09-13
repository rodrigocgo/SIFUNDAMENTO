package uinterface;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import business.Bar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DialogRelatorio extends JDialog
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private Bar oBar;
  private int iSexo;
  private boolean bSocio;
  
  
  public void ReferenciaObjetoBar(Bar oBar)
  {
    this.oBar = oBar;
  }
  
  public String RetornaPercentFormatado()
  {
    String sRetorno = null;
    
    if (iSexo == 1)
    {   
      sRetorno = String.format("%.2f", oBar.retornaPercentualClienteNoBar("M"));    
    }
    else if (iSexo == 2)
    {
      sRetorno = String.format("%.2f", oBar.retornaPercentualClienteNoBar("F"));
    }
    else if (iSexo == 0 && bSocio == true)
    {
      sRetorno = String.format("%.2f", oBar.retornaPercentualClienteNoBar("SOCIO"));
    }
    else 
      return "Filtro Invalido";
    
    if (sRetorno.equals("NaN") == true)
      return "Cadastro Vazio!";
    
    sRetorno += "%";
    
    return sRetorno;
  }
  /**
   * Launch the application.
   */
  public static void main(String[] args)
  {
    try
    {
      DialogRelatorio dialog = new DialogRelatorio();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   */
  public DialogRelatorio()
  {
    setModal(true);
    setTitle("Relat\u00F3rio");
    setBounds(100, 100, 262, 309);
    getContentPane().setLayout(null);
    iSexo =  0;
    bSocio = false;
    
    
    JLabel lblPercentual = new JLabel("PERCENTUAL");
    lblPercentual.setHorizontalAlignment(SwingConstants.CENTER);
    lblPercentual.setFont(new Font("Source Sans Pro", Font.BOLD, 13));
    lblPercentual.setBounds(6, 0, 240, 43);
    getContentPane().add(lblPercentual);
    JCheckBox chckbxF = new JCheckBox("F");
    JCheckBox chckbxM = new JCheckBox("M");
    JCheckBox chckbxSocio = new JCheckBox("S\u00F3c\u00EDo");
    chckbxF.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        
        if (chckbxF.isSelected() == true)
        {
          chckbxM.setSelected(false);
          iSexo = 2;
          bSocio = false;
          chckbxSocio.setEnabled(false);
        }
        else if (chckbxF.isSelected() == false && chckbxM.isSelected() == false)
        {
          chckbxSocio.setEnabled(true);
          iSexo = 0;
        }
          
      }
    });
    
    chckbxM.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        if (chckbxM.isSelected() == true)
        {
          chckbxF.setSelected(false);
          iSexo = 1;
          bSocio = false;
          chckbxSocio.setEnabled(false);
        }
        else if (chckbxF.isSelected() == false && chckbxM.isSelected() == false)
        {
          chckbxSocio.setEnabled(true);
          iSexo = 0;
        }
          
      }
    });
    chckbxM.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    chckbxM.setSelected(true);
    chckbxM.setBounds(6, 64, 38, 23);
    getContentPane().add(chckbxM);
    
   
    chckbxF.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    chckbxF.setBounds(46, 64, 33, 23);
    getContentPane().add(chckbxF);
    
    JLabel lblFiltros = new JLabel("FILTROS");
    lblFiltros.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
    lblFiltros.setBounds(10, 43, 64, 14);
    getContentPane().add(lblFiltros);
    
    
    chckbxSocio.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        if (chckbxSocio.isSelected() == true)
        {
          bSocio = true;
          chckbxF.setEnabled(false);
          chckbxM.setEnabled(false);
        }
        else
        {
          bSocio = false;
          chckbxF.setEnabled(true);
          chckbxM.setEnabled(true);
        }
          
      }
    });
    chckbxSocio.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    chckbxSocio.setBounds(6, 105, 97, 23);
    getContentPane().add(chckbxSocio);
    
    JButton bntImprimirRelatorio = new JButton("Salvar"); 
    bntImprimirRelatorio.setBounds(139, 156, 80, 23);
    getContentPane().add(bntImprimirRelatorio);
    bntImprimirRelatorio.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) 
        {
        	JFileChooser fcPath = new JFileChooser();
        	fcPath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        	Integer iReturn = fcPath.showOpenDialog(bntImprimirRelatorio.getParent());  
              
        	if(iReturn  == JFileChooser.APPROVE_OPTION) 
        	{
        		BufferedWriter output = null;
        		try 
        		{
        		   File fRelatorio = fcPath.getSelectedFile();
        		   output = new BufferedWriter(new FileWriter(fRelatorio));
        		   output.write(oBar.RelatorioCompleto());
        		   output.close();
        		 
        		   
        		} catch (IOException ex) 
        		{
        			
        		}
        	    
        	}
        }
      });
    
    
    JLabel lblSalvarRelatorio = new JLabel("Relat\u00F3rio Completo");
    lblSalvarRelatorio.setHorizontalAlignment(SwingConstants.CENTER);
    lblSalvarRelatorio.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    lblSalvarRelatorio.setBounds(104, 142, 142, 14);
    getContentPane().add(lblSalvarRelatorio);
    JLabel lblPercent = new JLabel("");
    JButton btnGerar = new JButton("Gerar");
   
    btnGerar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) 
      {
        lblPercent.setForeground(Color.BLACK);
        lblPercent.setText(RetornaPercentFormatado());
      }
    });
    btnGerar.setBounds(6, 156, 73, 23);
    getContentPane().add(btnGerar);
    
    JPanel pnlStatus = new JPanel();
    pnlStatus.setBackground(SystemColor.menu);
    pnlStatus.setBounds(0, 194, 246, 76);
    getContentPane().add(pnlStatus);
    pnlStatus.setLayout(null);
    
    
    lblPercent.setBackground(SystemColor.menu);
    lblPercent.setForeground(SystemColor.menu);
    lblPercent.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
    lblPercent.setHorizontalAlignment(SwingConstants.CENTER);
    lblPercent.setBounds(0, 0, 244, 73);
    pnlStatus.add(lblPercent);
  }
}
