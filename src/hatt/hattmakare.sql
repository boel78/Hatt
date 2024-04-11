-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: hattmakare
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
--  Create database
--
CREATE DATABASE hattmakardb CHARACTER SET utf8mb4 COLLATE utf8mb4_sv_0900_ai_ci;
USE hattmakardb;
/*This code is to create the database to enable the creation of a user for connecting to the database and the creation of the tables and example data*/
--
-- Create user for connecting to the database
--
CREATE USER hattmakare@localhost IDENTIFIED BY 'Hattsweatshop';
GRANT ALL PRIVILEGES ON hattmakardb.* TO hattmakare@localhost;
/*This code is to enable a connection to the database hattmakardb*/

create table customer
(
    cid     int         not null
        primary key,
    name    varchar(25) null,
    address varchar(25) null,
    phone   varchar(25) null,
    email   varchar(25) null
);

create table business_customer
(
    cid        int         not null,
    org_number varchar(25) null,
    constraint business_customer_customer_cid_fk
        foreign key (cid) references customer (cid)
);

create table invoice
(
    inid int    not null
        primary key,
    cost double null,
    oid  int    null
);

create table private_customer
(
    cid int not null,
    constraint private_customer_customer_cid_fk
        foreign key (cid) references customer (cid)
);

create table stocked_product
(
    sid            int          not null
        primary key,
    name           varchar(25)  null,
    description    varchar(100) null,
    starting_price double       null
);

create table supplier
(
    sid   int         not null
        primary key,
    name  varchar(25) null,
    email varchar(25) null,
    phone varchar(25) null
);

create table user
(
    uid      int         not null
        primary key,
    name     varchar(25) null,
    email    varchar(25) null,
    position varchar(25) null,
    phone    varchar(25) null
);

create table accountant
(
    uid int not null,
    constraint accountant_user_uid_fk
        foreign key (uid) references user (uid)
);

create table accountant_access
(
    uid  int not null,
    inid int not null,
    primary key (inid, uid),
    constraint accountant_access_accountant_uid_fk
        foreign key (uid) references accountant (uid),
    constraint accountant_access_invoice_inid_fk
        foreign key (inid) references invoice (inid)
);

create table employee
(
    uid int not null,
    constraint employee_user_uid_fk
        foreign key (uid) references user (uid)
);

create table handles_product
(
    uid int not null,
    sid int not null,
    primary key (uid, sid),
    constraint handles_product_stocked_product_sid_fk
        foreign key (sid) references stocked_product (sid),
    constraint handles_product_user_uid_fk
        foreign key (uid) references user (uid)
);

create table materials
(
    mid        int         not null
        primary key,
    name       varchar(25) null,
    price      double      null,
    handled_by int         not null,
    constraint materials_employee_uid_fk
        foreign key (handled_by) references employee (uid)
);

create table accessories
(
    amount int null,
    mid    int not null,
    constraint accessories_materials_mid_fk
        foreign key (mid) references materials (mid)
);

create table fabric
(
    mid  int    not null,
    size double null,
    constraint fabric_materials_mid_fk
        foreign key (mid) references materials (mid)
);

create table `order`
(
    oid            int         not null
        primary key,
    description    varchar(25) null,
    estimated_time double      null,
    created_by     int         not null,
    invoice        int         null,
    customer       int         null,
    constraint xOrder_customer_cid_fk
        foreign key (customer) references customer (cid),
    constraint order_employee_uid_fk
        foreign key (created_by) references employee (uid),
    constraint order_invoice_inid_fk
        foreign key (invoice) references invoice (inid)
);

alter table invoice
    add constraint invoice_order_oid_fk
        foreign key (oid) references `order` (oid);

create table order_consists_of_materials
(
    oid int not null,
    mid int not null,
    primary key (mid, oid),
    constraint order_consists_of_materials_materials_mid_fk
        foreign key (mid) references materials (mid),
    constraint order_consists_of_materials_order_oid_fk
        foreign key (oid) references `order` (oid)
);

