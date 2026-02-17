--ACT16 PSQL
SET SERVEROUTPUT ON;

/*EXERCICI 1:  
Defineix un bloc anònim amb les següents variables definides i mostra el seu valor amb < 
DBMS_OUTPUT.PUT_LINE> 
DECLARE 
v_hiredate DATE; 
v_deptno NUMBER(2) NOT NULL := 10; 
v_location VARCHAR2(13) := 'Atlanta'; 
c_comm CONSTANT NUMBER := 1400; */

/
DECLARE
    v_hiredate DATE := SYSDATE; 
    v_deptno NUMBER(2) NOT NULL := 10; 
    v_location VARCHAR2(13) := 'Atlanta'; 
    c_comm CONSTANT NUMBER := 1400; 
BEGIN

    DBMS_OUTPUT.PUT_LINE('Hiredate: ' || v_hiredate);
    DBMS_OUTPUT.PUT_LINE('Deptno: ' || v_deptno);
    DBMS_OUTPUT.PUT_LINE('Location: ' || v_location);
    DBMS_OUTPUT.PUT_LINE('Commission: ' || c_comm);
END;
/


/*EXERCICI 2:  
Digueu si aquests identificadors són vàlids per definir variables i per què: 

v_A#$ , si es valido porque empieza con una letra 
_num , no es valido porque empieza con un signo , debe ser una letra
X2 , si es valido porque empieza con una letra
2X , no es valido porque empieza con un numero
v_num , si es valido porque empieza con una letra
#A , no es valido porque empieza con un simbolo 

*/





/*EXERCICI 3: 
Digueu si aquestes declaracions són vàlides o no i per què: 
v_id NUMBER(4);, SI es valida porque esta todo correcto, el orden y la funcion de NUMBER
v_x, v_y, v_z VARCHAR2(10);, NO es valida porque no se pueden delcarar 3 a la vez usadno solo una funcion
v_birthdate DATE NOT NULL; , NO es correcto porque nunca se iniciaria, debe tener el := SYSDATE al final
v_in_stock BOOLEAN:=1; , NO es calida, las booleanas solo puedn terminar en true o false o null los numeors dan error
emp_ename emp_ename_type;.
*/




/*
EXERCICI 4: 
Defineix un bloc anònim que mostri el nom i cognom del treballador 107. Mostra a la sortida del 
programa el text: “El treballador és: <nom> <cognom>” */
/
DECLARE
 v_fn VARCHAR2(200);
 v_ln VARCHAR2(200);
BEGIN

    SELECT first_name, last_name
    INTO v_fn, v_ln
    FROM employees
    WHERE employee_id = 107;

    DBMS_OUTPUT.PUT_LINE('“El treballador és: '|| v_fn || ' ' || v_ln);
END;
/



/*EXERCICI 5: 
Defineix un bloc anònim que mostri el nom del departament o treballa l’empleat 109. Mostra a la 
sortida del programa el text: “<nom> <cognom> treballa al departament <nom del 
departament>” */
/
DECLARE
    v_dn VARCHAR2(200);
    v_fn VARCHAR2(200);
    v_ln VARCHAR2(200);
BEGIN
    SELECT dep.department_name, emp.first_name, emp.last_name
    INTO v_dn, v_fn, v_ln
    FROM employees emp
    JOIN departments dep ON (emp.department_id = dep.department_id)
    WHERE emp.employee_id = 109;
    
    DBMS_OUTPUT.PUT_LINE(v_fn || ' ' || v_ln ||' treballa al departament ' || v_dn);
END;
/


/*EXERCICI 6: 
Defineix un bloc anònim amb dues variables anomenades v_empleat1 i v_empleat2 a la que 
signarem dos ids d’empleat (per exemple 107 i 109). El programa buscarà la localització de cada 
empleat i mostrarà dos missatges informant del carrer, ciutat, codi postal i província dels 
dos treballadors. */
/
DECLARE
--declaro varaibles
    v_empleat1 NUMBER := 107;
    v_empleado1D VARCHAR2(200);
    v_empleat2 NUMBER := 109;
    v_empleado2D VARCHAR2(200);
BEGIN
--busco todo y lo concateno y lo decalro variable varchar
    SELECT loc.street_address||'-'||loc.city||'-'|| loc.postal_code ||'-'|| loc.state_province
    INTO v_empleado1D
    FROM employees emp
    JOIN departments dep ON dep.department_id = emp.department_id
    JOIN locations  loc ON loc.location_id   = dep.location_id
   WHERE emp.employee_id = v_empleat1;
   
    DBMS_OUTPUT.PUT_LINE(v_empleado1D);
    
    SELECT loc.street_address||'-'||loc.city||'-'|| loc.postal_code ||'-'|| loc.state_province
    INTO v_empleado2D
    FROM employees emp
    JOIN departments dep ON dep.department_id = emp.department_id
    JOIN locations  loc ON loc.location_id   = dep.location_id
   WHERE emp.employee_id = v_empleat2;
   
   DBMS_OUTPUT.PUT_LINE(v_empleado2D);
END;

/*EXERCICI 7: 
Defineix un bloc anònim que mostri missatges amb els totals de registres de les taules 
EMPLOYEES, DEPARTMENTS, LOCATIONS i COUNTRIES. */
/
DECLARE
--Declaro las varaibles
    v_emp_count  NUMBER;
    v_dep_count  NUMBER;
    v_loc_count  NUMBER;
    v_ctry_count NUMBER;
BEGIN

--Selecciono todo y lo paso a su variable
    SELECT COUNT(*) 
    INTO v_emp_count FROM employees;
    SELECT COUNT(*) 
    INTO v_dep_count FROM departments;
    SELECT COUNT(*) 
    INTO v_loc_count FROM locations;
    SELECT COUNT(*) 
    INTO v_ctry_count FROM countries;

    DBMS_OUTPUT.PUT_LINE('Total EMPLOYEES: ' || v_emp_count);
    DBMS_OUTPUT.PUT_LINE('Total DEPARTMENTS: ' || v_dep_count);
    DBMS_OUTPUT.PUT_LINE('Total LOCATIONS: ' || v_loc_count);
    DBMS_OUTPUT.PUT_LINE('Total COUNTRIES: ' || v_ctry_count);

END;
/


