package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.FailureText;
import com.ashtonhogan.tacinga.unit.ListUnit;
import java.util.List;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class NotEqualListCondition<T> implements Condition {

    private final ListUnit<T> listUnit;

    public NotEqualListCondition(final ListUnit<T> listUnit) {
        this.listUnit = listUnit;
    }

    @Override
    public FailureText failureText() throws Exception {
        return this.listUnit.failureText();
    }

    @Override
    public Boolean conforms() throws Exception {
        if (this.listUnit.actual() == null) {
            return this.listUnit.expected() == null;
        }
        if (this.listUnit.expected() != null
                && this.listUnit.actual().getClass().isAssignableFrom(List.class)
                && this.listUnit.expected().getClass().isAssignableFrom(List.class)) {
            return (!this.listUnit.actual().equals(this.listUnit.expected()));
        } else {
            return Boolean.FALSE;
        }
    }

}
