package com.ashtonhogan.tacinga.asserts;

import com.ashtonhogan.tacinga.Assertion;
import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.asserts.exception.ThatAssertionException;
import com.ashtonhogan.tacinga.text.ObjectiveText;
import com.ashtonhogan.tacinga.text.SuccessText;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cactoos.Scalar;
import org.cactoos.Text;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class ThatAssert implements Assertion {

    private final Scalar<Text> result;

    public ThatAssert(final ObjectiveText objectiveText, final Condition condition) {
        this(
                () -> {
                    if (!condition.conforms()) {
                        throw new ThatAssertionException(condition.failureText().asString());
                    } else {
                        return new SuccessText(objectiveText);
                    }
                }
        );
    }

    private ThatAssert(final Scalar<Text> result) {
        this.result = result;
    }

    @Override
    public void evaluate() throws Exception {
        Logger.getLogger(ThatAssert.class.getName()).log(Level.INFO, this.result.value().asString());
    }

}
