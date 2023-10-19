from sqlalchemy.orm import Session
from typing import List

from database import models, schemas

class TransactionRepository:
    
    def __init__(self, db: Session) -> None:
        self.db = db
        
    
    def save(self, transaction: schemas.TransactionCreate) -> None:
        db_transaction = models.Balance(
            user_id = transaction.user_id,
            course_id = transaction.course_id,
            price = transaction.price
        )
        
        self.db.add(db_transaction)
        self.db.commit()
        self.db.refresh(db_transaction)
        
    
    def get_transactions_by_user(
        self, user_id: int) -> List[models.Transaction]:    
        return self.db.query(models.Transaction) \
            .filter(models.Transaction.user_id == user_id).all()
      
            
    def get_trasactions_by_course(
        self, course_id: int) -> List[models.Transaction]:
        return self.db.query(models.Balance)\
            .filter(models.Transaction.course_id == course_id).all()
        
            
    
        