USE kontenplan_db;

DELIMITER $$

CREATE TRIGGER trg_gl_before_insert
    BEFORE INSERT ON gl_accounts
    FOR EACH ROW
    BEGIN
        IF CHAR_LENGTH(NEW.no) > 1 THEN
            SET NEW.parent_no = LEFT(NEW.no, CHAR_LENGTH(NEW.no) -1);
            SET New.type = 'account';
        ELSE
            SET NEW.type = 'class';
            SET NEW.parent_no = NULL;
        END IF;
    END $$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER trg_gl_before_update
    BEFORE UPDATE ON gl_accounts
    FOR EACH ROW
    BEGIN
        IF NEW.no <> OLD.no OR New.parent_no <> OLD.parent_no THEN
            IF CHAR_LENGTH(NEW.no) > 1 THEN
                SET NEW.parent_no = LEFT(NEW.no, CHAR_LENGTH(NEW.no) - 1);
                SET NEW.type = 'account';
            ELSE
                SET NEW.parent_no = NULL;
                SET NEW.type = 'class';
            END IF;
        END IF;
    END $$

DELIMITER ;