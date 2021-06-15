package edu.school21.impl;

import edu.school21.models.PreProcessor;
import edu.school21.models.Renderer;

public class RendererErrImpl implements Renderer {
    private boolean StandartOutput;
    private boolean ToUpper;
    public RendererErrImpl(PreProcessor preProcessor)
    {
        this.StandartOutput = false;
        this.ToUpper = preProcessor.isToUpper();
    }

    public boolean isStandartOutput() {
        return StandartOutput;
    }

    public boolean isToUpper() {
        return ToUpper;
    }
}
