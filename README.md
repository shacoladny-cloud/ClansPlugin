# ClansPlugin

Асинхронная кросс-серверная система кланов для Minecraft Paper 1.21.1.

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
