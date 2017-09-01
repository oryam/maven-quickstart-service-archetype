CREATE SEQUENCE "S_ITEM_ID";

-- be careful with reserved word such as order, comment
CREATE TABLE "T_ITEM_APP"
  (
    "ID"          NUMBER(12,0),
    "CODE"        VARCHAR2(100 CHAR),
    "LABEL"       VARCHAR2(255 CHAR),
    "VALUE"       NUMBER(38,20),
    "RANK"        NUMBER(3,0),
    "ACTIVE"      NUMBER(1,0) DEFAULT 1,
    "START_DATE"  DATE,
    "AUDIT_TIME"  TIMESTAMP (6)
  );

COMMENT ON TABLE "T_ITEM_APP" IS 'Example of table for Items data';
COMMENT ON COLUMN "T_ITEM_APP"."ID" IS 'Technical identifier, auto generated';
COMMENT ON COLUMN "T_ITEM_APP"."CODE" IS 'Unique code of item';
COMMENT ON COLUMN "T_ITEM_APP"."LABEL" IS 'Label of item';
COMMENT ON COLUMN "T_ITEM_APP"."VALUE" IS 'Value of item';
COMMENT ON COLUMN "T_ITEM_APP"."RANK" IS 'Optional ordering of item';
COMMENT ON COLUMN "T_ITEM_APP"."ACTIVE" IS 'Enable or disable status';
COMMENT ON COLUMN "T_ITEM_APP"."START_DATE" IS 'Start date of the item';
COMMENT ON COLUMN "T_ITEM_APP"."AUDIT_TIME" IS 'Tracking time';
