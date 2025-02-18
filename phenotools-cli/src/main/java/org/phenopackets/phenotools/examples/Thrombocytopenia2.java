package org.phenopackets.phenotools.examples;

import org.phenopackets.phenotools.builder.PhenopacketBuilder;
import org.phenopackets.phenotools.builder.builders.*;
import org.phenopackets.schema.v2.Phenopacket;

import static org.phenopackets.phenotools.builder.builders.DiagnosisBuilder.diagnosis;
import static org.phenopackets.phenotools.builder.builders.GenomicInterpretationBuilder.genomicInterpretation;
import static org.phenopackets.phenotools.builder.builders.InterpretationBuilder.interpretation;
import static org.phenopackets.phenotools.builder.builders.OntologyClassBuilder.ontologyClass;
import static org.phenopackets.phenotools.builder.builders.VariantInterpretationBuilder.variantInterpretation;

class Thrombocytopenia2 implements PhenopacketExample {
    private static final String PHENOPACKET_ID = "id-C";
    private static final String INTERPRETATION_ID = "arbitrary interpretation id";
    private static final String PROBAND_ID = "family 10 proband";

    private final Phenopacket phenopacket;

    Thrombocytopenia2() {
        var authorAssertion = EvidenceBuilder.authorStatementEvidence("PMID:21211618", "Mutations in the 5' UTR of ANKRD26, the ankirin repeat domain 26 gene, cause an autosomal-dominant form of inherited thrombocytopenia, THC2");
        var thrombocytopenia2 = ontologyClass("OMIM:188000", "Thrombocytopenia 2");
        var individual = IndividualBuilder.create(PROBAND_ID).female().ageAtLastEncounter("P20Y").build();
        var metaData = MetaDataBuilder.create("2021-05-14T10:35:00Z", "anonymous biocurator")
                .resource(Resources.hpoVersion("2021-08-02"))
                .resource(Resources.genoVersion("2020-03-08"))
                .externalReference(authorAssertion.getReference())
                .build();
        var variationDescriptor =
                VariationDescriptorBuilder.create("variant id")
                        .heterozygous()
                        .hgvs("NM_014915.2:c.-128G>A")
                        .build();
        var col6a1VariantInterpretation = variantInterpretation(variationDescriptor, Status.pathogenic());
        var genomicInterpretation =
                genomicInterpretation("genomic interpretation id", Status.causative(), col6a1VariantInterpretation);
        var diagnosis = diagnosis(thrombocytopenia2, genomicInterpretation);
        var interpretation = interpretation(INTERPRETATION_ID, Status.completed(), diagnosis);
        var excludedAbnormalPlateletSize =
                PhenotypicFeatureBuilder.create("HP:0011876", "Abnormal platelet volume")
                        .excluded()
                        .evidence(authorAssertion)
                        .build();
        var brusing =
                PhenotypicFeatureBuilder.create("HP:0000978", "Bruising susceptibility")
                        .evidence(authorAssertion)
                        .build();
        phenopacket = PhenopacketBuilder.create(PHENOPACKET_ID, metaData)
                .individual(individual)
                .phenotypicFeature(excludedAbnormalPlateletSize)
                .phenotypicFeature(brusing)
                .interpretation(interpretation)
                .build();
    }

    @Override
    public Phenopacket getPhenopacket() {
        return phenopacket;
    }
}
