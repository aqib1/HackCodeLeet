select count(id) from products where city='Berlin' having price min(
select price from products where city='Berlin' group by price
);