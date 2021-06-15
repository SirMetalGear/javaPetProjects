package edu.school21.impl;

import edu.school21.models.PreProcessor;

public class PreProcessorToLowerImpl implements PreProcessor {
    private boolean toUpper;

    public PreProcessorToLowerImpl() {
        this.toUpper = false;
    }

    public boolean isToUpper() {
        return toUpper;
    }
}
