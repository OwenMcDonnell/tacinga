package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.FailureText;
import com.ashtonhogan.tacinga.unit.ObjectUnit;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class NotEqualCondition implements Condition {

    private final ObjectUnit objectUnit;

    public NotEqualCondition(final ObjectUnit objectUnit) {
        this.objectUnit = objectUnit;
    }

    @Override
    public FailureText failureText() throws Exception {
        return this.objectUnit.failureText();
    }

    @Override
    public Boolean conforms() throws Exception {
        if (this.objectUnit.actual() == null) {
            return this.objectUnit.expected() == null;
        }
        return (!this.objectUnit.actual().equals(this.objectUnit.expected()));
    }

}
