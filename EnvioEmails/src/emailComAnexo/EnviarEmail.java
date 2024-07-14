package emailComAnexo;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class EnviarEmail {
	
	public static void main(String[] args) {
		
		
		Dados dados = new Dados();
		String meuEmail = dados.meuEmail;
		String minhaSenha = dados.minhaSenha;
		String destinatario = dados.destinatario;
		
		System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
		email.setSSLOnConnect(true); 
		
		EmailAttachment anexo = new EmailAttachment();
		anexo.setPath("/caminho/para/o/anexo.txt");
		anexo.setDisposition(EmailAttachment.ATTACHMENT);
		anexo.setDescription("Descrição do Anexo");
		anexo.setName("Nome do Anexo");
		
		try {
			email.setFrom(meuEmail);
			email.setSubject("Assunto");
			email.setMsg("Conteúdo do Email");
			email.addTo(destinatario);
			email.attach(anexo);
			email.send();
			
			System.out.println("Email enviado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
