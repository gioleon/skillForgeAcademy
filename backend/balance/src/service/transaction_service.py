import requests
from typing import List
from config.config import ConfigClass
from database import models, schemas
from repository.transaction_repository import TransactionRepository
from repository.balance_repository import BalanceRepository
from error.errors import ResourceAlreadyExistsException


class TransactionService:

    def __init__(
            self,
            trasaction_repository: TransactionRepository,
            balance_repository: BalanceRepository) -> None:

        self.transaction_repository = trasaction_repository
        self.balance_repository = balance_repository

    def save(self, transaction: schemas.TransactionCreate) -> None:

        # check if user exists
        found_user = self.balance_repository.get_user_balance(
            transaction.user_id)

        # If user does not have balance, we create it.
        if found_user == None:
            self.balance_repository.save(schemas.BalanceCreate(
                user_id=transaction.user_id, balance=transaction.price*0.80))

        # Look for the course to validate if exists
        response = requests.get(
            f'{ConfigClass.SKILL_FORGE_ACADEMY_API}\
                /course/{transaction.course_id}')

        if response.status_code == 404:
            raise ResourceAlreadyExistsException(arg = 'course')
        

        self.transaction_repository.save(transaction)

    def get_transactions_by_user(self, user_id: int) -> List[models.Transaction]:
        return self.transaction_repository.get_transactions_by_user(user_id)

    def get_transactions_by_course(self, course_id: int) -> List[models.Transaction]:
        return self.transaction_repository.get_trasactions_by_course(course_id)
