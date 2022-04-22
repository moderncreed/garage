create procedure getCity()
begin
    select  c.id, c.name from city c ;
end;

create procedure addCity(n varchar(50))
begin
    insert into city(name) values (n);
end;

create procedure deleteCity(i bigint)
begin
    delete from city where id=i;
end;

create procedure showCity(i bigint)
begin
    select  c.id,c.name from city c where c.id = i;
end;