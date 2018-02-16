package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.FailureText;
import com.ashtonhogan.tacinga.unit.SetUnit;
import java.util.Set;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class EqualSetCondition<T> implements Condition {

    private final SetUnit<T> setUnit;

    public EqualSetCondition(final SetUnit<T> setUnit) {
        this.setUnit = setUnit;
    }

    @Override
    public FailureText failureText() throws Exception {
        return this.setUnit.failureText();
    }

    @Override
    public Boolean conforms() throws Exception {
        if (this.setUnit.actual() == null) {
            return this.setUnit.expected() == null;
        }
        if (this.setUnit.expected() != null
                && this.setUnit.actual().getClass().isAssignableFrom(Set.class)
                && this.setUnit.expected().getClass().isAssignableFrom(Set.class)) {
            return this.setUnit.actual().equals(this.setUnit.expected());
        } else {
            return Boolean.FALSE;
        }
    }

}
