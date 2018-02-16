package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.FailureText;
import com.ashtonhogan.tacinga.unit.MapUnit;
import java.util.Map;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class NotEqualMapCondition<K, V> implements Condition {

    private final MapUnit<K, V> mapUnit;

    public NotEqualMapCondition(final MapUnit<K, V> mapUnit) {
        this.mapUnit = mapUnit;
    }

    @Override
    public FailureText failureText() throws Exception {
        return this.mapUnit.failureText();
    }

    @Override
    public Boolean conforms() throws Exception {
        if (this.mapUnit.actual() == null) {
            return this.mapUnit.expected() == null;
        }
        if (this.mapUnit.expected() != null
                && this.mapUnit.actual().getClass().isAssignableFrom(Map.class)
                && this.mapUnit.expected().getClass().isAssignableFrom(Map.class)) {
            return (!this.mapUnit.actual().equals(this.mapUnit.expected()));
        } else {
            return Boolean.FALSE;
        }
    }

}
