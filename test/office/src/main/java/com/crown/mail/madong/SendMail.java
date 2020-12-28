package com.crown.mail.madong;

/**
 * @ClassName SendMail
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-11-02
 * @Time 13:33
 * @Version 1.0
 */
public class SendMail {

    public static void main(String[] args) {
        SendMail.send_163("textssssss");
    }

    //163邮箱
    public static void send_163(String content) {
        //这个类主要是设置邮件
        MailSenderInfo mailInfo=new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.mxhichina.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("info@hieureka.cn");//实际发送者
        mailInfo.setPassword("eureka@2016");//您的邮箱密码
        mailInfo.setFromAddress("info@hieureka.cn");//设置发送人邮箱地址
        mailInfo.setToAddress("info@hieureka.cn");
        mailInfo.setSubject("HIEUREKA.CN网站合作邮件");//设置邮箱标题
        mailInfo.setContent(content);//设置邮箱内容
        //这个类主要是用来发送邮件
        SimpleMailSender sms=new SimpleMailSender();
        sms.sendTextMail(mailInfo);//发送文本格式
        //sms.sendHtmlMail(mailInfo);//发送html格式:如果需要以html格式发送则需要处理好附件上传地址问题

    }
}
