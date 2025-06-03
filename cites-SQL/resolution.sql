/*
 *   ISEL-DEETC-SisInf
 *   ND 2022-2025
 *
 *   
 *   Information Systems Project - Active Databases
 *   
 */

/* ### DO NOT REMOVE THE QUESTION MARKERS ### */


-- region Question 1.a
CREATE OR REPLACE FUNCTION check_scooter_in_dock()
RETURNS TRIGGER AS $$
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM DOCK
        WHERE scooter = NEW.scooter AND state = 'occupy'
    ) THEN
        RAISE EXCEPTION 'A trotineta % não está numa doca ocupada', NEW.scooter;
END IF;
RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE TRIGGER trg_check_scooter_in_dock
BEFORE INSERT ON TRAVEL
FOR EACH ROW
WHEN (NEW.scooter IS NOT NULL)
EXECUTE FUNCTION check_scooter_in_dock();
-- endregion




-- region Question 1.b
CREATE OR REPLACE FUNCTION check_one_ongoing_trip()
RETURNS TRIGGER AS $$
BEGIN
    -- Verifica se o utilizador já tem uma viagem a decorrer
    IF EXISTS (
        SELECT 1 FROM TRAVEL
        WHERE client = NEW.client AND dfinal IS NULL
    ) THEN
        RAISE EXCEPTION 'O utilizador % já tem uma viagem a decorrer', NEW.client;
END IF;

    -- Verifica se a trotineta já está a ser usada numa viagem
    IF EXISTS (
        SELECT 1 FROM TRAVEL
        WHERE scooter = NEW.scooter AND dfinal IS NULL
    ) THEN
        RAISE EXCEPTION 'A trotineta % já está a ser usada numa viagem a decorrer', NEW.scooter;
END IF;

RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE TRIGGER trg_check_one_ongoing_trip
BEFORE INSERT ON TRAVEL
FOR EACH ROW
EXECUTE FUNCTION check_one_ongoing_trip();
-- endregion



-- region Question 2
CREATE OR REPLACE FUCTION fx-dock-occupancy(stationkid integer)
RETURNS NUMERIC AS $$
DECLARE
total INTEGER;
    ocupados INTEGER;
BEGIN
SELECT COUNT(*) INTO total FROM DOCK WHERE station = stationkid;
IF total = 0 THEN
        RETURN 0;
END IF;
SELECT COUNT(*) INTO ocupados FROM DOCK WHERE station = stationkid AND state = 'occupy';
RETURN ocupados::NUMERIC / total;
END;
$$ LANGUAGE plpgsql;
-- endregion




-- region Question 3
CREATE OR REPLACE VIEW RIDER
AS
SELECT p.*,c.dtregister,cd.id AS cardid,cd.credit,cd.typeofcard
FROM CLIENT c INNER JOIN PERSON p ON (c.person=p.id)
              INNER JOIN CARD cd ON (cd.client = c.person);


-- Trigger INSTEAD OF INSERT para a view RIDER
CREATE OR REPLACE FUNCTION fx_insert_rider()
RETURNS TRIGGER AS $$
BEGIN
INSERT INTO PERSON(id, email, taxnumber, name)
VALUES (NEW.id, NEW.email, NEW.taxnumber, NEW.name);

INSERT INTO CLIENT(person, dtregister)
VALUES (NEW.id, NEW.dtregister);

INSERT INTO CARD(id, credit, typeofcard, client)
VALUES (NEW.cardid, NEW.credit, NEW.typeofcard, NEW.id);

RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_insert_rider
    INSTEAD OF INSERT ON RIDER
    FOR EACH ROW
    EXECUTE FUNCTION fx_insert_rider();




-- Trigger INSTEAD OF UPDATE para a view RIDER
CREATE OR REPLACE FUNCTION fx_update_rider()
RETURNS TRIGGER AS $$
BEGIN
UPDATE PERSON
SET email = NEW.email,
    taxnumber = NEW.taxnumber,
    name = NEW.name
WHERE id = OLD.id;

UPDATE CLIENT
SET dtregister = NEW.dtregister
WHERE person = OLD.id;

UPDATE CARD
SET credit = NEW.credit,
    typeofcard = NEW.typeofcard
WHERE id = OLD.cardid;

RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_update_rider
    INSTEAD OF UPDATE ON RIDER
    FOR EACH ROW
    EXECUTE FUNCTION fx_update_rider();




-- region Question 4
CREATE OR REPLACE PROCEDURE startTrip(dockid integer, clientid  integer)
LANGUAGE plpgsql
AS $$
DECLARE
scooter_id INTEGER;
    station_id INTEGER;
    now_time TIMESTAMP := NOW();
BEGIN
    -- Obtem a trotineta da doca
SELECT scooter, station INTO scooter_id, station_id
FROM DOCK
WHERE number = dockid AND state = 'occupy';

-- Atualiza a DOCK para estado livre
UPDATE DOCK
SET state = 'free',
    scooter = NULL,
    version = now_time
WHERE number = dockid;

-- Inicia a viagem
INSERT INTO TRAVEL (dinitial, client, scooter, stinitial)
VALUES (now_time, clientid, scooter_id, station_id);
END;
$$;
-- endregion