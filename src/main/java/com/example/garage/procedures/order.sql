create procedure getOrder()
begin
    select o.id_driver, o.price, o.id_city, o.date, d.id, d.name, d.age, d.exp, d.id_car, c2.id, c2.brand, c2.id_fuel, c.id, c.name, f.id, f.brand, f.octane
    from `order` o join city c on c.id = o.id_city join driver d on d.id = o.id_driver join car c2 on c2.id = d.id_car join fuel f on f.id = c2.id_fuel;
end;

create procedure addOrder(p int,d date, idC bigint, idD bigint)
begin
    insert into `order`(id_driver, price, id_city, date) values (idD,p,idC,d);
end;

