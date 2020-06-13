package com.github.jolice.citron.assertion;

import java.util.Objects;

public class FunctionAssertion {

    private final Runnable task;

    public FunctionAssertion(Runnable task) {
        this.task = Objects.requireNonNull(task, "Task can not be null");
    }

    public void completesNormally() {
        try {
            task.run();
        } catch (Throwable e) {
            throw new AssertionError("Execution failed with exception", e);
        }
    }

    public void doesThrow(Class<? extends Throwable> exceptionType) {
        try {
            task.run();
            throw new AssertionError("No exception was fired");
        } catch (Throwable e) {
            if (!exceptionType.equals(e.getClass())) {
                throw new AssertionError("Expected - " + exceptionType + " got - " + e.getClass());
            }
        }
    }


}
