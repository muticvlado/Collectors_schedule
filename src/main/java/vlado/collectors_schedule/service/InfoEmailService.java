package vlado.collectors_schedule.service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import vlado.collectors_schedule.entity.GameItem;

@Service
public class InfoEmailService {
	
	@Autowired
	private JavaMailSender sender;
	
	public void send(GameItem item) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("mutic.vlado@gmail.com");
		message.setTo(item.getCollector().getEmail());		
		message.setSubject("49ing New Game");		
		
		message.setText(item.toString());
		
		sender.send(message);
	}
	
	public void sendHtmlEmail(GameItem item) throws MessagingException {
		
		MimeMessage message = sender.createMimeMessage();

	    message.setFrom(new InternetAddress("mutic.vlado@gmail.com"));
	    message.setRecipients(MimeMessage.RecipientType.TO, item.getCollector().getEmail());
	    message.setSubject("49ing New Game");

	    String htmlContent = item.toString();
	    message.setContent(htmlContent, "text/html; charset=utf-8");

	    sender.send(message);
	}
}
