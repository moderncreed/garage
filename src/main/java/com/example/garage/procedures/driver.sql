create procedure getDriver()
begin
    select d.id, d.name, d.age, d.exp, d.id_car, c.id, c.brand, c.id_fuel, f.id, f.brand, f.octane
    from driver d join car c on c.id = d.id_car join fuel f on f.id = c.id_fuel;
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
    select d.id, d.name, d.age, d.exp, d.id_car, c.id, c.brand, c.id_fuel, f.id, f.brand, f.octane
    from driver d join car c on c.id = d.id_car join fuel f on f.id = c.id_fuel where d.id=i;
end;