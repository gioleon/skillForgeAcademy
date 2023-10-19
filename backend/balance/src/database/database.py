from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker
from sqlalchemy_utils import database_exists, create_database
from config.config import ConfigClass

SQLALCHEMY_DATABASE_URL = ConfigClass.SQLALCHEMY_DATABASE_URL

engine = create_engine(
    url=SQLALCHEMY_DATABASE_URL,
    pool_size=5,
    pool_recycle=3600)

# Create database if not exists
if not database_exists(engine.url):
    create_database(engine.url)

SessionLocal = sessionmaker(bind=engine, autoflush=False, autocommit=False)

Base = declarative_base()
