package com.cimarasah.chupchup.DAO;

public class ScriptDDL {

    public status String getCreateTableClient(){

        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS TB_CLIENTE{ ");
        sql.append("ID      INTEGER       PRIMARY KEY  AUTOINCREMENT NOT NULL, ");
        sql.append("NOME    VARCHAR(250)  NOT NULL DEFAULT (' '), ");
        sql.append("CODIGO  VARCHAR(250)  NOT NULL DEFAULT (' '), ");

    }
}
