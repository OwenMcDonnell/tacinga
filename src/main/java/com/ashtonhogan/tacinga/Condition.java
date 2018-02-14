package com.ashtonhogan.tacinga;

import com.ashtonhogan.tacinga.text.ActualText;
import com.ashtonhogan.tacinga.text.ExpectedText;

public interface Condition {

    public ExpectedText expected() throws Exception;

    public ActualText actual() throws Exception;

    public Boolean conforms() throws Exception;
}
