package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.ActualText;
import com.ashtonhogan.tacinga.text.ExpectedText;
import com.ashtonhogan.tacinga.text.PrefixText;
import com.ashtonhogan.tacinga.unit.StringUnit;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class StringEndsWithCondition implements Condition {

    private final PrefixText prefixText;
    private final StringUnit actual;
    private final StringUnit endsWith;

    public StringEndsWithCondition(final StringUnit actual, final StringUnit endsWith) {
        this(
                new PrefixText(""),
                actual,
                endsWith
        );
    }

    public StringEndsWithCondition(final PrefixText prefixText, final StringUnit actual, final StringUnit endsWith) {
        this.prefixText = prefixText;
        this.actual = actual;
        this.endsWith = endsWith;
    }

    @Override
    public ExpectedText expected() throws Exception {
        return new ExpectedText(this.prefixText, this.endsWith.asText());
    }

    @Override
    public ActualText actual() throws Exception {
        return new ActualText(this.prefixText, this.actual.asText());
    }

    @Override
    public Boolean conforms() throws Exception {
        if ((this.actual.asValue() == null) || (this.endsWith.asValue() == null)) {
            return Boolean.FALSE;
        }
        return this.actual.asValue().endsWith(this.endsWith.asValue());
    }

}
