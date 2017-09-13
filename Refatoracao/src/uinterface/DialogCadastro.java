package uinterface;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import business.Bar;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class DialogCadastro extends JDialog
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private Bar oBar;
  private MaskFormatter CPFMascara;
  private MaskFormatter IDADEMascara;
  
  public void ReferenciaObjetoBar(Bar oBar)
  {
    this.oBar = oBar;
  }
  
  public String FormataCampoCPF(String sCpf)
  {
    String sAux = sCpf.replace('.', ' ');
    sAux = sAux.replace('-', ' ');
    return sAux.trim();
  }
  public void AdicionaCliente(String sNome,String sCpf,char cGenero,int iIdade,boolean bSocio,String sNumeroSocio)
  {
    oBar.AdicionaCliente(sNome, sCpf, cGenero, iIdade, bSocio, sNumeroSocio);
  }
  public int ValidaCampos(String sNome,String sCpf,String sIdade,boolean bSocio,String sNumeroSocio)
  {
    if (sNome.isEmpty() == true)
      return 1;
    else if(sCpf.isEmpty() == true)
      return 2;
    else if(sIdade.isEmpty() == true)
      return 3;
    else if(bSocio == true && sNumeroSocio.isEmpty() == true)
      return 4;
    
    return 0;
  }
  /**
   * Launch the application.
   */
  public static void main(String[] args)
  {
    try
    {
      DialogCadastro dialog = new DialogCadastro();
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
  public DialogCadastro()
  {
    NumberFormat longFormat = NumberFormat.getIntegerInstance();
    NumberFormatter numberFormatter = new NumberFormatter(longFormat);
    JLabel lblAviso = new JLabel("New label");  
    
    try
    {
      CPFMascara = new MaskFormatter("###.###.###-##");
      IDADEMascara = new MaskFormatter("##");
    } 
    catch (ParseException e1)
    {
      lblAviso.setForeground(Color.red);
      lblAviso.setText("Parse invalido");
    }
  
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setModal(true);
    setTitle("Cadastro Cliente");
    JLabel lblEntraNome = new JLabel("Nome");
    JFormattedTextField ftxtEntraNome = new JFormattedTextField();
    JLabel lblEntraCpf = new JLabel("CPF");
    JFormattedTextField ftxtEntraCpf = new JFormattedTextField((Object) null);
    JLabel lblIdade = new JLabel("Idade");
    JFormattedTextField ftxtEntraIdade = new JFormattedTextField();
    JLabel lblGenero = new JLabel("Sexo");
    JRadioButton rdbtnM = new JRadioButton("M");
    JRadioButton rdbtnF = new JRadioButton("F");
    
    rdbtnM.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        
        if (rdbtnM.isSelected() == true)
         rdbtnF.setSelected(false);
      }
    });
    
    rdbtnF.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        
        if (rdbtnF.isSelected() == true)
          rdbtnM.setSelected(false);
      }
    });
    
    JLabel lblNumeroSocio = new JLabel("C\u00F3digo S\u00F3cio");
    JCheckBox chckbxSocio = new JCheckBox("S\u00F3cio");
    JFormattedTextField ftxtEntraCodigo = new JFormattedTextField();
    chckbxSocio.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        if (chckbxSocio.isSelected() == true )
        {
          lblNumeroSocio.setVisible(true);
          ftxtEntraCodigo.setVisible(true);
        }
        else
        {
          lblNumeroSocio.setVisible(false);
          ftxtEntraCodigo.setVisible(false);
        }
       
      }
    });
    
    
    JButton bntOk = new JButton("Ok");
    
    bntOk.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        String sNome = ftxtEntraNome.getText();
        String sCpf  = FormataCampoCPF(ftxtEntraCpf.getText());
        String sIdade = ftxtEntraIdade.getText().trim();
        boolean bSocio = chckbxSocio.isSelected();
        String sCodigoSocio = ftxtEntraCodigo.getText();
        char cGenero;
        
        switch(ValidaCampos(sNome,sCpf,sIdade,bSocio,sCodigoSocio))
        {
          case 1:
            lblAviso.setForeground(Color.red);
            lblAviso.setText("Campo NOME Vazio!");
            return;
          case 2:
            lblAviso.setForeground(Color.red);
            lblAviso.setText("Campo CPF Vazio!");
            return;
          case 3:
            lblAviso.setForeground(Color.red);
            lblAviso.setText("Campo IDADE Vazio!");
            return;
          case 4:
            lblAviso.setForeground(Color.red);
            lblAviso.setText("Campo CODIGO SOCIO Vazio!");
            return;
        }
        
        if (rdbtnM.isSelected() == true)
          cGenero = 'M';
        else 
          cGenero = 'F';
        
        try
        {
          oBar.AdicionaCliente(sNome, ftxtEntraCpf.getText(), cGenero, Integer.parseInt(sIdade), bSocio, sCodigoSocio);
          dispose();
        }
        catch (IllegalArgumentException e1)
        {
          lblAviso.setForeground(Color.red);
          lblAviso.setText(e1.getMessage());
        }
        
      }
    });
    JButton bntLimpa = new JButton("Limpa");
    bntLimpa.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ftxtEntraNome.setText(" ");
        ftxtEntraIdade.setText("");
        ftxtEntraCpf.setText("");
        chckbxSocio.setSelected(false);
        ftxtEntraCodigo.setText("");
        
      }
    });
    
    numberFormatter.setValueClass(Long.class);
    numberFormatter.setAllowsInvalid(false); 
    numberFormatter.setMinimum(0l); 
    
    
    lblNumeroSocio.setVisible(false);
    ftxtEntraCodigo.setVisible(false);
    
    setBounds(100, 100, 304, 473);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    
    lblEntraNome.setFont(new Font("Source Sans Pro", Font.BOLD, 13));
    lblEntraNome.setBounds(10, 21, 102, 20);
    contentPanel.add(lblEntraNome);

    
    ftxtEntraNome.setBounds(10, 44, 204, 20);
    contentPanel.add(ftxtEntraNome);
    ftxtEntraIdade.setFormatterFactory(new DefaultFormatterFactory(IDADEMascara));
   
    lblEntraCpf.setFont(new Font("Source Sans Pro", Font.BOLD, 13));
    lblEntraCpf.setBounds(10, 75, 102, 20);
    contentPanel.add(lblEntraCpf);
    
    ftxtEntraCpf.setBounds(10, 94, 204, 20);
    contentPanel.add(ftxtEntraCpf);
    ftxtEntraCpf.setFormatterFactory(new DefaultFormatterFactory(CPFMascara));
    
    lblIdade.setFont(new Font("Source Sans Pro", Font.BOLD, 13));
    lblIdade.setBounds(10, 122, 102, 20);
    contentPanel.add(lblIdade);
    
   
    ftxtEntraIdade.setBounds(10, 144, 42, 20);
    contentPanel.add(ftxtEntraIdade);
    
    
    
    lblGenero.setFont(new Font("Source Sans Pro", Font.BOLD, 13));
    lblGenero.setBounds(10, 175, 102, 20);
    contentPanel.add(lblGenero);
    
    
    rdbtnM.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    rdbtnM.setSelected(true);
    rdbtnM.setBounds(10, 195, 42, 23);
    contentPanel.add(rdbtnM);
    
    
    rdbtnF.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    rdbtnF.setBounds(70, 195, 33, 23);
    contentPanel.add(rdbtnF);
    
    
    chckbxSocio.setBounds(10, 235, 97, 23);
    contentPanel.add(chckbxSocio);
    
    
    lblNumeroSocio.setFont(new Font("Source Sans Pro", Font.BOLD, 13));
    lblNumeroSocio.setBounds(10, 265, 102, 20);
    contentPanel.add(lblNumeroSocio);
    
    
    ftxtEntraCodigo.setBounds(10, 283, 204, 20);
    contentPanel.add(ftxtEntraCodigo);
    
    
    bntOk.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    bntOk.setActionCommand("OK");
    bntOk.setBounds(10, 332, 93, 31);
    contentPanel.add(bntOk);
    
    
    bntLimpa.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    bntLimpa.setActionCommand("OK");
    bntLimpa.setBounds(113, 332, 93, 31);
    contentPanel.add(bntLimpa);
    
    lblAviso.setForeground(Color.WHITE);
    lblAviso.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
    lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
    lblAviso.setBounds(0, 386, 253, 25);
    contentPanel.add(lblAviso);
  }
}
