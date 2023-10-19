from pydantic import BaseModel

from datetime import datetime


class BalanceBase(BaseModel):
    user_id: int
    balance: float
    

class BalanceCreate(BalanceBase):
    pass

class Balance(BalanceBase):
    id: int
    updated_at: datetime
    
    class Config:
        orm_mode = True
    
    
class TransactionBase(BaseModel):
    user_id: int
    course_id: int
    price: float
    

class TransactionCreate(TransactionBase):  
    pass

class Transaction(TransactionBase):
    id: int
    created_at: datetime
    
    class Config:
        orm_mode = True