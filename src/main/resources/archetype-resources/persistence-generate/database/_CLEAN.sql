--------------------
-- CLEAN THE SCHEMA
--------------------
-- It can be used to rebuild the schema
-- Use the INIT script after
-- Add query to drop any new objects
--

--DROP TRIGGER "XXX";

DROP TABLE "T_ITEM_APP" CASCADE CONSTRAINTS PURGE;

DROP SEQUENCE "S_ITEM_ID";