create table ordering_materials
(
    mid  int not null,
    sid  int not null,
    inid int not null,
    primary key (mid, inid, sid),
    constraint ordering_materials_invoice_inid_fk
        foreign key (inid) references invoice (inid),
    constraint ordering_materials_materials_mid_fk
        foreign key (mid) references materials (mid),
    constraint ordering_materials_supplier_sid_fk
        foreign key (sid) references supplier (sid)
);

create table product_materials
(
    sid int not null,
    mid int not null,
    primary key (mid, sid),
    constraint product_materials_materials_mid_fk
        foreign key (mid) references materials (mid),
    constraint product_materials_stocked_product_sid_fk
        foreign key (sid) references stocked_product (sid)
);

create table requests
(
    rid         int         not null
        primary key,
    description varchar(25) null,
    reviewed_by int         not null,
    reviewed    varchar(1)  not null,
    review_status varchar(1) not null,
    customer    int         not null,
    constraint requests_customer_cid_fk
        foreign key (customer) references customer (cid),
    constraint requests_employee_uid_fk
        foreign key (reviewed_by) references employee (uid)
);

create table waybill
(
    wid           int         not null,
    oid           int         not null,
    volume        double      null,
    weight        double      null,
    content       varchar(25) null,
    package_count varchar(5)  null,
    primary key (wid, oid),
    constraint waybill_order_oid_fk
        foreign key (oid) references `order` (oid)
);

INSERT INTO hattmakardb.accessories (amount, mid) VALUES (42, 2);
INSERT INTO hattmakardb.accessories (amount, mid) VALUES (3, 4);
INSERT INTO hattmakardb.xOrder (oid, description, estimated_time, created_by, customer) VALUES (1, 'Jeanshat', 4, 1, 1);
INSERT INTO hattmakardb.xOrder (oid, description, estimated_time, created_by, customer) VALUES (2, 'Doctorateshat', 2, 1, 1);
INSERT INTO hattmakardb.xOrder (oid, description, estimated_time, created_by, customer) VALUES (3, 'Silkbonnet', 3, 2, 2);
INSERT INTO hattmakardb.order_consists_of_materials (oid, mid, amount) VALUES (1, 1, 1);
INSERT INTO hattmakardb.ordering_materials (mid, sid, inid) VALUES (1, 1, 1);
INSERT INTO hattmakardb.ordering_materials (mid, sid, inid) VALUES (2, 2, 3);
INSERT INTO hattmakardb.private_customer (cid) VALUES (1);
INSERT INTO hattmakardb.private_customer (cid) VALUES (2);
INSERT INTO hattmakardb.product_materials (sid, mid) VALUES (1, 3);
INSERT INTO hattmakardb.requests (rid, description, reviewed_by, reviewed, review_status, customer) VALUES (1, 'En jeanshatt', 1, 'N', 'N', 1);
INSERT INTO hattmakardb.stocked_product (sid, name, description, starting_price) VALUES (1, 'Doctorateshat', 'A Doctorates hat', 1200);
INSERT INTO hattmakardb.supplier (sid, name, email, phone) VALUES (1, 'Lollos Jeans', 'lollo.jeans@gmail.com', '070-0000000');
INSERT INTO hattmakardb.supplier (sid, name, email, phone) VALUES (2, 'Alis Accessories', 'aliexpress@gmail.com', '073-0200472');
INSERT INTO hattmakardb.supplier (sid, name, email, phone) VALUES (3, 'Silvias Silk', 'silkysmooth@hotmail.com', '042-0739282');
INSERT INTO hattmakardb.user (uid, name, email, position, phone) VALUES (1, 'Otto', 'ottohatt@gmail.com', 'partner', '070-5551231');
INSERT INTO hattmakardb.user (uid, name, email, position, phone) VALUES (2, 'Judith', 'judithhatt@gmail.com', 'partner', '070-1234565');
INSERT INTO hattmakardb.user (uid, name, email, position, phone) VALUES (3, 'Joakim', 'joakimrevisor@gmail.com', 'accountant', '073-9876543');
INSERT INTO hattmakardb.waybill (wid, oid, volume, weight, content, package_count) VALUES (1, 1, 1, 5, 'Jeanshat', '1');
