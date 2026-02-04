
--Tutorial PLSQL

-- Activar salida de mesnajes por terminal (hay que hacerlo en cada session)
SET SERVEROUTPUT ON;
-- Ejemplo de bloque anonimo
-- Busca el salario del empleado 150 y muestralo por terminal
DECLARE
    v_salario NUMBER;
BEGIN
    -- hago la select
    SELECT salary
    INTO v_salario
    FROM employees
    WHERE employee_id = 150;
    
    -- Mensaje por terminal
    DBMS_OUTPUT.PUT_LINE('El salario del 150 es ' || v_salario);
    
END;
/

-- Muestra el nombre y apellido del empleado 100
DECLARE
    v_fn VARCHAR2(200);
    v_ln VARCHAR2(200);
    
BEGIN

    --Busco
    SELECT first_name, last_name 
    INTO v_fn, v_ln
    FROM employees
    WHERE employee_id IN (100);
    
    --MUESTRO
    DBMS_OUTPUT.PUT_LINE('El nombre y apellido del 100 son'||' ' || v_fn||' '||v_ln);
END;
/
--Preocedimiento para simplificar la impersion de textos
CREATE OR REPLACE PROCEDURE p_print (texto VARCHAR2)
IS
    --Variables. Pero no necesito poner ahora.
BEGIN
    DBMS_OUTPUT.PUT_LINE(texto);
END;
/

-- Bloque anónimo de "hola mundo"

DECLARE
    v_texto VARCHAR2(200);
BEGIN
    v_texto := 'Hola Mundo';
    p_print(v_texto);
    --O te ahorras el declare y la variable y simplemente pones esto
   -- p_print('Hola Mundo');
END;

