# ClansPlugin

Асинхронная кросс-серверная система кланов для Minecraft Paper 1.21.1.

##💼 Тесты
При тестах сервер не видел plugin.yml 
Мне это лень чинить так что как-то сами.
Первый раз писал такой плагин, да и в сфере я всего 1 год.
В общем простите.

## 🏗️ Архитектура

flowchart LR
    Player --> Velocity
    Velocity --> Redis
    Velocity --> Server1[Paper сервер 1]
    Velocity --> Server2[Paper сервер 2]
    Server1 --> MySQL
    Server2 --> MySQL
    Redis --> Server1
    Redis --> Server2

## 🛠️ Технологии
- Java 21
- Paper API
- HikariCP (пул соединений MySQL)
- Redis (Pub/Sub)
- Gradle (многомодульный)

## 🚀 Команды
| Команда | Описание |
|---------|----------|
| `/clan create <название> <тег>` | Создать клан |
| `/clan invite <игрок>` | Пригласить игрока (в разработке) |
| `/clan accept` | Принять приглашение (в разработке) |

## 🐳 Быстрый старт (Docker)
```bash
docker run -d --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=clans -p 3306:3306 mysql:8.0
docker run -d --name redis -p 6379:6379 redis:7-alpine
