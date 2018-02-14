package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.ActualText;
import com.ashtonhogan.tacinga.text.ExpectedText;
import com.ashtonhogan.tacinga.text.PrefixText;
import com.ashtonhogan.tacinga.unit.StringUnit;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class StringContainsCondition implements Condition {

    private final PrefixText prefixText;
    private final StringUnit actual;
    private final StringUnit contains;

    public StringContainsCondition(final StringUnit actual, final StringUnit contains) {
        this(
                new PrefixText(""),
                actual,
                contains
        );
    }

    public StringContainsCondition(final PrefixText prefixText, final StringUnit actual, final StringUnit contains) {
        this.prefixText = prefixText;
        this.actual = actual;
        this.contains = contains;
    }

    @Override
    public ExpectedText expected() throws Exception {
        return new ExpectedText(this.prefixText, this.contains.asText());
    }

    @Override
    public ActualText actual() throws Exception {
        return new ActualText(this.prefixText, this.actual.asText());
    }

    @Override
    public Boolean conforms() throws Exception {
        if ((this.actual.asValue() == null) || (this.contains.asValue() == null)) {
            return Boolean.FALSE;
        }
        return this.actual.asValue().contains(this.contains.asValue());
    }

}
