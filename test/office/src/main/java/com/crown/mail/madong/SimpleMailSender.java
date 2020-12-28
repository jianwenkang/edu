package com.crown.mail.madong;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
/**
 * @ClassName SimpleMailSender
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-11-02
 * @Time 13:33
 * @Version 1.0
 */
public class SimpleMailSender {
    /**
     * 以文本格式发送邮件
     *   @param mailInfo
     *   代发送的邮件的信息
     */

    public boolean sendTextMail(MailSenderInfo mailInfo){
        //判断是否需要身份认证
        MyAuthenticator authenticator=null;
        Properties pro=mailInfo.getProperties();
        if(mailInfo.isValidate()){
            //如果需要身份认证；则创建一个密码验证器
            authenticator=new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        //根据邮件会话属性和密码验证器构造一个邮件发送的session
        Session sendMailSession=Session.getDefaultInstance(pro, authenticator);
        try {
            //    根据session 创建一个邮件消息
            Message mailMessage=new MimeMessage(sendMailSession);
            //创建邮件发送者地址
            Address from =new InternetAddress(mailInfo.getFromAddress());
            //设置邮件消息的发送者
            mailMessage.setFrom(from);
            //创建邮件的接受者地址；并设置到邮件消息中
            Address to=new InternetAddress(mailInfo.getToAddress());
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            //设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            //设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            //设置邮件消息的主要内容
            String mailContent =mailInfo.getContent();
            mailMessage.setText(mailContent);
            //发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
