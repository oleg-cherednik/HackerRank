select co.continent, floor(avg(ci.population))
from city ci
join country co on ci.countrycode = co.code
group by co.continent
having floor(avg(ci.population)) != 0