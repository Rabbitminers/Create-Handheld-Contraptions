package com.rabbitminers.handheldcontraptions.tools.instance;

import com.rabbitminers.handheldcontraptions.generators.BaseGenerator;
import com.rabbitminers.handheldcontraptions.generators.IToolGenerator;

public interface IToolBaseInstance {
    default boolean isToolComplete() {
        return false;
    }

    default IToolGenerator getGenerator() {return new BaseGenerator(0);}

    default float getMaximumStressOutput() {
        return 0.0f;
    }

    default float getStressOutput() {
        return 0.0f;
    }

    default float getRotationalSpeed() {
        return 0.0f;
    }
}
