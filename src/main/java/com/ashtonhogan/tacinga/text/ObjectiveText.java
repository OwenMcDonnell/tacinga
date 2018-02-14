package com.ashtonhogan.tacinga.text;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.cactoos.Scalar;
import org.cactoos.Text;
import org.cactoos.scalar.IoCheckedScalar;
import org.cactoos.text.UncheckedText;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public class ObjectiveText implements Text {

    private final Scalar<String> origin;

    public ObjectiveText(final String input) {
        this(input, StandardCharsets.UTF_8);
    }

    public ObjectiveText(final String input, final Charset cset) {
        this(() -> new String(input.getBytes(cset), cset));
    }

    private ObjectiveText(final Scalar<String> scalar) {
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
