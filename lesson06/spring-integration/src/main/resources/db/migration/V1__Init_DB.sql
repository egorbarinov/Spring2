set search_path to orders;

--ORDERS

create table orders (
                        id bigserial not null,
                        address varchar(255),
                        changed timestamp,
                        created timestamp,
                        status varchar(255),
                        sum numeric(19, 2),
                        user_id int8,
                        primary key (id)
);

alter table if exists orders
    add constraint orders_fk_user
        foreign key (user_id) references users;


-- Table: orders.orders_details
--
-- DROP TABLE orders.orders_details;

-- DETAILS OF ORDER
create table orders_details (
                                id bigserial not null,
                                order_id bigserial not null,
                                product_id bigserial not null,
                                amount numeric(19, 2),
                                price numeric(19, 2),
                                primary key (id)
);

alter table if exists orders_details
    add constraint orders_details_fk_order
        foreign key (order_id) references orders;

alter table if exists orders_details
    add constraint orders_details_fk_product
        foreign key (product_id) references products;
