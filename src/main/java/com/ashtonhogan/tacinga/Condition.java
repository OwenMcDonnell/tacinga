package com.ashtonhogan.tacinga;

import com.ashtonhogan.tacinga.text.FailureText;

public interface Condition {

    public FailureText failureText() throws Exception;

    public Boolean conforms() throws Exception;
}
