from fastapi import FastAPI, HTTPException
from database import database
from repository.balance_repository import BalanceRepository
from repository.transaction_repository import TransactionRepository
from service.balance_service import BalanceService
from service.transaction_service import TransactionService
from database import models, schemas
from error.errors import NoDataFoundException, ResourceAlreadyExistsException

database.Base.metadata.create_all(bind=database.engine)

balance_repository = BalanceRepository(db=database.SessionLocal())
trasaction_repository = TransactionRepository(db=database.SessionLocal())

balance_service = BalanceService(repository=balance_repository)
transaction_service = TransactionService(
    trasaction_repository=trasaction_repository,
    balance_repository=balance_repository
)

app = FastAPI()

@app.get("/hello")
def hello_world():
    return {"hello": "world "}

@app.post("/api/balance")
def create_balance(balance: schemas.BalanceCreate):
    try :
        balance_service.save(balance)
    except NoDataFoundException as ex:
        raise HTTPException(status_code=404, detail="no data found")
    except ResourceAlreadyExistsException as ex:
        raise HTTPException(status_code=409, detail="resource already exists")
    except Exception as ex:
        print(ex)
        raise HTTPException(status_code=500, detail="some error")
        
        