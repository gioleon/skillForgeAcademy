from sqlalchemy.orm import Session
from database import models, schemas


class BalanceRepository:
    
    def __init__(self, db: Session) -> None:
        self.db = db
    
        
    def save(self, balance: schemas.BalanceCreate) -> None:
        db_balance = models.Balance(
            user_id = balance.user_id, 
            balance = balance.balance
        )
        
        self.db.add(db_balance)
        self.db.commit()
        self.db.refresh(db_balance)
    
    
    def get_user_balance(self, user_id: int) -> models.Balance:
        return self.db.query(models.Balance) \
            .filter(models.Balance.id == user_id).first()
            
    