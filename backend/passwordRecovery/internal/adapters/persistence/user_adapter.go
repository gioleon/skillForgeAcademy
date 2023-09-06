package persistence

import (
	"database/sql"
	"passwordRecovery/internal/errors"
	"passwordRecovery/internal/model"
)

type UserAdapter struct {
	Tx *sql.Tx
}

func (u *UserAdapter) FindByEmail(email string) (*model.User, error) {
	user := &model.User{}

	sqlFindByEmailStatement := `
	    SELECT id, password, email FROM users
		WHERE email = $1
	`

	err := u.Tx.QueryRow(sqlFindByEmailStatement, email).Scan(&user.Id, &user.Password, &user.Email)
	if err != nil {
		if err == sql.ErrNoRows {
			return user, &errors.NoDataFound{Message: err}
		}
		return nil, err
	}

	return user, nil
}

func (u *UserAdapter) ChangePassword(id int, password string) error {
	sqlUpdateStatement := `
	    UPDATE users
	    SET password = $1
	    WHERE id = $2
    `

	_, err := u.Tx.Exec(sqlUpdateStatement, password, id)
	if err != nil {
		return &errors.UpdateRowError{Message: err}
	}

	return nil
}

func (u *UserAdapter) FindByToken(token string) (*model.User, error) {

	user := &model.User{}

	sqlFindStatement := `
	    SELECT u.id, u.password, u.email FROM users u
		INNER JOIN tokens_password_recovery t
		ON u.id = t.user_id 
	    WHERE t.token = $1
	`
	err := u.Tx.QueryRow(sqlFindStatement, token).Scan(&user.Id, &user.Password, &user.Email)
	if err != nil {
		return nil, &errors.NoDataFound{Message: err}
	}

	return user, nil
}
