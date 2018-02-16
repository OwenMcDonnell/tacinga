package com.ashtonhogan.tacinga.unit;

import java.util.List;

public interface ListUnit<T> extends Unit {

    public List<T> expected() throws Exception;

    public List<T> actual() throws Exception;
}
