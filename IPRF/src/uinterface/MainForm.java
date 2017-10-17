package uinterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Fachada;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainForm extends JDialog
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JTextField txtNome;
  private JTextField txtCPF;
  private JTextField txtRendimento;
  private JTextField txtContribuicao;
  private JTextField txtIdade;
  private JTextField txtDependentes;
  private Fachada oFachada;

  /**
   * Launch the application.
   */
  public static void main(String[] args)
  {
    try
    {
      MainForm dialog = new MainForm();
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
  public MainForm()
  {
    setBounds(100, 100, 373, 366);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("Nome");
    lblNewLabel.setBounds(10, 21, 46, 14);
    contentPanel.add(lblNewLabel);
    
    JLabel lblCpf = new JLabel("CPF");
    lblCpf.setBounds(10, 66, 46, 14);
    contentPanel.add(lblCpf);
    
    JLabel lblRendimento = new JLabel("Rendimento");
    lblRendimento.setBounds(10, 113, 101, 14);
    contentPanel.add(lblRendimento);
    
    JLabel lblNewLabel_1 = new JLabel("Contribuicao Previde.");
    lblNewLabel_1.setBounds(10, 170, 117, 14);
    contentPanel.add(lblNewLabel_1);
    
    txtNome = new JTextField();
    txtNome.setBounds(10, 35, 130, 20);
    contentPanel.add(txtNome);
    txtNome.setColumns(10);
    
    txtCPF = new JTextField();
    txtCPF.setColumns(10);
    txtCPF.setBounds(10, 82, 130, 20);
    contentPanel.add(txtCPF);
    
    txtRendimento = new JTextField();
    txtRendimento.setColumns(10);
    txtRendimento.setBounds(10, 129, 130, 20);
    contentPanel.add(txtRendimento);
    
    txtContribuicao = new JTextField();
    txtContribuicao.setColumns(10);
    txtContribuicao.setBounds(10, 189, 130, 20);
    contentPanel.add(txtContribuicao);
    
    JButton btnNewButton = new JButton("Declaracao Simples");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) 
      {
        if (txtNome.getText() == null || txtCPF.getText() == null || txtRendimento.getText() == null || txtContribuicao.getText() == null)
          return;
        double dValor = oFachada.DeclaracaoSimples(txtNome.getText(), txtCPF.getText(),Double.parseDouble(txtRendimento.getText()), Double.parseDouble(txtContribuicao.getText()));
      
      }
    });
    btnNewButton.setBounds(10, 245, 130, 23);
    contentPanel.add(btnNewButton);
    
    JButton btnDeclaracaoCompleta = new JButton("Declaracao Completa");
    btnDeclaracaoCompleta.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        if (txtNome.getText() == null || txtCPF.getText() == null || txtRendimento.getText() == null || txtContribuicao.getText() == null)
          return;
        
      }
    });
    btnDeclaracaoCompleta.setBounds(163, 245, 146, 23);
    contentPanel.add(btnDeclaracaoCompleta);
    
    JLabel lblIdade = new JLabel("Idade");
    lblIdade.setBounds(188, 21, 46, 14);
    contentPanel.add(lblIdade);
    
    txtIdade = new JTextField();
    txtIdade.setColumns(10);
    txtIdade.setBounds(188, 35, 59, 20);
    contentPanel.add(txtIdade);
    
    JLabel lblDependentes = new JLabel("Dependentes");
    lblDependentes.setBounds(188, 66, 64, 14);
    contentPanel.add(lblDependentes);
    
    txtDependentes = new JTextField();
    txtDependentes.setColumns(10);
    txtDependentes.setBounds(188, 82, 59, 20);
    contentPanel.add(txtDependentes);
  }
}
