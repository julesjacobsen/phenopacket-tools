package org.phenopackets.phenotools.builder.builders;

import org.phenopackets.schema.v2.core.*;

import java.util.List;

public class MedicalActionBuilder {

    private final MedicalAction.Builder builder;

    private MedicalActionBuilder(Procedure procedure) {
        builder = MedicalAction.newBuilder().setProcedure(procedure);
    }

    private MedicalActionBuilder(Treatment treatment) {
        builder = MedicalAction.newBuilder().setTreatment(treatment);
    }

    private MedicalActionBuilder(RadiationTherapy rxTherapy) {
        builder = MedicalAction.newBuilder().setRadiationTherapy(rxTherapy);
    }

    private MedicalActionBuilder(TherapeuticRegimen regimen) {
        builder = MedicalAction.newBuilder().setTherapeuticRegimen(regimen);
    }

    public static MedicalAction procedure(Procedure procedure) {
        return MedicalAction.newBuilder().setProcedure(procedure).build();
    }

    public static MedicalAction treatment(Treatment treatment) {
        return MedicalAction.newBuilder().setTreatment(treatment).build();
    }

    public static MedicalAction radiationTherapy(RadiationTherapy rxTherapy) {
        return MedicalAction.newBuilder().setRadiationTherapy(rxTherapy).build();
    }

    public static MedicalAction therapeuticRegimen(TherapeuticRegimen regimen) {
        return MedicalAction.newBuilder().setTherapeuticRegimen(regimen).build();
    }

    public static MedicalActionBuilder create(Procedure procedure) {
        return new MedicalActionBuilder(procedure);
    }

    public static MedicalActionBuilder create(Treatment treatment) {
        return new MedicalActionBuilder(treatment);
    }

    public static MedicalActionBuilder create(RadiationTherapy rxTherapy) {
        return new MedicalActionBuilder(rxTherapy);
    }

    public static MedicalActionBuilder create(TherapeuticRegimen regimen) {
        return new MedicalActionBuilder(regimen);
    }

    public MedicalActionBuilder treatmentTarget(OntologyClass target) {
        builder.setTreatmentTarget(target);
        return this;
    }

    public MedicalActionBuilder treatmentIntent(OntologyClass intent) {
        builder.setTreatmentIntent(intent);
        return this;
    }

    public MedicalActionBuilder responseToTreatment(OntologyClass response) {
        builder.setResponseToTreatment(response);
        return this;
    }

    public MedicalActionBuilder adverseEvent(OntologyClass event) {
        builder.addAdverseEvents(event);
        return this;
    }

    public MedicalActionBuilder allAdverseEvents(List<OntologyClass> events) {
        builder.addAllAdverseEvents(events);
        return this;
    }

    public MedicalActionBuilder treatmentTerminationReason(OntologyClass reason) {
        builder.setTreatmentTerminationReason(reason);
        return this;
    }

    public MedicalAction build() {
        return builder.build();
    }
}
