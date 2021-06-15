package edu.school21.impl;

import edu.school21.models.PreProcessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    private boolean toUpper;

    public PreProcessorToUpperImpl() {
        this.toUpper = true;
    }

    public boolean isToUpper() {
        return toUpper;
    }
}
