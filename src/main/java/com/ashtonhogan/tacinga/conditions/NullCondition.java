package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.ActualText;
import com.ashtonhogan.tacinga.text.ExpectedText;
import com.ashtonhogan.tacinga.text.PrefixText;
import com.ashtonhogan.tacinga.unit.ObjectUnit;
import org.cactoos.text.TextOf;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class NullCondition implements Condition {

    private final PrefixText prefixText;
    private final ObjectUnit actual;

    public NullCondition(final ObjectUnit actual) {
        this(
                new PrefixText(""),
                actual
        );
    }

    public NullCondition(final PrefixText prefixText, final ObjectUnit actual) {
        this.prefixText = prefixText;
        this.actual = actual;
    }

    @Override
    public ExpectedText expected() throws Exception {
        return new ExpectedText(this.prefixText, new TextOf("null"));
    }

    @Override
    public ActualText actual() throws Exception {
        return new ActualText(this.prefixText, this.actual.asText());
    }

    @Override
    public Boolean conforms() throws Exception {
        return this.actual.asValue() == null;
    }

}
