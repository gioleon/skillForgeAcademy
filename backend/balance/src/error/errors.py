class ResourceAlreadyExistsException(Exception):
    def __init__(self, arg: str) -> None:
        self.arg = arg
        super().__init__(f"{self.arg} ALREADY EXISTS")
        

class NoDataFoundException(Exception):
    def __init__(self, arg: str):
        self.arg = arg
        super().__init__(f"NO {self.arg} FOUND")    