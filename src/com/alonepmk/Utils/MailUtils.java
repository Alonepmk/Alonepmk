package com.alonepmk.Utils;

import com.alonepmk.Model.Account;
import java.io.PrintStream;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailUtils
{

    public MailUtils()
    {
    }

    public static void sendMailConfirmCode(Account account, MailSender mailSender)
    {
        try
        {
            SimpleMailMessage emailObj = new SimpleMailMessage();
            emailObj.setTo(account.getEmail());
            System.out.println(account.getEmail());
            System.out.println(account.getEmailConfirmCode());
            emailObj.setSubject("Confirmation code to Alonepmk portal");
            emailObj.setText((new StringBuilder("Here is your Confirm Code : ")).append(account.getEmailConfirmCode()).toString());
            mailSender.send(emailObj);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
