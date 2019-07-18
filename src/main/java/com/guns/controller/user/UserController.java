package com.guns.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guns.enums.RoleEnum;
import com.guns.model.admin.user.Role;
import com.guns.model.admin.user.User;
import com.guns.spring.service.user.RoleService;
import com.guns.spring.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.UUID;


/**
 * Created by Damian on 28-Nov-15.
 */

@RestController
@RequestMapping(value = "api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User user() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();

        if (auth.getPrincipal() instanceof String)
            return null;
        else {
            return (User) auth.getPrincipal();
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<User> getEmployees() {
        return userService.findAllEmployees();
    }

    @RequestMapping(value = "/admins", method = RequestMethod.GET)
    public List<User> getAdmins() {
        return userService.findAllAdmins();
    }

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    public User getByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @RequestMapping(value = "/users/{username}", method = RequestMethod.POST)
    public User create(@PathVariable String username, @RequestBody @Validated User user) throws Exception {
        HashSet<Role> roleHashSet = new HashSet<Role>();
        Role role = roleService.findByName(RoleEnum.user.toString());

        if (role != null) {
            String activationToken = user.getUsername() + user.getEmail() + UUID.randomUUID();
            byte[] bytesOfToken = activationToken.getBytes("UTF-8");

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encryptedBytesOfToken = md.digest(bytesOfToken);

            activationToken = encryptedBytesOfToken.toString();
            user.setActivated(false);
            user.setEnabled(false);
            user.setActivationToken(activationToken);

            roleHashSet.add(role);

            user.setRoles(roleHashSet);
            User response = userService.create(user);

            Properties props = new Properties();
            props.put("mail.smtp.user", "guns3.inz4@gmail.com");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.debug", "true");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            SecurityManager security = System.getSecurityManager();

            try {
                Authenticator auth = new SMTPAuthenticator();
                Session session = Session.getInstance(props, auth);
                session.setDebug(true);     //for debug only
                MimeMessage msg = new MimeMessage(session);

                String emailActivationLink = "http://localhost:8080/activate/";
                emailActivationLink += activationToken;

                String messageContent = "Dear <i>%s</i>,<br />" +
                        "In order to complete your registration and activate your account click on the following link: <a href=%s>%s</a>.<br />" +
                        "Sincerely,<br />" +
                        "<i>Damian Rutkowski</i> <br/>";
                messageContent = String.format(messageContent, user.getUsername(), emailActivationLink, emailActivationLink);

                msg.setText(messageContent, "UTF-8", "html");
                msg.setSubject("Confirmation e-mail");
                               
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress("email_address_here"));

                Transport.send(msg);
            } catch (Exception mex) {
                mex.printStackTrace();
            }

            return response;
        }

        return null;
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("email_address_here", "password_here");
        }
    }

    @RequestMapping(value = "/users/{username}", method = RequestMethod.PUT)
    public User update(@PathVariable String username, @RequestBody @Validated User user) {        
        try {            
            if (user.getPassword() == null) {
                user.setPassword(userService.findByUsername(username).getPassword());
            }

            return userService.create(user);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }

    @RequestMapping(value = "/users/{username}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String username) {
        User user = userService.findByUsername(username);

        userService.delete(user);
    }

    @RequestMapping(value = "/activate/{token}", method = RequestMethod.GET)
    public String activateUser(@PathVariable String token) {
        User user = userService.findByActivationToken(token);

        if(user != null && !user.getActivated())
        {
            user.setEnabled(true);
            user.setActivationToken(null);

            userService.create(user);

            return "Activation completed successfully.";
        }
        else
        {
            return "Token incorrect or e-mail address is already confirmed.";
        }
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
