package uinterface;
import business.Bar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class DialogConsultaCliente extends JDialog
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
      DialogConsultaCliente dialog = new DialogConsultaCliente();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog
   */
  public DialogConsultaCliente() 
  {
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    JLabel lblRetornoConsulta = new JLabel("New label");
    
    try
    {
      CPFMascara = new MaskFormatter("###.###.###-##");
    } 
    catch (ParseException e1)
    {
      lblRetornoConsulta.setText("Parse inválido");
    }
    
    setResizable(false);
    setTitle("Consulta Cliente");
    setBounds(100, 100, 327, 271);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    setModal(true);
    
    JPanel pnlRetorno = new JPanel();
    pnlRetorno.setBounds(0, 174, 321, 68);
    contentPanel.add(pnlRetorno);
    pnlRetorno.setLayout(null);
    
    
    lblRetornoConsulta.setBounds(0, 0, 321, 68);
    pnlRetorno.add(lblRetornoConsulta);
    lblRetornoConsulta.setBackground(Color.WHITE);
    lblRetornoConsulta.setForeground(Color.WHITE);
    lblRetornoConsulta.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
    lblRetornoConsulta.setHorizontalAlignment(SwingConstants.CENTER);
    
    NumberFormat longFormat = NumberFormat.getIntegerInstance();

    NumberFormatter numberFormatter = new NumberFormatter(longFormat);
    numberFormatter.setValueClass(Long.class);
    numberFormatter.setAllowsInvalid(false); 
    numberFormatter.setMinimum(0l); 
    
    JFormattedTextField ftxtEntraCpf = new JFormattedTextField(numberFormatter);
    ftxtEntraCpf.setBounds(10, 54, 204, 20);
    contentPanel.add(ftxtEntraCpf);
    ftxtEntraCpf.setFormatterFactory(new DefaultFormatterFactory(CPFMascara));
    
    contentPanel.setLayout(null);
    {
      JButton btnConsultar = new JButton("Consultar");
      btnConsultar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
           if (ftxtEntraCpf.getText().isEmpty() == true)
             return;
            
           switch(ConsultaClienteBar(ftxtEntraCpf.getText()))
           {  
             case 1:
               lblRetornoConsulta.setText("CLIENTE NO BAR");
               pnlRetorno.setBackground(Color.green);
             break;
             
             case 2:
               lblRetornoConsulta.setText("CLIENTE CADASTRADO MAS AUSENTE");
               pnlRetorno.setBackground(Color.orange);
             break;
             
             case 3:
               lblRetornoConsulta.setText("CLIENTE NÃO ENCONTRADO");
               pnlRetorno.setBackground(Color.red);
             break;  
           } 
        }
      });
      btnConsultar.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
      btnConsultar.setBounds(10, 85, 93, 31);
      contentPanel.add(btnConsultar);
      btnConsultar.setActionCommand("OK");
      getRootPane().setDefaultButton(btnConsultar);
    }
    
    JButton btnFechar = new JButton("Fechar");
    btnFechar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    btnFechar.setFont(new Font("Source Sans Pro", Font.BOLD, 11));
    btnFechar.setActionCommand("OK");
    btnFechar.setBounds(121, 85, 93, 31);
    contentPanel.add(btnFechar);
    
    JLabel lblEntraCpf = new JLabel("Digite o CPF");
    lblEntraCpf.setFont(new Font("Source Sans Pro", Font.BOLD, 13));
    lblEntraCpf.setBounds(10, 23, 74, 20);
    contentPanel.add(lblEntraCpf);
    
 
    
  
    
   
  }
}
