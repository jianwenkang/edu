package com.crown.mail.simple;

import cn.hutool.core.date.DateUtil;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @ClassName TestMail
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-11-02
 * @Time 13:51
 * @Version 1.0
 */
public class TestMail {

    public static void main(String[] args) {
        //PPANGXCXCHKAHDFP
        String today = DateUtil.today();
        String format = DateUtil.format(new Date(), "HH:mm:ss");
        String str = "<div><span> 尊敬的管理员您好：</span></div>" +
                "<div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 系统在<span style='border-bottom:1px dashed #ccc;'>"+today+"</span> "+ format +" 接收到系统***事件告警，IP地址段：192.168.1.10 威胁等级：高 &nbsp;请您及时处理。</div>" +
                "<div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 系统在<span style='border-bottom:1px dashed #ccc;'>"+today+"</span> "+ format +" 接收到系统***事件告警，IP地址段：192.168.1.10 威胁等级：高 &nbsp;请您及时处理。</div>" +
                "<div style='font-size: 16px;font-weight:bold; width:100%; white-space: nowrap; overflow:hidden;text-overflow: ellipsis;'>博雅网络安全威胁感知服务平台</div>" +
                "<div style='width: 100%;font-size: 14px !important;word-wrap:break-word;word-break:break-all;'>发件人：m15001138902@163.com</div>" +
                "<div style='width: 100%;font-size: 14px !important;word-wrap:break-word;word-break:break-all;'>电话：15001138902</div>";
        boolean result = TestMail.sendMail("15001138902@163.com", str);
        System.out.println(result);
    }

    public static boolean sendMail(String emailAddress, String emailMsg) {

        // 谁发送(发送方)
        String from = "lenovof518@163.com";

        // 发给谁
        String to = emailAddress;

        // 发送者的用户名和密码(邮箱登录用)
        final String username = "lenovof518@163.com"; // 此处填写发送的邮箱名
        final String password = "PPANGXCXCHKAHDFP"; // 此处填写登录的邮箱密码

        // 定义properties对象，设置环境信息
        Properties properties = new Properties();

        /*
         * mail.smtp.host ：指定连接的邮件服务器的主机名。如：163邮箱就填写smtp.163.com
         * 若在本地测试的话，需要在本地安装smtp服务器
         */
        properties.setProperty("mail.smtp.host", "smtp.163.com");

        // mail.smtp.auth：指定客户端是否要向邮件服务器提交验证
        properties.setProperty("mail.smtp.auth", "true");

        /*
         * mail.transport.protocol：指定邮件发送协议：smtp。smtp：发邮件；pop3：收邮件
         * mail.store.protocol:指定邮件接收协议
         */
        properties.setProperty("mail.transport.protocol", "smtp");

        // 获取session对象
        Session session = Session.getInstance(properties);

        // 当设置为true，JavaMail AP就会将其运行过程和邮件服务器的交互命令信息输出到console中，用于JavaMail的调试
        session.setDebug(true);
        try {

            // 创建邮件对象
            MimeMessage message = new MimeMessage(session);

            // 设置邮件发送方
            message.setFrom(new InternetAddress(from));

            // 设置邮件发送的主题<邮件标题>
            message.setSubject("主题");

            // 设置邮件发送的内容
            message.setContent(emailMsg,"text/html;charset=utf-8");
            Transport transport=session.getTransport();

            // 连接邮件服务器，“”中填写邮件服务器主机名
            transport.connect("smtp.163.com",25, username, password);
            transport.sendMessage(message,new Address[]{new InternetAddress(to)});
            transport.close();
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

}
