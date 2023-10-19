from abc import ABC, abstractmethod
from typing import TypeVar

T = TypeVar("T")

class Repository(ABC):
    @abstractmethod
    def save(object: T):
        pass
        