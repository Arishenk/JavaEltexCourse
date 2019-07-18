package com.arishenk;

interface CSV {
    String toCSV();
    void fromCSV(String str) throws TypeException;
}

