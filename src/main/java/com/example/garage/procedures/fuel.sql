create procedure getFuel()
begin
    select  f.id,f.brand,f.octane from fuel f;
end;

create procedure addFuel(b varchar(50), o int)
begin
    insert into fuel(brand, octane) values (b, o);
end;

create procedure deleteFuel(i bigint)
begin
    delete from fuel where id=i;
end;

create procedure showFuel(i bigint)
begin
    select  f.id,f.brand,f.octane from fuel f where f.id = i;
end;