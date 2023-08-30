package scripts

import "fmt"

func PasswordRecoveryEmailBody(email string, link string, minutes int) string {
	return fmt.Sprintf(`
	Dear user,

	We confirm that we have received your password recovery request,

	You can enter the following link and set a new password:

	%s

	This link will expire in %d minutes.

	If you have any questions, please do not hesitate to contact us.

	Thank you,

	Skill Forge Academy.
	
	`, link, minutes)
}
