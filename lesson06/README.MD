В пакете lesson06 реализованы два модуля - shop и spring-integration.
1. В spring-integration в классе OrderServiceImpl реализовал маппинг приходящего сообщения из канала в json-строку, 
после чего десериализую объект(сущность для базы данных) по этому json-файлу опять же с помощью ObjectMapper-а. После благополучно отправляю восстановленную сущность в базу с помощью JPA.
2. Описал в классе Order модуля spring-integration все поля, 
в частности пришлось повозиться с полем List<OrderDetails> details: возникали проблемы с присваиванием номеров order-details.
В итоге в базе данных создается 3 таблицы: orders, orders_details, и промежуточная таблица - orders_details_by_id.
3. Добавил в spring-integration flyway и таблицу папку db/migration.
4. Добавление таблиц производится следующим образом: Сперва в базе данных создаю схемы orders и public. Затем, комментирую депенденси flyway, 
и в проперти выставляю настройку  hibernate:ddl-auto:create. После запуска приложений, останавливаю их и активирую депенденси на flyway, а настройку в пропертях указываю как validate.
5. Потестил получение мессаджей, посылаемых shop-ом, при условии, что заказы создаются разными пользователями. Мессаджы приходят, преобразовываются в ордеры. Заказы сохраняются корректно.
6. Также в процессе отладки отредактировал таблицы в V2__Add_Admin.sql и V3__Add_Products в shop-е, где убрал все упоминания об id, доверив их назначение и присваивание базе данных по схеме IDENTITY.
Больше проблем с нумерацией продуктов и пользователей при создании у меня не возникает.
7. Войти в магазин, по умолчанию, при разворачивании приложения можно по учетным данным: admin / pass
