package edu.school21.impl;

import edu.school21.models.PreProcessor;
import edu.school21.models.Renderer;

public class RendererStandartImpl implements Renderer {
    private boolean StandartOutput;
    private boolean ToUpper;
    public RendererStandartImpl(PreProcessor preProcessor)
    {
        this.StandartOutput = true;
    }

    public boolean isStandartOutput() {
        return StandartOutput;
    }

    public boolean isToUpper() {
        return ToUpper;
    }
}
