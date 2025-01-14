package org.phenopackets.phenotools.builder.builders;

import org.junit.jupiter.api.Test;
import org.phenopackets.schema.v2.core.Diagnosis;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.phenopackets.phenotools.builder.builders.GenomicInterpretationBuilder.genomicInterpretation;
import static org.phenopackets.phenotools.builder.builders.OntologyClassBuilder.ontologyClass;
import static org.phenopackets.phenotools.builder.builders.VariantInterpretationBuilder.variantInterpretation;

class DiagnosisBuilderTest {

    @Test
    void testDiagnosisBuilder() {
        var variationDescriptor =
                VariationDescriptorBuilder.create("variant id")
                        .heterozygous()
                        .hgvs("NM_014915.2:c.-128G>A")
                        .build();
        var col6a1VariantInterpretation = variantInterpretation(variationDescriptor, Status.pathogenic());
        var genomicInterpretation =
                genomicInterpretation("genomic interpretation id", Status.causative(), col6a1VariantInterpretation);
        var thrombocytopenia2 = ontologyClass("OMIM:188000", "Thrombocytopenia 2");
        Diagnosis diagnosis = DiagnosisBuilder.diagnosis(thrombocytopenia2, genomicInterpretation);
        assertThat(diagnosis.getDisease(), equalTo(thrombocytopenia2));
        assertThat(diagnosis.getGenomicInterpretationsList(), equalTo(List.of(genomicInterpretation)));
    }

    @Test
    void testDiagnosisBuilderMinimalData() {
        var thrombocytopenia2 = ontologyClass("OMIM:188000", "Thrombocytopenia 2");
        Diagnosis diagnosis = DiagnosisBuilder.diagnosis(thrombocytopenia2);
        assertThat(diagnosis.getDisease(), equalTo(thrombocytopenia2));
        assertThat(diagnosis.getGenomicInterpretationsCount(), equalTo(0));
    }
}