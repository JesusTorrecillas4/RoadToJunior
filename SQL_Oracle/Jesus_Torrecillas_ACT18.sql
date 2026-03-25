--ACT 18: PLSQL 
SET SERVEROUTPUT ON;

/*
EXERCICI 1 
TIPUS: Bloc anónim 
DESCRIPCIÓ: 
El programa recorrerà tota la taula de departaments i mostrarà el següent missatge, per cada  
departament:
"El departament XXXXXX té id XXXXXXX" 
*/
/
DECLARE
    CURSOR c_dep IS

    SELECT department_name, department_id
    FROM departments;
    
  BEGIN
  
  FOR c_loop IN c_dep
    LOOP 
    
         DBMS_OUTPUT.PUT_LINE('El departament: '||c_loop.department_name||' te el id: '||c_loop.department_id);
    
    END LOOP;
    
    
END;
/
    

/*
EXERCICI 2 


TIPUS: Bloc anónim 
DESCRIPCIÓ: 
El programa recorrerà la taula d’empleats i mostrarà el següent missatge per als treballadors  
amb id senar: 

“L’empleat XXXXXX té id XXXXXXX 
*/


DECLARE
    CURSOR c_emp IS
    
        SELECT first_name, employee_id
        FROM employees;

BEGIN
    FOR c_emp_loop IN c_emp
    LOOP
        IF MOD(c_emp_loop.employee_id,2) = 1 THEN
        DBMS_OUTPUT.PUT_LINE('L empleat: '||c_emp_loop.first_name||' te el id: '||c_emp_loop.employee_id);
    END IF;
    END LOOP;

END;
/


/*
EXERCICI 3 

    TIPUS: Bloc anónim 
    DESCRIPCIÓ: 
    El programa mostrarà una llista de missatges amb el següent text:  
    “L’empleat XXXXX cobra MÁS/MENOS que la mitja del seu departament”  
    Si l’empleat no té departament, canvia pel text:  
    "L’empleat XXXXX no el volen a cap departament..." 
*/

/
DECLARE

CURSOR c_cur IS

    SELECT employee_id,first_name,salary, department_id 
    FROM employees;
    

    v_media NUMBER;
BEGIN

 FOR c_loop IN c_cur
    LOOP
        
        IF c_loop.department_id IS NULL THEN
        DBMS_OUTPUT.PUT_LINE('El empleat '||c_loop.first_name||' no el volen a cap departament... ');
        ELSE
        
        SELECT AVG(salary)
        INTO v_media
        FROM employees
        WHERE department_id = c_loop.department_id;
        
        IF v_media > c_loop.salary THEN
         DBMS_OUTPUT.PUT_LINE('El empleat '||c_loop.first_name||'cobra MÁS que la mitja del seu departament');
         
        ELSIF v_media < c_loop.salary THEN
            DBMS_OUTPUT.PUT_LINE('El empleat '||c_loop.first_name||'cobra MENOS que la mitja del seu departament');
        END IF;
    
    END IF;
    END LOOP;
    
END;
/

/*
EXERCICI 4 

TIPUS: Bloc anónim 
DESCRIPCIÓ: 
El programa mostrarà una llista de missatges pera a cada departament amb el següent text: 
“El departament <department_name> té el manager <first_name> <last_name>”. 
Si el departament no té manager, el missatge serà: 
"El departament <department_name> no té manager.” 
*/
/
DECLARE

    CURSOR c_man IS
        
        SELECT dep.department_name  AS dep_name,man.first_name AS man_fn, man.last_name AS man_ln,dep.manager_id AS man_id
        FROM departments dep
        LEFT JOIN employees man ON (dep.manager_id = man.employee_id);
BEGIN

    FOR c_lp IN c_man
    
    LOOP
    
        IF c_lp.man_id IS NULL THEN
        
        DBMS_OUTPUT.PUT_LINE('El departament '||c_lp.dep_name||' no té manager');
        
        ELSIF c_lp.man_id IS NOT NULL THEN
    
        DBMS_OUTPUT.PUT_LINE('El departament '||c_lp.dep_name||' té el manager '||c_lp.man_fn||' '||c_lp.man_ln);
    
        END IF;
    
    END LOOP;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error inesperat: ' || SQLERRM);

END;
/
/*
EXERCICI 5
TIPUS: Procediment (PROCEDURE).
NOM: ACTUALITZAR_SALARIS_PER_ROL.
PARÀMETRES D'ENTRADA: p_dept_id (NUMBER),p_job_id (VARCHAR2),p_increment
(NUMBER)
DESCRIPCIÓ: El procediment ha d'utilitzar un cursor per identificar tots els empleats que
treballen en un departament concret i que tenen un codi de treball (JOB_ID) específic. Per a
cada empleat trobat, s'ha d'augmentar el seu salari segons el paràmetre p_increment. En
finalitzar el recorregut, el sistema ha de mostrar quants empleats s'han vist afectats i la suma
total de l'increment salarial aplicat al departament.

CONTROL D'ERRORS: Si el cursor no troba cap empleat que compleixi les dues condicions
simultàniament, s'ha d'informar que no s'ha realitzat cap canvi. Controla també possibles errors
de format en els paràmetres d'entrada.
*/
/
CREATE OR REPLACE PROCEDURE actualizar_salaris_per_rol(p_dept_id NUMBER, p_job_id VARCHAR2, p_increment NUMBER)
IS

    CURSOR c_upd IS
    SELECT first_name AS f_name,employee_id,salary AS sal,job_id AS j_id
    FROM employees 
    WHERE department_id = p_dept_id AND job_id = p_job_id ;

    v_count NUMBER := 0;
     v_total_increment NUMBER := 0;
  
