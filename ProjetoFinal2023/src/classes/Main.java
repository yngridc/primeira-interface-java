package classes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textoEmail;
	private JPasswordField textoSenha;

	/**
	 *Abre a aplicação
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Criação do frame
	 */
	public Main() {
		//Componenete Jframe
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/classes/imagens/caixa-de-papelao.png")));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		setTitle("Yellow8 - Catálogo de produtos");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 253);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		// Componente JPanel
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 557, 221);
		getContentPane().add(panel);
		panel.setBackground(new Color(225, 225, 225));
		panel.setLayout(null);
		//Componente JLabel Email
		JLabel lblNewLabel_5 = new JLabel("EMAIL:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(281, 22, 63, 13);
		panel.add(lblNewLabel_5);
		// Caixa de entrada do EMAIL
		textoEmail = new JTextField();
		textoEmail.setColumns(10);
		textoEmail.setBounds(281, 45, 230, 29);
		panel.add(textoEmail);
		//Componente JLabel Senha
		JLabel LabelSenha = new JLabel("SENHA:");
		LabelSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		LabelSenha.setBounds(281, 94, 63, 13);
		panel.add(LabelSenha);
		//aqui é a caixa de entrada da SENHA
		textoSenha = new JPasswordField();
		textoSenha.setBounds(281, 117, 230, 29);
		panel.add(textoSenha);		
		//logo
		JLabel imagem = new JLabel("");
		imagem.setBounds(-50, -44, 372, 279);
		panel.add(imagem);
		imagem.setIcon(new ImageIcon(Main.class.getResource("/classes/imagens/logoYellow.png")));
		//Botão Entrar criado
		JButton botaoEntrar = new JButton("ENTRAR");
		botaoEntrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoEntrar.setBounds(343, 168, 109, 29);
		panel.add(botaoEntrar);
		//Evento que ocorrerá quando o botão ENTRAR for clicado
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// pegando os dados das caixas de entrada e colocando nas variaveis LOGIN e SENHA
				String login = textoEmail.getText();
				String senha = String.valueOf(textoSenha.getPassword());
				//email e senha fixos para logar
				Login usuariologin = new Login("admin@gmail.com","admin");
				//verifica se a senha e email estão corretos
					if (login.equals(usuariologin.getLogin()) && senha.equals(usuariologin.getSenha())) {
				Interface primeiraTela = new Interface();
				dispose();
				primeiraTela.setVisible(true);
	
					}else {
					//mensagem de erro caso a senha ou email sejam diferentes dos definidos acima
					JOptionPane.showMessageDialog(null, "Email e/ou senha inválidos", "ERRO",JOptionPane.ERROR_MESSAGE);
				}
		}});

	}

}
