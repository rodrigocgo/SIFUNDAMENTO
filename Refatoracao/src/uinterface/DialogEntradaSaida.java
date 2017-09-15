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

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.SystemColor;

public class DialogEntradaSaida extends JDialog
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private Bar oBar;
  private MaskFormatter CPFMascara;

  
  public void ReferenciaObjetoBar(Bar oBar)
  {
    this.oBar = oBar;
  }
  
  public int ConsultaClienteBar(String sCpf)
  {
    if (oBar.ClienteNoBarCPF(sCpf) == true)
      return 1;
    else if (oBar.ClienteNoBarCPF(sCpf) == false && oBar.RetornaPessoaCadastrada(sCpf) == true)
      return 2;
    else 
      return 3;
  }
  
  /**
   * Launch the application.
   */
  public static void main(String[] args)
  {
    try
    {
      DialogEntradaSaida dialog = new DialogEntradaSaida();
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
  public DialogEntradaSaida()
  {
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    try
    {
      CPFMascara = new MaskFormatter("###.###.###-##");
    } 
    catch (ParseException e1)
    {
     
    }
    setModal(true);
    NumberFormat longFormat = NumberFormat.getIntegerInstance();
    JRadioButton rdbtnEntrou = new JRadioButton("Entrou");
    JRadioButton rdbtnSaiu = new JRadioButton("Saiu");
    rdbtnEntrou.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        
        if (rdbtnEntrou.isSelected() == true)
          rdbtnSaiu.setSelected(false);
      }
    });
   
    rdbtnSaiu.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        if (rdbtnSaiu.isSelected() == true)
          rdbtnEntrou.setSelected(false);
      }
    });
    
    NumberFormatter numberFormatter = new NumberFormatter(longFormat);
    numberFormatter.setValueClass(Long.class);
    numberFormatter.setAllowsInvalid(false); 
    numberFormatter.setMinimum(0l); 
    
    JFormattedTextField ftxtEntraCPF = new JFormattedTextField();
    ftxtEntraCPF.setBounds(10, 74, 204, 20);
    contentPanel.add(ftxtEntraCPF);
    ftxtEntraCPF.setFormatterFactory(new DefaultFormatterFactory(CPFMascara));
    
    
    rdbtnEntrou.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        rdbtnSaiu.setSelected(false);
      }
    });
   
    rdbtnEntrou.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    rdbtnEntrou.setBounds(10, 101, 93, 23);
    contentPanel.add(rdbtnEntrou);
    
    
    rdbtnSaiu.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    rdbtnSaiu.setBounds(127, 101, 109, 23);
    contentPanel.add(rdbtnSaiu);
    
    JLabel lblAviso = new JLabel("");
    lblAviso.setBackground(SystemColor.menu);
    lblAviso.setForeground(SystemColor.menu);
    lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
    lblAviso.setFont(new Font("Source Sans Pro Black", Font.BOLD, 13));
    lblAviso.setBounds(0, 179, 298, 41);
    contentPanel.add(lblAviso);
    
    setTitle("Registra Entrada Saida");
    setBounds(100, 100, 314, 259);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      JLabel lblEntraCpf = new JLabel("Digite o CPF");
      lblEntraCpf.setFont(new Font("Source Sans Pro", Font.BOLD, 13));
      lblEntraCpf.setBounds(10, 43, 288, 20);
      contentPanel.add(lblEntraCpf);
    }
   
    {
      JButton btnOk = new JButton("Ok");
      btnOk.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          
         if (ftxtEntraCPF.getText().isEmpty() == true || rdbtnEntrou.isSelected() == false && rdbtnSaiu.isSelected() == false)
           return;
         
         switch(ConsultaClienteBar(ftxtEntraCPF.getText()))
         {
           case 1:
           case 2:
             if (rdbtnEntrou.isSelected() == true)
             {
               oBar.RegistraSaidaEntradaCliente(ftxtEntraCPF.getText(), false);
             }
             else if (rdbtnSaiu.isSelected() == true)
             {
               oBar.RegistraSaidaEntradaCliente(ftxtEntraCPF.getText(), true);
             }
             dispose();
           case 3: 
             lblAviso.setForeground(Color.RED);
             lblAviso.setText("CLIENTE NAO CADASTRADO");
           return;
             
         }
         
        }
      });
      btnOk.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
      btnOk.setActionCommand("OK");
      btnOk.setBounds(10, 137, 93, 31);
      contentPanel.add(btnOk);
    }
    {
      JButton BtnCancelar = new JButton("Cancelar");
      BtnCancelar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          dispose();
        }
      });
      BtnCancelar.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
      BtnCancelar.setActionCommand("OK");
      BtnCancelar.setBounds(113, 137, 93, 31);
      contentPanel.add(BtnCancelar);
    }
    
   
    
    
  }
}
