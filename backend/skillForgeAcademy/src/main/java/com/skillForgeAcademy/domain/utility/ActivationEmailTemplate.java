package com.skillForgeAcademy.domain.utility;

public class ActivationEmailTemplate {

  public String getActivationEmailTemplate(
    String recipientName,
    String activationLink,
    String expirationHours
  ) {
    return """
                  Dear %s,
  
                  Thank you for registering for our service!
  
                  To activate your account, please click on the following link:
  
                  %s
  
                  This link will expire in %s hours.
  
                  If you have any questions, please do not hesitate to contact us.
  
                  Thank you,
  
                  Skill Forge Academy.
                  """.formatted(
        recipientName,
        activationLink,
        expirationHours
      );
  }
}
