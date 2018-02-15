package com.ashtonhogan.tacinga.unit;

public interface ObjectUnit extends Unit {

    public Object expected() throws Exception;

    public Object actual() throws Exception;
}
