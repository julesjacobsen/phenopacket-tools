package org.phenopackets.phenotools.builder.builders;

import org.phenopackets.schema.v2.core.Disease;
import org.phenopackets.schema.v2.core.OntologyClass;
import org.phenopackets.schema.v2.core.TimeElement;

import static org.phenopackets.phenotools.builder.builders.PhenoBuilder.ontologyClass;

public class DiseaseBuilder {

    private final Disease.Builder builder;

    public DiseaseBuilder(OntologyClass term) {
        builder = Disease.newBuilder().setTerm(term);
    }

    public DiseaseBuilder excluded() {
        builder.setExcluded(true);
        return this;
    }

    public DiseaseBuilder onset(TimeElement timeElement) {
        builder.setOnset(timeElement);
        return this;
    }

    public DiseaseBuilder resolution(TimeElement timeElement) {
        builder.setResolution(timeElement);
        return this;
    }

    public DiseaseBuilder addDiseaseStage(OntologyClass stage) {
        builder.addDiseaseStage(stage);
        return this;
    }


    public DiseaseBuilder clinicalTnmFinding(OntologyClass tnmFinding) {
        builder.addClinicalTnmFinding(tnmFinding);
        return this;
    }
    public DiseaseBuilder primarySite(OntologyClass site) {
        builder.setPrimarySite(site);
        return this;
    }

    public DiseaseBuilder laterality(OntologyClass laterality) {
        builder.setLaterality(laterality);
        return this;
    }

    public Disease build() {
        return builder.build();
    }

    public static DiseaseBuilder create(OntologyClass term) {
        return new DiseaseBuilder(term);
    }

    public static DiseaseBuilder create(String id, String label) {
        OntologyClass term = ontologyClass(id, label);
        return new DiseaseBuilder(term);
    }
}