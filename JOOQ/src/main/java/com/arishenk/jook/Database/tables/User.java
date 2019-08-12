/*
 * This file is generated by jOOQ.
 */
package com.arishenk.jook.Database.tables;


import com.arishenk.jook.Database.DefaultSchema;
import com.arishenk.jook.Database.tables.records.UserRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User extends TableImpl<UserRecord> {

    private static final long serialVersionUID = 841858118;

    /**
     * The reference instance of <code>User</code>
     */
    public static final User USER = new User();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRecord> getRecordType() {
        return UserRecord.class;
    }

    /**
     * The column <code>User.id</code>.
     */
    public final TableField<UserRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>User.email</code>.
     */
    public final TableField<UserRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>User.fio</code>.
     */
    public final TableField<UserRecord, String> FIO = createField("fio", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>User.phone</code>.
     */
    public final TableField<UserRecord, String> PHONE = createField("phone", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>User.passport_id</code>.
     */
    public final TableField<UserRecord, Long> PASSPORT_ID = createField("passport_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>User.person_id</code>.
     */
    public final TableField<UserRecord, Integer> PERSON_ID = createField("person_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>User</code> table reference
     */
    public User() {
        this(DSL.name("User"), null);
    }

    /**
     * Create an aliased <code>User</code> table reference
     */
    public User(String alias) {
        this(DSL.name(alias), USER);
    }

    /**
     * Create an aliased <code>User</code> table reference
     */
    public User(Name alias) {
        this(alias, USER);
    }

    private User(Name alias, Table<UserRecord> aliased) {
        this(alias, aliased, null);
    }

    private User(Name alias, Table<UserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UserRecord> getPrimaryKey() {
        return Internal.createUniqueKey(com.arishenk.jook.Database.tables.User.USER, "KEY_User_PRIMARY", com.arishenk.jook.Database.tables.User.USER.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UserRecord>> getKeys() {
        return Arrays.<UniqueKey<UserRecord>>asList(
              Internal.createUniqueKey(com.arishenk.jook.Database.tables.User.USER, "KEY_User_PRIMARY", com.arishenk.jook.Database.tables.User.USER.ID)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User as(String alias) {
        return new User(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User as(Name alias) {
        return new User(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(String name) {
        return new User(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(Name name) {
        return new User(name, null);
    }
}