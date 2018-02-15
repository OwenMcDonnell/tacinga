package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.FailureText;
import com.ashtonhogan.tacinga.unit.StringUnit;
import java.util.regex.Pattern;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class RegularExpressionCondition implements Condition {

    private final StringUnit stringUnit;

    public RegularExpressionCondition(final StringUnit stringUnit) {
        this.stringUnit = stringUnit;
    }

    @Override
    public FailureText failureText() throws Exception {
        return this.stringUnit.failureText();
    }

    @Override
    public Boolean conforms() throws Exception {
        if ((this.stringUnit.actual() == null) || (this.stringUnit.expected() == null)) {
            return Boolean.FALSE;
        }
        return Pattern.compile(this.stringUnit.expected()).matcher(this.stringUnit.actual()).matches();
    }

}
