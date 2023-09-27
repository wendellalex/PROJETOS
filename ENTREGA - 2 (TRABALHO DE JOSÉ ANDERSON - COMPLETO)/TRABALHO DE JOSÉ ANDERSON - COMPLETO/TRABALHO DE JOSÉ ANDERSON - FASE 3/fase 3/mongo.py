import requests
from pymongo import MongoClient
import random

class Config:
    def __init__(self):
        self.config = {
            "mongodb": {
                "host": "localhost",
                "port": 27017,
                "database": "mydatabase"
            }
        }

class Connection(Config):
    def __init__(self):
        super().__init__()
        try:
            self.client = MongoClient(self.config["mongodb"]["host"], self.config["mongodb"]["port"])
            self.db = self.client[self.config["mongodb"]["database"]]
        except Exception as e:
            print("Erro na conexão", e)
            exit(1)

    def __enter__(self):
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        self.client.close()

    def insert(self, data):
        try:
            collection = self.db["todolist"]
            collection.insert_one(data)
        except Exception as e:
            print("Erro ao inserir", e)

base_url = 'https://jsonplaceholder.typicode.com/todos/1'
response = requests.get(base_url)
data = response.json()

if __name__ == "__main__":
    data["_id"] = random.randint(1, 145266454)  # Adicionar um campo _id para o MongoDB
    jsonTeste = Connection()
    jsonTeste.insert(data)
