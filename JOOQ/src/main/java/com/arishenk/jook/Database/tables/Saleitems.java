/*
 * This file is generated by jOOQ.
 */
package com.arishenk.jook.Database.tables;


import com.arishenk.jook.Database.DefaultSchema;
import com.arishenk.jook.Database.tables.records.SaleitemsRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
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
public class Saleitems extends TableImpl<SaleitemsRecord> {

    private static final long serialVersionUID = -996107953;

    /**
     * The reference instance of <code>SALEITEMS</code>
     */
    public static final Saleitems SALEITEMS = new Saleitems();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SaleitemsRecord> getRecordType() {
        return SaleitemsRecord.class;
    }

    /**
     * The column <code>SALEITEMS.id</code>.
     */
    public final TableField<SaleitemsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>SALEITEMS.id_sale</code>.
     */
    public final TableField<SaleitemsRecord, Integer> ID_SALE = createField("id_sale", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>SALEITEMS.item</code>.
     */
    public final TableField<SaleitemsRecord, String> ITEM = createField("item", org.jooq.impl.SQLDataType.VARCHAR(12), this, "");

    /**
     * Create a <code>SALEITEMS</code> table reference
     */
    public Saleitems() {
        this(DSL.name("SALEITEMS"), null);
    }

    /**
     * Create an aliased <code>SALEITEMS</code> table reference
     */
    public Saleitems(String alias) {
        this(DSL.name(alias), SALEITEMS);
    }

    /**
     * Create an aliased <code>SALEITEMS</code> table reference
     */
    public Saleitems(Name alias) {
        this(alias, SALEITEMS);
    }

    private Saleitems(Name alias, Table<SaleitemsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Saleitems(Name alias, Table<SaleitemsRecord> aliased, Field<?>[] parameters) {
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
    public Identity<SaleitemsRecord, Integer> getIdentity() {
        return Internal.createIdentity(com.arishenk.jook.Database.tables.Saleitems.SALEITEMS, com.arishenk.jook.Database.tables.Saleitems.SALEITEMS.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SaleitemsRecord> getPrimaryKey() {
        return Internal.createUniqueKey(com.arishenk.jook.Database.tables.Saleitems.SALEITEMS, "KEY_SALEITEMS_PRIMARY", com.arishenk.jook.Database.tables.Saleitems.SALEITEMS.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SaleitemsRecord>> getKeys() {
        return Arrays.<UniqueKey<SaleitemsRecord>>asList(
              Internal.createUniqueKey(com.arishenk.jook.Database.tables.Saleitems.SALEITEMS, "KEY_SALEITEMS_PRIMARY", com.arishenk.jook.Database.tables.Saleitems.SALEITEMS.ID)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Saleitems as(String alias) {
        return new Saleitems(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Saleitems as(Name alias) {
        return new Saleitems(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Saleitems rename(String name) {
        return new Saleitems(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Saleitems rename(Name name) {
        return new Saleitems(name, null);
    }
}
