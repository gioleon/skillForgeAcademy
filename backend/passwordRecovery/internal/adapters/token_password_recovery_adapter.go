package adapters

import (
	"database/sql"
	"passwordRecovery/internal/errors"
	"passwordRecovery/internal/model"
	"passwordRecovery/internal/utils"
	"time"
)

type TokenAdapter struct{}

func (token *TokenAdapter) CreateToken(tx *sql.Tx, t *model.TokenPasswordRecovery) (int, error) {
	id := -1

	sqlInsertStatement := `
	    INSERT INTO tokens_password_recovery (confirmed_at, created_at, expired_at, token, user_id)
	    VALUES  ($1, $2, $3, $4, $5)
		RETURNING id
	`
	err := tx.QueryRow(sqlInsertStatement, t.ConfirmedAt, t.CreatedAt, t.ExpiredAt, t.Token, t.UserId).Scan(&id)
	if err != nil {
		return id, &errors.InsertionError{Message: err}
	}

	return id, err
}

func (token *TokenAdapter) DeleteTokenById(tx *sql.Tx, tokenId int) (int, error) {
	id := -1

	sqlDeleteStatement := `
	    DELETE FROM tokens_password_recovery
		WHERE id = $1
		RETURNING id
	`
	err := tx.QueryRow(sqlDeleteStatement, tokenId).Scan(&id)
	if err != nil {
		return id, &errors.DeleteError{Message: err}
	}

	return id, err
}

func (token *TokenAdapter) FindTokenById(tx *sql.Tx, tokenId int) (*model.TokenPasswordRecovery, error) {
	foundToken := &model.TokenPasswordRecovery{}

	sqlFindStatement := `
	    SELECT * FROM tokens_password_recovery
		WHERE id = $1
	`

	err := tx.QueryRow(sqlFindStatement, tokenId).Scan(&foundToken.Id, &foundToken.ConfirmedAt, &foundToken.CreatedAt, &foundToken.ExpiredAt, &foundToken.Token, &foundToken.UserId)

	if err != nil {
		return foundToken, &errors.NoDataFound{Message: err}
	}

	return foundToken, err
}

func (token *TokenAdapter) FindAll() ([]*model.TokenPasswordRecovery, error) {

	db := utils.GetDatabaseConnection()
	defer db.Close()

	tokens := make([]*model.TokenPasswordRecovery, 0)

	sqlFindAllStatement := `
	    SELECT * FROM tokens_password_recovery
	`

	rows, err := db.Query(sqlFindAllStatement)
	if err != nil {
		return tokens, &errors.NoDataFound{Message: err}
	}

	defer rows.Close()

	for rows.Next() {
		var token model.TokenPasswordRecovery

		err = rows.Scan(
			&token.Id, &token.ConfirmedAt,
			&token.CreatedAt, &token.ExpiredAt,
			&token.Token, &token.UserId)
		if err != nil {
			return tokens, &errors.ScanError{Message: err}
		}

		tokens = append(tokens, &token)
	}

	return tokens, nil

}

func (t *TokenAdapter) FindTokenByToken(tx *sql.Tx, token string) (*model.TokenPasswordRecovery, error) {
	foundToken := &model.TokenPasswordRecovery{}

	sqlFindStatement := `
	    SELECT * FROM tokens_password_recovery
		WHERE token = $1
	`

	err := tx.QueryRow(sqlFindStatement, token).Scan(&foundToken.Id, &foundToken.ConfirmedAt, &foundToken.CreatedAt, &foundToken.ExpiredAt, &foundToken.Token, &foundToken.UserId)

	if err != nil {
		return foundToken, &errors.NoDataFound{Message: err}
	}

	return foundToken, err
}

func (t *TokenAdapter) ConfirmToken(tx *sql.Tx, token string) error {
	sqlUpdateStatement := `
	    UPDATE tokens_password_recovery
		SET confirmed_at = $1
		WHERE token = $2
	`

	_, err := tx.Exec(sqlUpdateStatement, time.Now(), token)
	if err != nil {
		return &errors.UpdateRowError{Message: err}
	}

	return nil
}
