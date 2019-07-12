package com.arishenk;

import java.io.IOException;

interface JSON {
    String toJSON(String str) throws IOException;
    void fromJSON(String str) throws IOException;
}