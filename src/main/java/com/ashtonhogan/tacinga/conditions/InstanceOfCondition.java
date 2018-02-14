package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.ActualText;
import com.ashtonhogan.tacinga.text.ExpectedText;
import com.ashtonhogan.tacinga.text.PrefixText;
import com.ashtonhogan.tacinga.unit.ObjectUnit;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class InstanceOfCondition implements Condition {

    private final PrefixText prefixText;
    private final ObjectUnit actual;
    private final ObjectUnit expected;

    public InstanceOfCondition(final ObjectUnit actual, final ObjectUnit expected) {
        this(
                new PrefixText(""),
                actual,
                expected
        );
    }

    public InstanceOfCondition(final PrefixText prefixText, final ObjectUnit actual, final ObjectUnit expected) {
        this.prefixText = prefixText;
        this.actual = actual;
        this.expected = expected;
    }

    @Override
    public ExpectedText expected() throws Exception {
        return new ExpectedText(this.prefixText, this.expected.asText());
    }

    @Override
    public ActualText actual() throws Exception {
        return new ActualText(this.prefixText, this.actual.asText());
    }

    @Override
    public Boolean conforms() throws Exception {
        return this.actual.asValue().getClass().isInstance(this.expected.asValue());
    }

}
