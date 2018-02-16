package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.FailureText;
import com.ashtonhogan.tacinga.unit.FileUnit;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class NotExistingFileCondition implements Condition {

    private final FileUnit fileUnit;

    public NotExistingFileCondition(final FileUnit fileUnit) {
        this.fileUnit = fileUnit;
    }

    @Override
    public FailureText failureText() throws Exception {
        return this.fileUnit.failureText();
    }

    @Override
    public Boolean conforms() throws Exception {
        return (!this.fileUnit.actual().exists());
    }

}
