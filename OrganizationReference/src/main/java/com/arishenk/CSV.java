package com.arishenk;

public interface CSV {
    String toCSV();
    void fromCSV(String str) throws TypeException;
}

