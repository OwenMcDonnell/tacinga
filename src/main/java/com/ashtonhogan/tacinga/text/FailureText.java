package com.ashtonhogan.tacinga.text;

import com.ashtonhogan.tacinga.Condition;
import java.io.IOException;
import org.cactoos.Scalar;
import org.cactoos.Text;
import org.cactoos.collection.Mapped;
import org.cactoos.scalar.IoCheckedScalar;
import org.cactoos.text.JoinedText;
import org.cactoos.text.TextOf;
import org.cactoos.text.UncheckedText;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public class FailureText implements Text {

    private final Scalar<String> origin;

    public FailureText(final CauseText causeText, final ExpectedText expectedText, final ActualText actualText) {
        this(
                () -> new JoinedText(
                        new TextOf(" "),
                        causeText,
                        expectedText,
                        actualText
                ).asString()
        );
    }

    public FailureText(final Mapped<Condition, FailureText> mapped) {
        this(
                () -> new TextOf(mapped).asString()
        );
    }

    private FailureText(final Scalar<String> scalar) {
        this.origin = scalar;
    }

    @Override
    public String asString() throws IOException {
        return new IoCheckedScalar<>(this.origin).value();
    }

    @Override
    public String toString() {
        return new UncheckedText(this).asString();
    }
}
