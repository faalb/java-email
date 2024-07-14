package emailSimples;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class EnviarEmail {
	
	public static void main(String[] args) {
		
		
		Dados dados = new Dados();
		String meuEmail = dados.meuEmail;
		String minhaSenha = dados.minhaSenha;
		String destinatario = dados.destinatario;
		
		System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
		email.setSSLOnConnect(true); 
		
		try {
			email.setFrom(meuEmail);
			email.setSubject("Assunto");
			email.setMsg("Conteúdo do Email");
			email.addTo(destinatario);
			email.send();
			
			System.out.println("Email enviado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
