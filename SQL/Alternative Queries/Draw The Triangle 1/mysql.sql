select repeat('* ', @num := @num - 1)
from information_schema.tables, (select @num := 21) t
limit 20