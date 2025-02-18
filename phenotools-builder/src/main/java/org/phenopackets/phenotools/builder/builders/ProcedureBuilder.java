package org.phenopackets.phenotools.builder.builders;

import org.phenopackets.schema.v2.core.OntologyClass;
import org.phenopackets.schema.v2.core.Procedure;
import org.phenopackets.schema.v2.core.TimeElement;

import static org.phenopackets.phenotools.builder.builders.OntologyClassBuilder.ontologyClass;

public class ProcedureBuilder {

    private final Procedure.Builder builder;

    private ProcedureBuilder(OntologyClass procedure) {
        builder = Procedure.newBuilder().setCode(procedure);
    }

    public static Procedure procedure(OntologyClass procedure) {
        return Procedure.newBuilder().setCode(procedure).build();
    }

    public static Procedure procedure(String id, String label) {
        return procedure(ontologyClass(id, label));
    }

    public static ProcedureBuilder create(OntologyClass procedure) {
        return new ProcedureBuilder(procedure);
    }

    public static ProcedureBuilder create(String id, String label) {
        return new ProcedureBuilder(ontologyClass(id, label));
    }

    public ProcedureBuilder bodySite(OntologyClass site) {
        builder.setBodySite(site);
        return this;
    }

    public ProcedureBuilder performed(TimeElement timeElement) {
        builder.setPerformed(timeElement);
        return this;
    }

    public Procedure build() {
        return builder.build();
    }
}
