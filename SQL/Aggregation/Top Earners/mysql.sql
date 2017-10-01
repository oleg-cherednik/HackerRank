select (select max(months * salary) from employee) max_earnings, count(name)
from employee
where months * salary = (select max(months * salary) from employee)

-- alternative
select (salary * months) earnings, count(*) from employee group by 1 order by earnings desc limit 1