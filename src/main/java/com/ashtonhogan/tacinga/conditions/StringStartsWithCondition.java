package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.ActualText;
import com.ashtonhogan.tacinga.text.ExpectedText;
import com.ashtonhogan.tacinga.text.PrefixText;
import com.ashtonhogan.tacinga.unit.StringUnit;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class StringStartsWithCondition implements Condition {

    private final PrefixText prefixText;
    private final StringUnit actual;
    private final StringUnit startsWith;

    public StringStartsWithCondition(final StringUnit expected, final StringUnit actual) {
        this(
                new PrefixText(""),
                expected,
                actual
        );
    }

    public StringStartsWithCondition(final PrefixText prefixText, final StringUnit string, final StringUnit startsWith) {
        this.prefixText = prefixText;
        this.actual = string;
        this.startsWith = startsWith;
    }

    @Override
    public ExpectedText expected() throws Exception {
        return new ExpectedText(this.prefixText, this.startsWith.asText());
    }

    @Override
    public ActualText actual() throws Exception {
        return new ActualText(this.prefixText, this.actual.asText());
    }

    @Override
    public Boolean conforms() throws Exception {
        if ((this.actual.asValue() == null) || (this.startsWith.asValue() == null)) {
            return Boolean.FALSE;
        }
        return this.actual.asValue().startsWith(this.startsWith.asValue());
    }

}
