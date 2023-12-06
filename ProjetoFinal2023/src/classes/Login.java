package classes;

public class Login {

	private String senha;
	private String login;

	public Login(String login, String senha) {
	
		this.login = login;
		this.senha = senha;
	
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
	

























/*
 * private String senha; private String login; private boolean cargo; private
 * ArrayList<UsuarioStaff> ListaUsuarioLogin = new ArrayList<>();
 * 
 * public UsuarioStaff(String nome, String email, String senha, String login,
 * boolean cargo) { super(nome, email); this.senha = senha; this.login = login;
 * }
 * 
 * public String getSenha() { return senha; }
 * 
 * public void setSenha(String senha) { this.senha = senha; }
 * 
 * public String getLogin() { return login; }
 * 
 * public void setLogin(String login) { this.login = login; }
 * 
 * public ArrayList<UsuarioStaff> getListaUsuarioLogin() { return
 * ListaUsuarioLogin; }
 * 
 * public void setListaUsuarioLogin(ArrayList<UsuarioStaff> listaUsuarioLogin) {
 * ListaUsuarioLogin = listaUsuarioLogin; }
 * 
 * // MÉTODO ABAIXO PARA DEFINIR LOGIN PADRÃO
 * 
 * public void CargosPredefinidos() { // Crio instâncias já pré-definidas
 * 
 * UsuarioStaff usuarioadmin = new UsuarioStaff("Admin", "admin@gmail.com",
 * "1234", "admin", true); UsuarioStaff usuariovendedor = new
 * UsuarioStaff("Vendedor", "vendedor@gmail.com", "12345", "vendedor", false);
 * 
 * // Adiciono os objetos (instâncias) à lista ListaUsuarioLogin
 * 
 * ListaUsuarioLogin.add(usuarioadmin); ListaUsuarioLogin.add(usuariovendedor);
 * }
 * 
 * // MÉTODO ABAIXO PARA CRIAR USUÁRIO PARA ADMINISTRAR O SISTEMA
 * 
 * public void CriarUsuario() { Scanner scanner = new Scanner(System.in);
 * 
 * while (true) { System.out.print("Nome do Usuário (ou 'sair' para sair): ");
 * String nome = scanner.nextLine(); if (nome.equalsIgnoreCase("sair")) { break;
 * } System.out.print("Email: "); String email = scanner.nextLine();
 * System.out.print("Senha: "); String senha = scanner.nextLine();
 * System.out.print("Informe o usuário para login: "); String login =
 * scanner.nextLine();
 * 
 * // Coloquei a validação de dados abaixo
 * 
 * System.out.
 * println("Digite o nível do cargo da pessoa: 1 para admin e 0 para funcionário"
 * );
 * 
 * int cargoid = Integer.parseInt(scanner.nextLine()); // Leitura como linha e
 * conversão boolean cargo = (cargoid == 1);
 * 
 * UsuarioStaff usuariologin = new UsuarioStaff(nome, email, senha, login,
 * cargo); ListaUsuarioLogin.add(usuariologin);
 * System.out.println("Usuário criado com sucesso!"); } scanner.close(); }
 * 
 * public void VerificarUsuarios() {
 * System.out.println("====================="); System.out.println("Usuários:");
 * if (ListaUsuarioLogin.isEmpty()) {
 * System.out.println("Nenhum usuário cadastrado."); } else { for (UsuarioStaff
 * usuariologin : ListaUsuarioLogin) { System.out.println("ID: " +
 * usuariologin.getId() + " , Nome: " + usuariologin.getNome()); } } }
 * 
 * public void AtualizarUsuario() { Scanner scanner = new Scanner(System.in);
 * System.out.print("Digite o ID do usuário que deseja atualizar: "); int id =
 * scanner.nextInt(); scanner.nextLine(); // Consumir a nova linha boolean
 * encontrado = false;
 * 
 * for (UsuarioStaff usuariologin : ListaUsuarioLogin) { if
 * (usuariologin.getId() == id) { System.out.print("Novo nome: "); String
 * novoNome = scanner.nextLine(); usuariologin.setNome(novoNome);
 * System.out.println("Usuário atualizado com sucesso."); encontrado = true;
 * break; } }
 * 
 * if (!encontrado) {
 * System.out.println("Usuário com o ID especificado não encontrado."); }
 * scanner.close(); }
 * 
 * public void DeletarUsuario() { Scanner scanner = new Scanner(System.in);
 * 
 * if (cargo == true) {
 * System.out.print("Digite o ID do Usuário que deseja deletar: "); int id =
 * scanner.nextInt(); boolean removido = false; for (UsuarioStaff usuariologin :
 * ListaUsuarioLogin) { if (usuariologin.getId() == id) {
 * ListaUsuarioLogin.remove(usuariologin);
 * System.out.println("Usuário deletado com sucesso!"); removido = true; break;
 * } if (!removido) {
 * System.out.println("Usuário com o ID especificado não encontrado."); } }
 * System.out.println("Usuário com o ID especificado não encontrado.");
 * 
 * } System.out.println("Você não tem permissão!");
 * 
 * scanner.close(); }
 * 
 * // MÉTODO ABAIXO PARA A RECUPERAÇÃO DE EMAIL public void RecuperarEmail() {
 * // Configurações do servidor SMTP do Gmail String host = "smtp.gmail.com";
 * int porta = 587; String usuariorecuperacao; final String usuarioemail =
 * "adsuniceplac@gmail.com"; // significa que a variável não pode ser alterada,
 * , se // publicar alterar a senha final String senhaemail =
 * "pdikuwyojbmfkbll"; // significa que a variável não pode ser alterada, se
 * publicar // alterar a // senha
 * 
 * // Configurações da propriedade Properties propriedades = new Properties();
 * propriedades.put("mail.smtp.auth", "true");
 * propriedades.put("mail.smtp.starttls.enable", "true");
 * propriedades.put("mail.smtp.host", host); propriedades.put("mail.smtp.port",
 * porta);
 * 
 * // Crie uma instância do Authenticator para autenticar Authenticator
 * autenticador = new Authenticator() { protected PasswordAuthentication
 * getPasswordAuthentication() { return new PasswordAuthentication(usuarioemail,
 * senhaemail); } };
 * 
 * // Crie uma sessão com as configurações e o Authenticator Session sessao =
 * Session.getInstance(propriedades, autenticador);
 * 
 * Scanner scanner = new Scanner(System.in);
 * System.out.println("Vamos recupear a sua senha:");
 * System.out.println("Informe seu usuário:"); usuariorecuperacao =
 * scanner.nextLine();
 * 
 * if (usuariorecuperacao.equalsIgnoreCase("admin") ||
 * usuariorecuperacao.equalsIgnoreCase("vendedor")) { // se usuário digitar os
 * usuários validos
 * 
 * if (usuariorecuperacao.equalsIgnoreCase("admin")) {
 * System.out.println("Informe seu email:"); String emailrecuperacao =
 * scanner.nextLine(); // scanner.close(); se eu fechar esse scanner o programa
 * da erro try { // Crie uma mensagem de email Message mensagem = new
 * MimeMessage(sessao); mensagem.setFrom(new InternetAddress(usuarioemail));
 * mensagem.setRecipients(Message.RecipientType.TO,
 * InternetAddress.parse(emailrecuperacao));
 * mensagem.setSubject("Senha para recuperação:");
 * mensagem.setText("A senha para recuperação é: 1234");
 * 
 * // Envie a mensagem Transport.send(mensagem);
 * 
 * System.out.println("Email enviado com sucesso!");
 * 
 * } catch (MessagingException e) { e.printStackTrace();
 * System.err.println("Erro ao enviar o email."); } } else {
 * System.out.println("Informe seu email:"); String emailrecuperacao =
 * scanner.nextLine(); // scanner.close(); se eu fechar esse scanner o programa
 * da erro try { // Crie uma mensagem de email Message mensagem = new
 * MimeMessage(sessao); mensagem.setFrom(new InternetAddress(usuarioemail));
 * mensagem.setRecipients(Message.RecipientType.TO,
 * InternetAddress.parse(emailrecuperacao));
 * mensagem.setSubject("Senha para recuperação:");
 * mensagem.setText("A senha para recuperação é: 1234");
 * 
 * // Envie a mensagem Transport.send(mensagem);
 * 
 * System.out.println("Email enviado com sucesso!");
 * 
 * } catch (MessagingException e) { e.printStackTrace();
 * System.err.println("Erro ao enviar o email."); } }
 * 
 * } else { System.out.println("Usuário não encontrado!");
 * 
 * } } }
 */
