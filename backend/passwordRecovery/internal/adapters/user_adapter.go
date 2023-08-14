package adapters

import (
	"database/sql"
	"passwordRecovery/internal/errors"
	"passwordRecovery/internal/model"
)

type UserAdapter struct{}

func (u *UserAdapter) FindByEmail(tx *sql.Tx, email string) (*model.User, error) {
	user := &model.User{}

	sqlFindByEmailStatement := `
	    SELECT id, password, email FROM users
		WHERE email = $1
	`

	err := tx.QueryRow(sqlFindByEmailStatement, email).Scan(&user.Id, &user.Password, &user.Email)
	if err != nil {
		if err == sql.ErrNoRows {
			return user, &errors.NoDataFound{Message: err}
		}
		return nil, err
	}

	return user, nil
}

func (u *UserAdapter) ChangePassword(tx *sql.Tx, id int, password string) error {
	sqlUpdateStatement := `
	    UPDATE users
	    SET password = $1
	    WHERE id = $2
    `

	_, err := tx.Exec(sqlUpdateStatement, password, id)
	if err != nil {
		return &errors.UpdateRowError{Message: err}
	}

	return nil
}
