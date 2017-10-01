select
    c.company_code,
    c.founder,
    (select count(distinct lm.lead_manager_code) from lead_manager lm where lm.company_code = c.company_code) lead_managers,
    (select count(distinct sm.senior_manager_code) from senior_manager sm where sm.company_code = c.company_code) senior_managers,
    (select count(distinct m.manager_code) from manager m where m.company_code = c.company_code) managers,
    (select count(distinct e.employee_code) from employee e where e.company_code = c.company_code) employees
from company c
order by c.company_code