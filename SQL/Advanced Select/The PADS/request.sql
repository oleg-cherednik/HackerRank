select val
from (
	select 'a' k, concat(name, '(', left(occupation, 1), ')') val from occupations
    union
    select 'b' k, concat('There are a total of ', count(occupation), ' ', lower(occupation), 's.') total
	from occupations
    group by occupation
) as a
order by k asc, val asc