package emailEmFormatoHTML;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;


public class EnviarEmailFormatoHTML {
	
	public static void main(String[] args) {
		
		
		Dados dados = new Dados();
		String meuEmail = dados.meuEmail;
		String minhaSenha = dados.minhaSenha;
		String destinatario = dados.destinatario;
		
		System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
		email.setSSLOnConnect(true); 
		
		StringBuilder htmlTexto = new StringBuilder();
        
        htmlTexto.append("<html>\n");
        htmlTexto.append("<head>\n");
        htmlTexto.append("<title>Exemplo de Tabela HTML</title>\n");
        htmlTexto.append("</head>\n");
        htmlTexto.append("<body>\n");
        htmlTexto.append("<table border=\"1\">\n");
        htmlTexto.append("<tr>\n");
        htmlTexto.append("<td>Coluna 1</td>\n");
        htmlTexto.append("<td>Coluna 2</td>\n");
        htmlTexto.append("<td>Coluna 3</td>\n");
        htmlTexto.append("</tr>\n");
        htmlTexto.append("<tr>\n");
        htmlTexto.append("<td>Linha 1</td>\n");
        htmlTexto.append("<td>Linha 1</td>\n");
        htmlTexto.append("<td>Linha 1</td>\n");
        htmlTexto.append("</tr>\n");
        htmlTexto.append("<tr>\n");
        htmlTexto.append("<td>Linha 2</td>\n");
        htmlTexto.append("<td>Linha 2</td>\n");
        htmlTexto.append("<td>Linha 2</td>\n");
        htmlTexto.append("</tr>\n");
        htmlTexto.append("<tr>\n");
        htmlTexto.append("<td>Linha 3</td>\n");
        htmlTexto.append("<td>Linha 3</td>\n");
        htmlTexto.append("<td>Linha 3</td>\n");
        htmlTexto.append("</tr>\n");
        htmlTexto.append("</table>\n");
        htmlTexto.append("</body>\n");
        htmlTexto.append("</html>");
		
		try {
			email.setFrom(meuEmail);
			email.setSubject("Assunto");
			email.setHtmlMsg(htmlTexto.toString());
			email.setTextMsg("Seu cliente de e-mail não suporta mensagens HTML"); // Mensagem Alternativa
			email.addTo(destinatario);
			email.send();
			
			System.out.println("Email enviado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
