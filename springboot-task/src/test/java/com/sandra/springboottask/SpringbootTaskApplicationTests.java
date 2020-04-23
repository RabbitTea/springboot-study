package com.sandra.springboottask;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
class SpringbootTaskApplicationTests {

	@Autowired
	JavaMailSenderImpl javaMailSender;

	/**
	 * 测试简单的邮件发送
	 */
	@Test
	void contextLoads() {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setSubject("Hello，Sandra");
		message.setText("好好学习，天天向上");

		message.setTo("354496262@qq.com");
		message.setFrom("354496262@qq.com");

		javaMailSender.send(message);
	}


	/**
	 * 测试复杂的邮件发送
	 */
	@Test
	void contextLoads2() throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();

		// 组装
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

		// 主题
		messageHelper.setSubject("独立思考");

		// 正文
		// html样式
		messageHelper.setText("<p style='color:red'>学会提问</p>", true);

		// 附件
		messageHelper.addAttachment("1.jpg", new File("/Users/yy/Downloads/1.jpg"));

		messageHelper.setTo("354496262@qq.com");
		messageHelper.setFrom("354496262@qq.com");

		javaMailSender.send(message);
	}

	/**
	 * 封装成一个方法
	 */
	public void sendMail(Boolean html, String subject, String text, String toPath, String fromPath) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();

		// 组装
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, html);

		// 主题
		messageHelper.setSubject(subject);

		// 正文
		// html样式
		messageHelper.setText(text, true);

		// 附件
		messageHelper.addAttachment("1.jpg", new File("/Users/yy/Downloads/1.jpg"));

		messageHelper.setTo(toPath);
		messageHelper.setFrom(fromPath);

		javaMailSender.send(message);
	}

}
