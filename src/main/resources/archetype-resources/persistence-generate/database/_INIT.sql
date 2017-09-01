-------------------------
-- INITIALIZE THE SCHEMA
-------------------------
-- It can be used to rebuild the schema
-- Use the CLEAN script before
--

SET DEFINE OFF;

@_CREATE_TABLE.sql
@_ADD_CONSTRAINT.sql
@_INSERT_TABLE.sql
