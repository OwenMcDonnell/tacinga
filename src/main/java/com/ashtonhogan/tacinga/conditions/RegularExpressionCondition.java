package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.ActualText;
import com.ashtonhogan.tacinga.text.ExpectedText;
import com.ashtonhogan.tacinga.text.PrefixText;
import com.ashtonhogan.tacinga.unit.StringUnit;
import java.util.regex.Pattern;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class RegularExpressionCondition implements Condition {

    private final PrefixText prefixText;
    private final StringUnit actual;
    private final StringUnit pattern;

    public RegularExpressionCondition(final StringUnit actual, final StringUnit pattern) {
        this(
                new PrefixText(""),
                actual,
                pattern
        );
    }

    public RegularExpressionCondition(final PrefixText prefixText, final StringUnit actual, final StringUnit pattern) {
        this.prefixText = prefixText;
        this.actual = actual;
        this.pattern = pattern;
    }

    @Override
    public ExpectedText expected() throws Exception {
        return new ExpectedText(this.prefixText, this.pattern.asText());
    }

    @Override
    public ActualText actual() throws Exception {
        return new ActualText(this.prefixText, this.actual.asText());
    }

    @Override
    public Boolean conforms() throws Exception {
        if ((this.actual.asValue() == null) || (this.pattern.asValue() == null)) {
            return Boolean.FALSE;
        }
        return Pattern.compile(this.pattern.asValue()).matcher(this.actual.asValue()).matches();
    }

}
