-- ACT 17 PLSQL



/*
EXERCICI 1: 
Defineix un bloc anònim amb dues variables anomenades v_dept_id i v_job_id a la que 
assignarem l’id d’un departament i el d’un job (per exemple 80 i SA_REP). El programa buscarà 
el nombre del departament i el nom del job i els mostrarà per sortida de consola.
*/
SET SERVEROUTPUT ON;

DECLARE
    v_dept_id  NUMBER := 80;
    v_job_id   VARCHAR2(20) := 'SA_REP';
    
    v_dept_name  VARCHAR2(200);
    v_job_title  VARCHAR2(200);
BEGIN
  
    SELECT department_name
    INTO v_dept_name
    FROM departments
    WHERE department_id = v_dept_id;
    
   
    SELECT job_title
    INTO v_job_title
    FROM jobs
    WHERE job_id = v_job_id;
    
    
    DBMS_OUTPUT.PUT_LINE('Departament: ' || v_dept_name);
    DBMS_OUTPUT.PUT_LINE('Job: ' || v_job_title);
   
       
END;
/

/*
EXERCICI 2: 
Defineix un procediment al qual li passem l'id d'un empleat i mostrem un missatge amb el seu 
nom, cognom i el nombre de treballadors que té a càrrec seu (de quanta gent és mànager).  
Per exemple: Si assignem l'ID 100, retorna el missatge "Steven King és mànager de 14 
empleats". 
Si el treballador no existeix, ha de retornar un missatge informant de l’error. 
*/

CREATE OR REPLACE PROCEDURE proc_emp_id (p_emp_id NUMBER)
IS
    v_fn VARCHAR2(200);
    v_ln VARCHAR2(200);
    v_count NUMBER;
BEGIN
    IF(p_emp_id BETWEEN 100 AND 206) THEN
        SELECT man.first_name, man.last_name, COUNT(emp.employee_id) 
        INTO v_fn, v_ln, v_count
        FROM employees emp JOIN employees man ON (emp.manager_id = man.employee_id)
        WHERE man.employee_id = p_emp_id
        GROUP BY man.first_name, man.last_name;
    
    DBMS_OUTPUT.PUT_LINE('Empleado: ' || v_fn || ' ' || v_ln || '  manager de: ' || v_count || ' empleados');
    
    ELSE
    
        DBMS_OUTPUT.PUT_LINE('Empleado no existe');
        
    END IF;
    

END;
/

EXEC proc_emp_id(100);

/*
EXERCICI3: 
Defineix un procediment al que li passarem una variable d’id de departament. El codi buscarà 
quant es gasta el departament en salaris de treballadors i retornarà un missatge en funció del 
valor. - Si la suma és superior a 19000, es retornarà el missatge "Es gasten molt!". - Si la suma és inferior a 19000, es retornarà el missatge "Es gasten poc!". - Si la suma és exactament 19000, es retornarà el missatge "Es gasten justament 19000!". 
Prova amb els valors de department (10, 20 i 80).
*/
CREATE OR REPLACE PROCEDURE pro_emp_id (p_dept_id NUMBER)
IS
  v_salary NUMBER;
   
BEGIN
   
    SELECT NVL(SUM(salary),0)
    INTO v_salary
    FROM employees
    WHERE department_id = p_dept_id;
    
    IF (v_salary > 19000) THEN
        DBMS_OUTPUT.PUT_LINE('Es gasten molt!');
        
    ELSIF (v_salary < 19000) THEN
        DBMS_OUTPUT.PUT_LINE('Es gasten poc!');
        
    ELSE
        DBMS_OUTPUT.PUT_LINE('Es gasten justament 19000!');
    END IF;
    
END;
/

EXEC pro_emp_id(10);
EXEC pro_emp_id(20);
EXEC pro_emp_id(30);