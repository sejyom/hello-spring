drop table if exists member CASCADE;
create table member (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(255),
    primary key(id)
)