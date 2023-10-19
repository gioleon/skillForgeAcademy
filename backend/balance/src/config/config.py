from decouple import config

class ConfigClass:
    SKILL_FORGE_ACADEMY_API = config('SKILL_FORGE_ACADEMY_API')
    SQLALCHEMY_DATABASE_URL = config('SQLALCHEMY_DATABASE_URL')