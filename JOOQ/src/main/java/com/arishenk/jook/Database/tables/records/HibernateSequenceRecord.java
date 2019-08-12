/*
 * This file is generated by jOOQ.
 */
package com.arishenk.jook.Database.tables.records;


import com.arishenk.jook.Database.tables.HibernateSequence;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
import org.jooq.impl.TableRecordImpl;


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
public class HibernateSequenceRecord extends TableRecordImpl<HibernateSequenceRecord> implements Record1<Long> {

    private static final long serialVersionUID = 805659949;

    /**
     * Setter for <code>hibernate_sequence.next_val</code>.
     */
    public void setNextVal(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>hibernate_sequence.next_val</code>.
     */
    public Long getNextVal() {
        return (Long) get(0);
    }

    // -------------------------------------------------------------------------
    // Record1 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<Long> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<Long> valuesRow() {
        return (Row1) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return HibernateSequence.HIBERNATE_SEQUENCE.NEXT_VAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getNextVal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getNextVal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HibernateSequenceRecord value1(Long value) {
        setNextVal(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HibernateSequenceRecord values(Long value1) {
        value1(value1);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached HibernateSequenceRecord
     */
    public HibernateSequenceRecord() {
        super(HibernateSequence.HIBERNATE_SEQUENCE);
    }

    /**
     * Create a detached, initialised HibernateSequenceRecord
     */
    public HibernateSequenceRecord(Long nextVal) {
        super(HibernateSequence.HIBERNATE_SEQUENCE);

        set(0, nextVal);
    }
}
