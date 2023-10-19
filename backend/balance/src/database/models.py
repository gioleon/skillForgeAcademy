from datetime import datetime

from sqlalchemy import Column, BigInteger, Float, DateTime, ForeignKey
from sqlalchemy.orm import relationship

from database.database import Base


class Balance(Base):
    
    __tablename__ = 'balance'
    
    id = Column(BigInteger, primary_key=True)
    user_id = Column(BigInteger, unique=True, nullable=False)
    balance = Column(Float, unique=True, nullable=False)
    updated_at  = Column(DateTime, default=datetime.now())
    
    def __str__(self):
        return f'{self.user_id} - {self.balance} - {self.updated_at}'
    
    
class Transaction(Base):
    
    __tablename__ = 'transactions'
    
    id = Column(BigInteger, primary_key=True)
    user_id = Column(BigInteger, nullable=False, unique=False)
    course_id = Column(BigInteger, nullable=False, unique=False)
    price = Column(Float, nullable=False, unique=False)
    # detalle
    created_at = Column(DateTime, default=datetime.now())
     
    
    def __str__(self):
        return f'{self.user_id} - {self.course_id} - {self.price} - {self.created_at}'