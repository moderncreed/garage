create procedure getDriver()
begin
    select d.id, d.name, d.age, d.exp, d.id_car, c2.id, c2.brand, c2.id_fuel, f.id, f.brand, f.octane
    from driver d join car c2 on c2.id = d.id_car join fuel f on f.id = c2.id_fuel;
end;

create procedure addDriver(b varchar(50), o int, e int, idc int)
begin
    insert into driver(name, age, exp, id_car) values (b,o,e,idc);
end;

create procedure deleteDriver(i bigint)
begin
    delete from driver where id=i;
end;

create procedure showDriver(i bigint)
begin
    select d.id, d.name, d.age, d.exp, d.id_car, c2.id, c2.brand, c2.id_fuel, f.id, f.brand, f.octane
    from driver d join car c2 on c2.id = d.id_car join fuel f on f.id = c2.id_fuel where d.id=i;
end;

create procedure showDriversByCar(i bigint)
begin
    select d.id, d.name, d.age, d.exp, d.id_car, c2.id, c2.brand, c2.id_fuel, f.id, f.brand, f.octane
    from driver d join car c2 on c2.id = d.id_car join fuel f on f.id = c2.id_fuel where d.id_car=i;
end;

create procedure c(i bigint)
begin
    select count(*) from `order` where id_driver=i;
end;