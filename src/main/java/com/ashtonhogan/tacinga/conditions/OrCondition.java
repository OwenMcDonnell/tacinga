package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.FailureText;
import org.cactoos.collection.Mapped;
import org.cactoos.iterable.IterableOf;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class OrCondition implements Condition {

    private final Condition[] conditions;

    public OrCondition(final Condition... conditions) {
        this.conditions = conditions;
    }

    @Override
    public FailureText failureText() throws Exception {
        return new FailureText(
                new Mapped<>(
                        input -> input.failureText(),
                        new IterableOf<>(this.conditions)
                )
        );
    }

    @Override
    public Boolean conforms() throws Exception {
        for (Condition condition : this.conditions) {
            if (condition.conforms()) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

}
