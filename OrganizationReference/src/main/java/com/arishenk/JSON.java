package com.arishenk;

import java.io.IOException;

public interface JSON {
    String toJSON(String str) throws IOException;
    void fromJSON(String str) throws IOException;
}