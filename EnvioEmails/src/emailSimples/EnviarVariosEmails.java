package emailSimples;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

import java.util.ArrayList;

public class EnviarVariosEmails extends Dados {
	
	public static void main(String[] args) {
		
		Dados dados = new Dados();
		String meuEmail = dados.meuEmail;
		String minhaSenha = dados.minhaSenha;
		String destinatario = dados.destinatario;
		
		System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		
		ArrayList<String> mensagens = new ArrayList<>();
		
		for(int contador = 1; contador <= 10; contador++) {
			mensagens.add("Mensagem " + contador);
		}
		
		for (String mensagem : mensagens) {
            
			try {
                SimpleEmail email = new SimpleEmail();
                email.setHostName("smtp.gmail.com");
                email.setSmtpPort(465);
                email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
                email.setSSLOnConnect(true); 

                email.setFrom(meuEmail);
                email.setSubject("Assunto");
                email.setMsg(mensagem);
                email.addTo(destinatario);
                email.send();

                System.out.println("Email enviado: " + mensagem);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}

}

