--ACT14: Llenguatges SQL: Queries

/*1. Mostra nom, salari i nom de departament, dels empleats que cobren més de 5000 i 
pertanyen als departaments 50,60 o 100. */ 
SELECT emp.first_name, emp.salary, dep.department_name
FROM employees emp JOIN departments dep ON (emp.department_id = dep.department_id)
WHERE emp.salary > 5000 AND dep.department_id IN (50, 60, 100);
/*2. Llista que contingui: 
• Nom dels departaments, el seu carrer, la ciutat i el nom del país. */
SELECT dep.department_name, loc.street_address, loc.city, con.country_name
FROM departments dep JOIN locations loc ON  (dep.location_id = loc.location_id)
JOIN countries con ON (loc.country_id = con.country_id);
/*3. Mostra el nom, cognom i nom del job (job_title) dels empleats que treballen al 
departament ‘IT’ (department_name). */

SELECT emp.first_name, emp.last_name, job.job_title 
FROM employees emp JOIN jobs job ON (emp.job_id = job.job_id)
JOIN departments dep ON (emp.department_id = dep.department_id)
WHERE dep.department_name = 'IT';

--4. Mostra el nom i cognom dels empleats que treballen a la ciutat de ‘Seattle’. 
SELECT emp.first_name, emp.last_name 
FROM employees emp JOIN departments dep ON (emp.department_id = dep.department_id)
 JOIN locations loc ON (dep.location_id = loc.location_id)
WHERE loc.city = 'Seattle';
--5. Mostra el nom i cognom de cada empleat i el nom i cognom del seu manager. 
SELECT emp.first_name, emp.last_name, man.first_name AS manager_name, man.last_name AS manager_last_name
FROM employees emp JOIN employees man ON (man.employee_id = emp.employee_id);
/*6. Llista que contingui: 
• Nom del treballador. 
• Nom del responsable del treballador (manager). 
• Nom del job del treballador. 
• Nom del job del responsable (manager). */
SELECT emp.first_name, man.first_name AS Manager_name, job_emp.job_title AS JOB_Empleat, job_man.job_title AS JOB_Manager
FROM employees emp JOIN employees man ON (man.employee_id = emp.manager_id)
 JOIN jobs job_emp ON (emp.job_id = job_emp.job_id)
 JOIN jobs job_man ON (man.job_id = job_man.job_id);
 
/*7. Llista que contingui: 
• Nom i Cognom dels treballadors 
• Nom del departament 
• Nom del job 
• Han de sortit TOTS els treballadors contractats entre 2005 i 2007 */

SELECT emp.first_name, emp.last_name, dep.department_name, job.job_title
FROM employees emp JOIN departments dep ON (emp.department_id = dep.department_id)
 JOIN jobs job ON (emp.job_id = job.job_id)
 WHERE hire_date BETWEEN TO_DATE('01/01/2005','DD/MM/YYYY') AND TO_DATE('31/12/2007','DD/MM/YYYY');

--8. Quan es gasta cada departament (nom) en salaris. Mostra TOTS  els departaments ? 
SELECT dep.department_name, SUM (emp.salary)
FROM employees emp RIGHT
 JOIN departments dep ON (emp.department_id = dep.department_id)
 GROUP BY dep.department_name;
--9. Mostra tots els empleats que son managers i mostra quanta gent tenen al seu càrrec. 
SELECT man.first_name, COUNT (emp.employee_id) 
FROM employees man JOIN employees emp ON (emp.manager_id = man.employee_id)
GROUP BY man.first_name;
/*10. Mostrar els empleats (nom), el seu manager (nom), el manager (nom) del seu 
departament i la comissió de cada un d’ells en format TANT PER CENT (%). Si pots, 
mostra’ls TOTS  */ 
SELECT emp.first_name, man.first_name, dep.department_name, NVL (man.commission_pct, 0)*100 || '%'
FROM employees emp JOIN employees man ON (emp.manager_id = man.employee_id)
 JOIN departments dep ON (man.department_id = dep.department_id);
/*11. Quants treballadors hi ha a cada departament? 
• Mostra els noms de departament amb el nombre de treballadors que hi ha. 
• Mostra’ls TOTS */    
SELECT COUNT (emp.employee_id), dep.department_name
FROM employees emp LEFT JOIN departments dep ON (emp.department_id = dep.department_id)
GROUP BY dep.department_name;
/*12. Mostra el nom de les ciutats i nombre de treballadors, d’aquelles on hi ha més de 4 
treballadors. */
SELECT loc.city, COUNT(emp.employee_id) AS numero_treballadors
FROM employees emp JOIN departments dep ON (emp.department_id = dep.department_id)
JOIN locations loc ON (dep.location_id = loc.location_id)
GROUP BY loc.city HAVING COUNT(emp.employee_id) > 4 ORDER BY loc.city;