BEGIN


    FOR c_lop IN c_upd 
    
    LOOP
     v_count := v_count + 1;
     v_total_increment := v_total_increment + p_increment;
     
    UPDATE copy_employees
    SET salary = salary + p_increment
    WHERE employee_id = c_lop.employee_id;

    DBMS_OUTPUT.PUT_LINE('El empleat '||c_lop.f_name||' te el nou salari de '||(c_lop.sal +p_increment));
        
    
    END LOOP;
    
    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No s ha realitzat cap canvi.');
    ELSE
        
        DBMS_OUTPUT.PUT_LINE('Empleats afectats: ' || v_count|| ' Total increment aplicat: ' || v_total_increment);
      
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error inesperat: ' || SQLERRM);

END;
/
EXEC actualizar_salaris_per_rol(80, 'SA_REP', 100);
/*
EXERCICI 6
TIPUS: Procediment (PROCEDURE).
NOM: VALIDAR_MANAGERS_UBICACIO.
PARÀMETRES D'ENTRADA: p_location_id (NUMBER).
DESCRIPCIÓ: El procediment ha de recórrer, mitjançant un cursor, tots els departaments
situats en una localització específica. Per a cada departament, s'ha de comprovar si té assignat
un MANAGER_ID.
• Si el té, s'ha d'imprimir el nom del departament i el nom del seu mànager.
• Si el camp MANAGER_ID és nul, s'ha d'imprimir el missatge: "ALERTA: El departament
[NOM] no té responsable".

CONTROL D'ERRORS: Cal gestionar el cas en què la localització indicada no existeixi a la taula
LOCATIONS. Si la localització existeix però no té departaments associats, s'ha d'indicar amb un
missatge informatiu.
*/
/
CREATE OR REPLACE PROCEDURE validar_managers_ubi(p_location_id NUMBER)IS

    CURSOR c_man_ubi IS
    SELECT dep.department_name AS dep_name, dep.department_id AS dep_id, dep.manager_id AS man_id,dep.location_id,man.manager_id, man.first_name AS man_name
    FROM departments dep
    LEFT JOIN employees man ON (dep.manager_id = man.employee_id)
    WHERE dep.location_id = p_location_id;

    v_count    NUMBER := 0;
     v_loc NUMBER;
BEGIN

    SELECT location_id INTO v_loc
    FROM locations
    WHERE location_id = p_location_id;
   
    FOR c_lop IN c_man_ubi
    LOOP
    v_count := v_count + 1;
    
    IF c_lop.man_id IS NULL THEN
           DBMS_OUTPUT.PUT_LINE('ALERTA: El departament '||c_lop.dep_name||' no té responsable');
    ELSE
    
    DBMS_OUTPUT.PUT_LINE('El departament: '||c_lop.dep_name||' te el manager '||c_lop.man_name);
    END IF;
    END LOOP;

    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('La localitzacio ' || p_location_id ||' existeix pero no te departaments associats.');
    END IF;
    
    EXCEPTION
    WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: La localitzacio ' || p_location_id ||' no existeix a la taula LOCATIONS.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error inesperat: ' || SQLERRM);
    
END;
/
EXEC validar_managers_ubi(0145646);






/*
EXERCICI 7
TIPUS: Procediment (PROCEDURE).
NOM: RESUM_HISTORIC_EMPLEAT.
PARÀMETRES D'ENTRADA: p_employee_id (NUMBER).
DESCRIPCIÓ: Encara que el procediment rep un sol ID d'empleat, ha d'utilitzar un cursor per
recórrer totes les entrades de la taula JOB_HISTORY associades a aquesta persona. Per a cada
registre històric, ha de mostrar:
• La data d'inici i finalització.
• El nom del departament on va treballar (requereix un join amb DEPARTMENTS dins del
cursor).
• La durada en dies de cada etapa laboral.

CONTROL D'ERRORS: Si l'empleat no té cap registre a l'històric (però existeix a la taula
EMPLOYEES), ha de mostrar: "L'empleat no té antecedents laborals registrats". Si l'ID de
l'empleat no existeix en cap de les dues taules, s'ha d'informar de l'error de dades.
*/
/
CREATE OR REPLACE PROCEDURE  resum_historic_empleatt(p_employee_id NUMBER)IS

 CURSOR c_historic IS
        SELECT jobh.start_date AS data_inici,jobh.end_date AS data_fi,dep.department_name AS dep_name,(jobh.end_date - jobh.start_date)AS dies
        FROM job_history jobh
        JOIN departments dep ON (jobh.department_id = dep.department_id)
        WHERE jobh.employee_id = p_employee_id;

    v_count    NUMBER := 0;
    v_em NUMBER;

BEGIN
   
    SELECT employee_id INTO v_em
    FROM employees
    WHERE employee_id = p_employee_id;

 
    FOR c_lop IN c_historic
    LOOP
        v_count := v_count + 1;

        DBMS_OUTPUT.PUT_LINE('Inici: ' || c_lop.data_inici);
        DBMS_OUTPUT.PUT_LINE('Fi: ' || c_lop.data_fi);
        DBMS_OUTPUT.PUT_LINE('Departament: ' || c_lop.dep_name);
        DBMS_OUTPUT.PUT_LINE('Durada:      ' || c_lop.dies || ' dies');

    END LOOP;

    
    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('L empleat no te antecedents laborals registrats.');
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: L ID ' || p_employee_id || 
                             ' no existeix en cap de les dues taules.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error inesperat: ' || SQLERRM);
END;
/

EXEC resum_historic_empleatt(101);













