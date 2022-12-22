package co.edu.ubosque.model;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class TeEmplea {
	
	private ResourceBundle rs;
	private String correoremitente;
	private String pasremitente;

	public TeEmplea() {
		
		rs 				= ResourceBundle.getBundle("config");
		correoremitente = rs.getString("correo");
		pasremitente 	= rs.getString("contrasenaCorreo");
		
	}
	
	
	public void enviarCorreo(Usuario u) {

		try {

			// creamos y rellenamos la variable propieties
			Properties prop = new Properties();

			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.setProperty("mail.smtp.starttls.enable", "true");
			prop.setProperty("mail.smtp.port", "587");
			prop.setProperty("mail.smtp.auth", "true");

			// creamos una instancia de para abrir la sesion
			Session sesion = Session.getDefaultInstance(prop);
			// Datos para enviar
			//String correoremitente = "proyecteemplea@gmail.com";
			//String pasremitente = "Asd123.-";
			
			
			String asunto = "TE EMPLEA GRACIAS POR REGISTRARTE";
			String mensaje = "Gracias por confiar en nosotros "
					+ u.getIdentificacion()
					+ " ahora puedes empezar a disfrutar de nuestros servicios: "
					+ "\n"
					+ "\n"
					+ "usuario: "
					+ u.getIdentificacion()
					+ "\nContraseña: "
					+ u.getContrasena()
					+ "\n"
					+ "\n"
					+ "En caso de no haberlo solicitado, ponte en contacto con nosotros inmediatamente.";

			// CONSTRUIMOS EL CUERPO DEL CORREO
			BodyPart texto = new MimeBodyPart();
			texto.setText(mensaje);
			// CONSTRUIMOS EL ADJUNTO
			BodyPart adjunto = new MimeBodyPart();
			// adjunto.setDataHandler(new DataHandler(new
			// FileDataSource("./src/co/edu/unbosque/imagenes/correo.jpg")));
			//adjunto.setFileName("CONTACTO");

			// Una MultiParte para agrupar texto e imagen.
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			//multiParte.addBodyPart(adjunto);

			// CONSTRUIMOS EL CORREO
			MimeMessage mensajesesion = new MimeMessage(sesion);
			// INDICAMOS EL CORREO DESDE DONDE SE ENVIA
			mensajesesion.setFrom(new InternetAddress(correoremitente));
			// INDICAMOS EL CORREO QUE RECIBE
			mensajesesion.addRecipient(Message.RecipientType.TO, new InternetAddress(u.getCorreo()));
			// INDICAMOS EL ASUNTO
			mensajesesion.setSubject(asunto);
			// INDICAMOS EL CUERPO DEL CORREO
			mensajesesion.setContent(multiParte);
			// CREAMOS INSTANCIA TRANSPORT ENCARGADA DEL ENVIO DEL CORREO
			Transport t = sesion.getTransport("smtp");
			t.connect(correoremitente, pasremitente);
			t.sendMessage(mensajesesion, mensajesesion.getAllRecipients());
			t.close();

		} catch (AddressException e) {
			System.out.println("Correo vacio");
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
	
	
	

}
