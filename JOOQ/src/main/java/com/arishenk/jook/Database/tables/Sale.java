/*
 * This file is generated by jOOQ.
 */
package com.arishenk.jook.Database.tables;


import com.arishenk.jook.Database.DefaultSchema;
import com.arishenk.jook.Database.tables.records.SaleRecord;

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
public class Sale extends TableImpl<SaleRecord> {

    private static final long serialVersionUID = 302290947;

    /**
     * The reference instance of <code>Sale</code>
     */
    public static final Sale SALE = new Sale();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SaleRecord> getRecordType() {
        return SaleRecord.class;
    }

    /**
     * The column <code>Sale.cost</code>.
     */
    public final TableField<SaleRecord, Double> COST = createField("cost", org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>Sale.items</code>.
     */
    public final TableField<SaleRecord, byte[]> ITEMS = createField("items", org.jooq.impl.SQLDataType.BLOB, this, "");

    /**
     * Create a <code>Sale</code> table reference
     */
    public Sale() {
        this(DSL.name("Sale"), null);
    }

    /**
     * Create an aliased <code>Sale</code> table reference
     */
    public Sale(String alias) {
        this(DSL.name(alias), SALE);
    }

    /**
     * Create an aliased <code>Sale</code> table reference
     */
    public Sale(Name alias) {
        this(alias, SALE);
    }

    private Sale(Name alias, Table<SaleRecord> aliased) {
        this(alias, aliased, null);
    }

    private Sale(Name alias, Table<SaleRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<SaleRecord> getPrimaryKey() {
        return Internal.createUniqueKey(com.arishenk.jook.Database.tables.Sale.SALE, "KEY_Sale_PRIMARY", com.arishenk.jook.Database.tables.Sale.SALE.COST);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SaleRecord>> getKeys() {
        return Arrays.<UniqueKey<SaleRecord>>asList(
              Internal.createUniqueKey(com.arishenk.jook.Database.tables.Sale.SALE, "KEY_Sale_PRIMARY", com.arishenk.jook.Database.tables.Sale.SALE.COST)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sale as(String alias) {
        return new Sale(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sale as(Name alias) {
        return new Sale(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Sale rename(String name) {
        return new Sale(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Sale rename(Name name) {
        return new Sale(name, null);
    }
}