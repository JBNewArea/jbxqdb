package com.numberONe.util;

import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.numberONe.task.SpringTaskController;



/**
 * 简单的邮件发送
 * 
 * @author Administrator
 * 
 */
public class EmailUtils {

	public static void main(String[] args) throws Exception {
//		Properties prop = new Properties();
//		InputStream in = SpringTaskController.class.getResourceAsStream("/config.properties");
//		prop.load(in);
//		EmailUtils.sendMail("127.0.0.1", "13813800804@163.com", "13813800804@163.com", "jbxqdbxt123456", "１１１１１１１１", "１１１１１１１");
		
		
		
		
		
		
		
		EmailUtils operation = new EmailUtils();
//        String user = "你的邮箱地址";
//        String password = "你的邮箱授权码";
//        String host = "smtp.163.com";
//        String from = "你的邮箱地址";
//        String to = "目标邮箱地址";// 收件人
//        String subject = "输入邮件主题";
		
		String user = "13813800804@163.com";
        String password = "jbxqdbxt123456";
        String host = "smtp.163.com";
        String from = "13813800804@163.com";
        String to = "1423611082@qq.com";// 收件人
        String subject = "测试";
        
        //邮箱内容
        StringBuffer sb = new StringBuffer();
        String yzm = "1212";
        sb.append("<!DOCTYPE>"+"<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>温馨提示：</span>"
                          + "<div style='width:950px;font-family:arial;'>欢迎使用NET微活动，您的注册码为：<br/><h2 style='color:green'>"+yzm+"</h2><br/>本邮件由系统自动发出，请勿回复。<br/>感谢您的使用。<br/>杭州恩意替电子商务有限公司</div>"
                         +"</div>");
        try {
            String res = operation.sendMail2(user, password, host, from, to,
                    subject, sb.toString());
            System.out.println(res);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	/**
	 * 发送邮件　(暂时只支持163邮箱发送)
	 * @param fromEmail　发送邮箱
	 * @param toEmail　接收邮箱
	 * @param emailName　163邮箱登录名
	 * @param emailPassword　密码
	 * @param title　发送主题
	 * @param centent　发送内容
	 * @throws Exception
	 */
	public static void sendMail(String fromEmail,String toEmail,String emailName,String emailPassword,String title, String centent) throws Exception {
		
		Properties properties = new Properties();// 创建Properties对象
		properties.setProperty("mail.transport.protocol", "smtp");// 设置传输协议
		properties.put("mail.smtp.host", "smtp.163.com");// 设置发信邮箱的smtp地址
		properties.setProperty("mail.smtp.auth", "true"); // 验证
		Authenticator auth = new AjavaAuthenticator(emailName,
				emailPassword); // 使用验证，创建一个Authenticator
		Session session = Session.getDefaultInstance(properties, auth);// 根据Properties，Authenticator创建Session
		Message message = new MimeMessage(session);// Message存储发送的电子邮件信息
		message.setFrom(new InternetAddress(fromEmail));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(
				toEmail));// 设置收信邮箱
		// 指定邮箱内容及ContentType和编码方式
		message.setContent(centent, "text/html;charset=utf-8");
		message.setSubject(title);// 设置主题
		message.setSentDate(new Date());// 设置发信时间
		Transport.send(message);// 发送

	}
	
	
	
	/**
	 * 发送邮件
	 * @param user 发件人邮箱
	 * @param password 授权码（注意不是邮箱登录密码）
	 * @param host 
	 * @param from 发件人
	 * @param to 接收者邮箱
	 * @param subject 邮件主题
	 * @param content 邮件内容
	 * @return success 发送成功 failure 发送失败
	 * @throws Exception
	 */
	public static String sendMail2(String emailName, String emailPassword, String host,
	        String from, String to, String title, String content)
	        throws Exception {
	    if (to != null){
	        Properties props = System.getProperties();
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.auth", "true");
//	        MailAuthenticator auth = new MailAuthenticator();
//	        MailAuthenticator.USERNAME = user;
//	        MailAuthenticator.PASSWORD = password;
	        Authenticator auth = new AjavaAuthenticator(emailName,
					emailPassword); // 使用验证，创建一个Authenticator
	        Session session = Session.getInstance(props, auth);
	        session.setDebug(true);
	        try {
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(from));
	            if (!to.trim().equals(""))
	                message.addRecipient(Message.RecipientType.TO,
	                        new InternetAddress(to.trim()));
	            message.setSubject(title);
	            MimeBodyPart mbp1 = new MimeBodyPart(); // 正文
	            mbp1.setContent(content, "text/html;charset=utf-8");
	            Multipart mp = new MimeMultipart(); // 整个邮件：正文+附件
	            mp.addBodyPart(mbp1);
	            // mp.addBodyPart(mbp2);
	            message.setContent(mp);
	            message.setSentDate(new Date());
	            message.saveChanges();
	            Transport trans = session.getTransport("smtp");
	            trans.send(message);
	            System.out.println(message.toString());
	        } catch (Exception e){
	            e.printStackTrace();
	            return "failure";
	        }
	        return "success";
	    }else{            
	        return "failure";
	    }
	}

}



// 创建传入身份验证信息的 Authenticator类
class AjavaAuthenticator extends Authenticator {
	private String user;
	private String pwd;

	public AjavaAuthenticator(String user, String pwd) {
		this.user = user;
		this.pwd = pwd;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, pwd);
	}
}