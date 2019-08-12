/*
 * This file is generated by jOOQ.
 */
package com.arishenk.jook.Database.tables.records;


import com.arishenk.jook.Database.tables.Passports;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class PassportsRecord extends UpdatableRecordImpl<PassportsRecord> implements Record2<Long, String> {

    private static final long serialVersionUID = -1681772326;

    /**
     * Setter for <code>passports.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>passports.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>passports.registration</code>.
     */
    public void setRegistration(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>passports.registration</code>.
     */
    public String getRegistration() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Passports.PASSPORTS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Passports.PASSPORTS.REGISTRATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getRegistration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getRegistration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PassportsRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PassportsRecord value2(String value) {
        setRegistration(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PassportsRecord values(Long value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PassportsRecord
     */
    public PassportsRecord() {
        super(Passports.PASSPORTS);
    }

    /**
     * Create a detached, initialised PassportsRecord
     */
    public PassportsRecord(Long id, String registration) {
        super(Passports.PASSPORTS);

        set(0, id);
        set(1, registration);
    }
}