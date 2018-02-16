package com.ashtonhogan.tacinga.conditions;

import com.ashtonhogan.tacinga.Condition;
import com.ashtonhogan.tacinga.text.FailureText;
import com.ashtonhogan.tacinga.unit.FileUnit;

@SuppressWarnings({"FinalClass", "ClassWithoutLogger"})
public final class NotEmptyFolderCondition implements Condition {

    private final FileUnit fileUnit;

    public NotEmptyFolderCondition(final FileUnit fileUnit) {
        this.fileUnit = fileUnit;
    }

    @Override
    public FailureText failureText() throws Exception {
        return this.fileUnit.failureText();
    }

    @Override
    public Boolean conforms() throws Exception {
        return this.fileUnit.actual() != null
                && this.fileUnit.actual().exists()
                && this.fileUnit.actual().isDirectory()
                && this.fileUnit.actual().listFiles().length > 0;
    }

}
