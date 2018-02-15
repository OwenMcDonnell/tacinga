package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.FailureText;
import com.ashtonhogan.tacinga.unit.ArrayUnit;
import java.util.Arrays;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class EqualArrayCondition implements Condition {

    private final ArrayUnit arrayUnit;

    public EqualArrayCondition(final ArrayUnit arrayUnit) {
        this.arrayUnit = arrayUnit;
    }

    @Override
    public FailureText failureText() throws Exception {
        return this.arrayUnit.failureText();
    }

    @Override
    public Boolean conforms() throws Exception {
        if (this.arrayUnit.actual() == null) {
            return this.arrayUnit.expected() == null;
        }
        if (this.arrayUnit.expected() != null
                && this.arrayUnit.actual().getClass().isArray()
                && this.arrayUnit.expected().getClass().isArray()) {
            return Arrays.deepEquals(this.arrayUnit.actual(), this.arrayUnit.expected());
        } else {
            return Boolean.FALSE;
        }
    }

}
