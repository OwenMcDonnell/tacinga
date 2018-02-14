package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.ActualText;
import com.ashtonhogan.tacinga.text.ExpectedText;
import com.ashtonhogan.tacinga.text.PrefixText;
import org.cactoos.text.JoinedText;
import org.cactoos.text.TextOf;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class AndCondition implements Condition {

    private final PrefixText prefixText;
    private final Condition[] conditions;

    public AndCondition(final Condition... conditions) {
        this(
                new PrefixText(""),
                conditions
        );
    }

    public AndCondition(final PrefixText prefixText, final Condition... conditions) {
        this.prefixText = prefixText;
        this.conditions = conditions;
    }

    @Override
    public ExpectedText expected() throws Exception {
        ExpectedText expectedTexts[] = new ExpectedText[this.conditions.length];
        for (int i = 0; i < this.conditions.length; i++) {
            expectedTexts[i] = new ExpectedText(this.prefixText, this.conditions[i].expected());
        }
        return new ExpectedText(
                this.prefixText,
                new JoinedText(
                        new TextOf("\n\n"), expectedTexts
                )
        );
    }

    @Override
    public ActualText actual() throws Exception {
        ActualText actualTexts[] = new ActualText[this.conditions.length];
        for (int i = 0; i < this.conditions.length; i++) {
            actualTexts[i] = new ActualText(this.prefixText, this.conditions[i].expected());
        }
        return new ActualText(
                this.prefixText,
                new JoinedText(
                        new TextOf("\n\n"), actualTexts
                )
        );
    }

    @Override
    public Boolean conforms() throws Exception {
        for (Condition condition : this.conditions) {
            if (!condition.conforms()) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}
