import requests
from typing import List
from repository.balance_repository import BalanceRepository
from database import models, schemas
from config.config import ConfigClass
from error.errors import NoDataFoundException, ResourceAlreadyExistsException


class BalanceService:

    def __init__(self, repository: BalanceRepository):
        self.repository = repository

    def save(self, balance: schemas.BalanceCreate):
        url = f'{ConfigClass.SKILL_FORGE_ACADEMY_API}/user/{balance.user_id}'
        
        print(url)
        
        response = requests.get(
            f'{ConfigClass.SKILL_FORGE_ACADEMY_API}/user/{balance.user_id}')

        print(response.status_code)
        # Verify user exists
        if response.status_code == 404:
            raise NoDataFoundException(arg="user")

        # Verify user exists
        found_user = self.repository.get_user_balance(balance.user_id)

        # If user exists just fi
        if found_user != None:
            raise ResourceAlreadyExistsException(arg="user")

        # save user
        self.repository.save(balance)

    def get_user_balance(self, user_id: int) -> List[models.Balance]:
        return self.repository.get_user_balance(user_id)
