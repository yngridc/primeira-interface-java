package classes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textoProduto;
	private JTextField textoID;
	private JTable tabela;
	private JTextField textoQuantidade;
	private JTextField textoPreco;

	/**
	 * Para abrir a aplicação
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Criaçaõ do frame.
	 */
	public Interface() {
		//Jframe e content
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interface.class.getResource("/classes/imagens/caixa-de-papelao.png")));
		setResizable(false);
		setTitle("Yellow8 - Catálogo de produtos");
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 437);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Lista de produtos cadastrados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Componente JPanel
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Cat\u00E1logo de produtos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 0, 367, 396);
		contentPane.add(panel);
		panel.setLayout(null);
		//Componente JLabel do ID
		JLabel LabelID = new JLabel("ID:");
		LabelID.setFont(new Font("Tahoma", Font.BOLD, 16));
		LabelID.setBounds(98, 44, 65, 17);
		panel.add(LabelID);
		// Caixa de entrada do ID
		textoID = new JTextField();
		textoID.setColumns(10);
		textoID.setBounds(98, 71, 170, 26);
		panel.add(textoID);
		//Componente JLabel do Produto
		JLabel LabelProduto = new JLabel("Digite o produto:");
		LabelProduto.setFont(new Font("Tahoma", Font.BOLD, 16));
		LabelProduto.setBounds(98, 107, 147, 26);
		panel.add(LabelProduto);
		//Caixa de entrada do produto
		textoProduto = new JTextField();
		textoProduto.setBounds(98, 143, 170, 26);
		panel.add(textoProduto);
		textoProduto.setColumns(10);
		//Componente JLabel da Quantidade
		JLabel LabelQuantidade = new JLabel("Quantidade:");
		LabelQuantidade.setFont(new Font("Tahoma", Font.BOLD, 16));
		LabelQuantidade.setBounds(98, 179, 100, 26);
		panel.add(LabelQuantidade);
		//Caixa de entrada da quantidade
		textoQuantidade = new JTextField();
		textoQuantidade.setBounds(98, 215, 170, 26);
		panel.add(textoQuantidade);
		textoQuantidade.setColumns(10);
		//Componente JLabel do Preço
		JLabel LabelPreço = new JLabel("Preço:");
		LabelPreço.setFont(new Font("Tahoma", Font.BOLD, 16));
		LabelPreço.setBounds(98, 251, 90, 26);
		panel.add(LabelPreço);
		//Caixa de entrada do preço
		textoPreco = new JTextField();
		textoPreco.setBounds(98, 287, 170, 26);
		panel.add(textoPreco);
		textoPreco.setColumns(10);
		
		//Componente JButton - criação do botão cadastrar
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCadastrar.setBounds(98, 338, 170, 41);
		panel.add(btnCadastrar);
				//eventos que acontecerão quando o botão cadastrar for clicado
				btnCadastrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//pegando os dados da JTextField{caixa de texto}
						
						String id = textoID.getText().trim();
						String texto = textoProduto.getText().trim();
						String quantidade = textoQuantidade.getText().trim();
						String preco = textoPreco.getText().trim();
						
						//aviso de que os campos devem estar todos preenchidos
						
						if ((textoID.getText() == null || textoID.getText().trim().isEmpty()) ||
							(textoProduto.getText() == null || textoQuantidade.getText().trim().isEmpty()) ||
							(textoPreco.getText() == null || textoPreco.getText().trim().isEmpty())) {
							
						JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos","ERRO", JOptionPane.ERROR_MESSAGE);
						
						}else {
							DefaultTableModel table = (DefaultTableModel) tabela.getModel();
							//adiciona o que foi digitado na tabela. var texto = o produto
							table.addRow(new String[] {id,texto,quantidade,preco});
							JOptionPane.showMessageDialog(null, texto + " foi cadastrado com sucesso", "Sucesso", JOptionPane.PLAIN_MESSAGE);
							//para limpar a caixa de texto após os dados serem cadastrados e adicionados na tabela
							textoID.setText("");
							textoProduto.setText(""); 
							textoPreco.setText("");
							textoQuantidade.setText("");
						}
						
				}
				});
				
	JPanel panel_1 = new JPanel();
	panel_1.setBorder(new TitledBorder(null, "Listagem de produtos cadastrados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	panel_1.setBounds(369, 10, 382, 386);
	contentPane.add(panel_1);
	panel_1.setLayout(null);
	//Barra de rolagem da tabela	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 22, 365, 291);
	panel_1.add(scrollPane);
	//Componente JTable - criação da tabela
	tabela = new JTable();
	scrollPane.setViewportView(tabela);
	tabela.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"ID", "Produto", "Quantidade", "Preço"
		}
	) {
		
});	
	
			//Botão APAGAR criado
			JButton btnApagar = new JButton("APAGAR");
			btnApagar.setBounds(10, 323, 170, 41);
			panel_1.add(btnApagar);
			btnApagar.setFont(new Font("Tahoma", Font.BOLD, 18));
			//Evento que ocorrerá quando o botão APAGAR for clicado
			btnApagar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								//verifica se tem alguma linha selecionada
								if(tabela.getSelectedRowCount() == 0) {
									//mensagem de erro caso não tenha selecionado a linha que deseja excluir
									JOptionPane.showMessageDialog(null, "Selecione a linha que deseja EXCLUIR", "ERRO", JOptionPane.ERROR_MESSAGE);
								} else {
									DefaultTableModel table = (DefaultTableModel) tabela.getModel();
									//código para apagar a coluna selecionada
									((DefaultTableModel) tabela.getModel()).removeRow(tabela.getSelectedRow());
									JOptionPane.showMessageDialog(null, "Excluido com sucesso");	
								}
				}
});
			//Botão EDITAR criado
			JButton btnEditar = new JButton("EDITAR");
			btnEditar.setBounds(202, 323, 170, 41);
			panel_1.add(btnEditar);
			btnEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
			//evento quando o botão editar for clicado
			btnEditar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								//Verifica se tem alguma linha selecionada
								if(tabela.getSelectedRowCount() == 0) {
									// mensagem de erro caso não tenha nenhuma linha selecionada
									JOptionPane.showMessageDialog(null, "Selecione a linha que deseja EDITAR", "ERRO", JOptionPane.ERROR_MESSAGE);
								}else {
									//caixas de dialogo para digitar os novos dados 
									String novoid = JOptionPane.showInputDialog("Digite o novo ID:" );
									String novoProduto = JOptionPane.showInputDialog("Digite o novo produto:" );
									String novaQuantidade = JOptionPane.showInputDialog("Digite a quantidade do novo produto:" );
									String novoPreco = JOptionPane.showInputDialog("Digite o preço do novo produto:" );
						
									//para adicionar os novos dados ocuparão os lugares dos antigos dados
									tabela.setValueAt(novoid, tabela.getSelectedRow(),0);
									tabela.setValueAt(novoProduto, tabela.getSelectedRow(),1);
									tabela.setValueAt(novaQuantidade, tabela.getSelectedRow(),2);
									tabela.setValueAt(novoPreco, tabela.getSelectedRow(),3);
									
										//mensagem de que os dados foram atualizados com sucesso
										JOptionPane.showMessageDialog(null, "Atualizado com sucesso", "Sucesso", JOptionPane.PLAIN_MESSAGE);
								}
					
					}
		});

	}

}
