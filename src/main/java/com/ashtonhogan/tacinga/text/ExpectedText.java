package com.ashtonhogan.tacinga.text;

import java.io.IOException;
import org.cactoos.Scalar;
import org.cactoos.Text;
import org.cactoos.scalar.IoCheckedScalar;
import org.cactoos.text.JoinedText;
import org.cactoos.text.TextOf;
import org.cactoos.text.UncheckedText;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class ExpectedText implements Text {

    private final Scalar<String> origin;

    public ExpectedText(final PrefixText prefixText, final Text text) {
        this(
                () -> new JoinedText(
                        new TextOf(" "),
                        new TextOf("Expected:"),
                        prefixText,
                        text
                ).asString()
        );
    }

    private ExpectedText(final Scalar<String> origin) {
        this.origin = origin;
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
