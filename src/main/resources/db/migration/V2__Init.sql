ALTER TABLE product
    ADD available BIT(1) NULL;

ALTER TABLE product
    MODIFY available BIT (1) NOT NULL;