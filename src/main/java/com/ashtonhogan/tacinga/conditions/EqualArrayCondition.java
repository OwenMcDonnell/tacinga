package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.ActualText;
import com.ashtonhogan.tacinga.text.ExpectedText;
import com.ashtonhogan.tacinga.text.PrefixText;
import com.ashtonhogan.tacinga.unit.ArrayUnit;
import java.util.Arrays;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class EqualArrayCondition implements Condition {

    private final PrefixText prefixText;
    private final ArrayUnit expected;
    private final ArrayUnit actual;

    public EqualArrayCondition(final ArrayUnit expected, final ArrayUnit actual) {
        this(
                new PrefixText(""),
                expected,
                actual
        );
    }

    public EqualArrayCondition(final PrefixText prefixText, final ArrayUnit expected, final ArrayUnit actual) {
        this.prefixText = prefixText;
        this.expected = expected;
        this.actual = actual;
    }

    @Override
    public ExpectedText expected() throws Exception {
        return new ExpectedText(prefixText, this.expected.asText());
    }

    @Override
    public ActualText actual() throws Exception {
        return new ActualText(prefixText, this.actual.asText());
    }

    @Override
    public Boolean conforms() throws Exception {
        if (this.actual.asValue() == null) {
            return this.expected.asValue() == null;
        }
        if (this.expected.asValue() != null
                && this.actual.asValue().getClass().isArray()
                && this.expected.asValue().getClass().isArray()) {
            return Arrays.deepEquals(this.actual.asValue(), this.expected.asValue());
        } else {
            return Boolean.FALSE;
        }
    }

}
