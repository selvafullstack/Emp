package org.orgw.simples.controller.test;





import org.apache.log4j.Logger;
import org.orgw.simples.controller.BaseController;
import org.orgw.simples.core.exception.BaseException;
import org.orgw.simples.data.LeaveRequest;
import org.orgw.simples.data.Response;
import org.orgw.simples.service.ILeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailRestController  extends BaseController {

	private final Logger log = Logger.getLogger(getClass());
	

	@Autowired
	ILeaveService leaveservice;
	
	
	
	
	 @RequestMapping(path="/user/leaverequest",method= {RequestMethod.GET,RequestMethod.POST})
	 public Response leaveRequest(@RequestBody LeaveRequest request) throws BaseException {
		 
		 
		 
		 
		 
		 return response(leaveservice.leaverequest(request));
		 
	 }


	 
	 
	  


	@Override
	protected String getServiceCode() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 
	 * @RequestMapping(path="/form/sendMail",method= {RequestMethod.GET,
	 * RequestMethod.POST}) public String sendMail(String from, String to, String
	 * cc,String subject,String content) {
	 * 
	 * 
	 * 
	 * 
	 * String host = "localhost";
	 * 
	 * // Get system properties Properties properties = System.getProperties();
	 * 
	 * // Setup mail server properties.setProperty("mail.smtp.host", host);
	 * 
	 * // Get the default Session object. Session session =
	 * Session.getDefaultInstance(properties); try { MimeMessage message = new
	 * MimeMessage(session);
	 * 
	 * from="ragini.orgware@gmail.com"; to="ragavanm.orgware@gmail.com";
	 * cc="venkatesh.orgware@gmail.com"; subject="Sick Leave"; content="TEST";
	 * message.setFrom(new InternetAddress(from));
	 * message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	 * message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
	 * message.setText(content); message.setSubject(subject);
	 * Transport.send(message); return "Mail Sent Successfully!"; } catch
	 * (MessagingException e) { e.printStackTrace(); return
	 * "Error while sending mail .."; }
	 * 
	 * 
	 * 
	 * to = "ragavanm.orgware@gmail.com";
	 * 
	 * // Sender's email ID needs to be mentioned from = "ragini.orgware@gmail.com";
	 * final String username = "selva.orgware@gmail.com";//change accordingly final
	 * String password = "8903531780";//change accordingly
	 * 
	 * // Assuming you are sending email through relay.jangosmtp.net String host =
	 * "smtp.gmail.com";
	 * 
	 * Properties props = new Properties(); props.put("mail.smtp.auth", "true");
	 * props.put("mail.smtp.starttls.enable", "true"); props.put("mail.smtp.host",
	 * host); props.put("mail.smtp.port", "25");
	 * 
	 * // Get the Session object. Session session = Session.getInstance(props, new
	 * javax.mail.Authenticator() { protected PasswordAuthentication
	 * getPasswordAuthentication() { return new PasswordAuthentication(username,
	 * password); } }); try{MimeMessage msg = new MimeMessage(session); //set
	 * message headers msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	 * msg.addHeader("format", "flowed"); msg.addHeader("Content-Transfer-Encoding",
	 * "8bit");
	 * 
	 * msg.setFrom(new InternetAddress(from, "NoReply-JD"));
	 * 
	 * msg.setReplyTo(InternetAddress.parse(from, false));
	 * msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,
	 * false));
	 * 
	 * msg.setSubject(subject, "UTF-8");
	 * 
	 * BodyPart messageBodyPart = new MimeBodyPart();
	 * messageBodyPart.setText("TEST");
	 * 
	 * Multipart multiPart = new MimeMultipart();
	 * 
	 * multiPart.addBodyPart(messageBodyPart);
	 * 
	 * messageBodyPart = new MimeBodyPart();
	 * 
	 * messageBodyPart.setContent("","text/html");
	 * multiPart.addBodyPart(messageBodyPart); msg.setContent(multiPart);
	 * 
	 * // msg.setText("Sample", "UTF-8");
	 * 
	 * 
	 * System.out.println("Message is ready");
	 * 
	 * 
	 * Transport.send(msg); return "Message is ready"; }catch(Exception e) {
	 * 
	 * 
	 * return "Error"; }
	 * 
	 * 
	 * }
	 * 
	 */

}
