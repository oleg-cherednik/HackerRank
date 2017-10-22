select f1.x, f1.y
from functions f1
join functions f2 on f2.x = f1.y and f2.y = f1.x
where f1.x < f1.y or f1.x = f1.y and (select count(*) from functions f3 where f3.x = f1.x and f3.y = f1.y) > 1
group by f1.x, f1.y
order by f1.x, f2.x
