//package Management.User.service;
//
//
//import Management.User.constant.Messagecodes;
//import Management.User.dto.MailResponse;
//import Management.User.dto.Schooldto;
//import Management.User.io.BaseResponse;
//import Management.User.io.StatusMessage;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.Map;
//
//@Service
//public class EmailService {
//    @Autowired
//    private JavaMailSender sender;
//
//    @Autowired
//    private Configuration config;
//
//    public BaseResponse sendEmail(Schooldto request, Map<String, Object> model) throws  Exception{
//        MailResponse response = new MailResponse();
//        MimeMessage message = sender.createMimeMessage();
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
//                    StandardCharsets.UTF_8.name());
//            Template t = config.getTemplate("email-template.ftl");
//            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
//            helper.setTo(request.getEmailid());
//            helper.setText(html, true);
//            helper.setSubject("Reset Password");
//            sender.send(message);
//            response.setMessage("Mail send to : " + request.getEmailid());
//
//        } catch (IOException | TemplateException | MessagingException e) {
//            response.setMessage("Mail Sending failure : "+e.getMessage());
//        }
//
//        return BaseResponse.builder()
//                .status(Messagecodes.SUCCESS)
//                .statusMessage(StatusMessage.builder()
//                        .code(Messagecodes.SUCCESS)
//                        .description(Messagecodes.EMAIL)
//                        .build())
//                .data(response)
//                .build();
//    }
//
//
//}
