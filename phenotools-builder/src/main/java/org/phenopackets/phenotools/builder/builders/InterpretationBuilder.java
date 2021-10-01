package org.phenopackets.phenotools.builder.builders;

import org.phenopackets.schema.v2.core.Diagnosis;
import org.phenopackets.schema.v2.core.Interpretation;

public class InterpretationBuilder {

    private final Interpretation.Builder builder;

    public InterpretationBuilder(String id, Interpretation.ProgressStatus status) {
        builder = Interpretation.newBuilder().setId(id).setProgressStatus(status);
    }

    public InterpretationBuilder diagnosis(Diagnosis dx) {
        builder.setDiagnosis(dx);
        return this;
    }


    public InterpretationBuilder summary(String sm) {
        builder.setSummary(sm);
        return this;
    }


    public static InterpretationBuilder create(String id, Interpretation.ProgressStatus status) {
        return new InterpretationBuilder(id, status);
    }

    public static InterpretationBuilder inProgress(String id) {
        return create(id, Interpretation.ProgressStatus.IN_PROGRESS);
    }

    public static InterpretationBuilder completed(String id) {
        return create(id, Interpretation.ProgressStatus.COMPLETED);
    }

    public static InterpretationBuilder solved(String id) {
        return create(id, Interpretation.ProgressStatus.SOLVED);
    }

    public static InterpretationBuilder unsolved(String id) {
        return create(id, Interpretation.ProgressStatus.UNSOLVED);
    }

    public Interpretation build() {
        return builder.build();
    }


}