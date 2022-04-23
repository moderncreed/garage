create procedure getCar()
begin
    select  c2.id, c2.brand, f.id, f.brand, f.octane from car c2 join fuel f on f.id = c2.id_fuel;
end;

create procedure addCar(b varchar(50), o bigint)
begin
    insert into car(brand, id_fuel) values (b, o);
end;

create procedure deleteCar(i bigint)
begin
    delete from car where id=i;
end;

create procedure showCar(i bigint)
begin
    select  c2.id, c2.brand, f.id, f.brand, f.octane from car c2 join fuel f on f.id = c2.id_fuel where c2.id = i;
end;




