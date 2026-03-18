--ACT20: PLSQL 
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
    
        DBMS_OUTPUT.PUT_LINE('L empleat: '||c_emp_loop.first_name||' te el id: '||c_emp_loop.employee_id);
    
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


DECLARE












/*
EXERCICI 4 

TIPUS: Bloc anónim 
DESCRIPCIÓ: 
El programa mostrarà una llista de missatges pera a cada departament amb el següent text: 
“El departament <department_name> té el manager <first_name> <last_name>”. 
Si el departament no té manager, el missatge serà: 
"El departament <department_name> no té manager.” 
*/






/*
EXERCICI 5 

TIPUS: procedimiento 
NOM: p_quien_cobra 
PARÀMETRES D’ENTRADA: p_salary 
DESCRIPCIÓ: 
El procediment rebrà un import(salary) i mostrarà el llistat de tots els treballadors que 
cobren aquesta quantitat (nom i cognom). 
CONTROL D’ERRORS:  - Si ens passen un nombre negatiu – Genera error “salari negatiu” - 
Si ens passen un 0 – Genera error “Ningú fa tanta llàstima” 
- Si no hi ha cap empleat que cobra la quantitat – Genera error “Ningú cobra la quantitat”
*/



