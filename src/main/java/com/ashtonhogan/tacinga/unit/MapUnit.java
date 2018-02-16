package com.ashtonhogan.tacinga.unit;

import java.util.Map;

public interface MapUnit<K, V> extends Unit {

    public Map<K, V> expected() throws Exception;

    public Map<K, V> actual() throws Exception;
}
