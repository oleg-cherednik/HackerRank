select
    n,
    case
        when p is null then 'Root'
        when n in (select distinct p from bst) then 'Inner'
        else 'Leaf'
    end as type
from bst
order by n